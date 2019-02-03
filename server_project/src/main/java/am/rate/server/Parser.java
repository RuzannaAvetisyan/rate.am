package am.rate.server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    protected static Document document = null;
    protected static List<CurrencyTable> courseList = new ArrayList();

    public static List pars(String http) {
        try {
            document = Jsoup.connect(http).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> currencys = document.getElementById("ctl00_Content_RB_dlCurrency1").getElementsByTag("option")
                .stream().map(Element::text).collect(Collectors.toList());

        for (String currency : currencys) {
            try {
                document = Jsoup.connect(http).cookie("Cookie.CurrencyList", currency + ",1 EUR,1 RUR,1 GBP").get();
                Element table = document.getElementById("rb");
                Elements rows = table.select("tr");

                for (int i = 2; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    Elements cols = row.select("td");
                    try {
                        if (cols.get(0).text().equals("Minimum") || cols.get(0).text().equals("Maximum") ||
                                cols.get(0).text().equals("Average") || cols.get(0).text().contains("Fluctuation")) {
                            break;
                        }
                        courseList.stream().filter(obj -> obj.getCompanyName().equals(cols.get(1).text()))
                                .findFirst()
                                .map(obj -> {
                                    obj.getBuy().put(currency, floatParser(cols.get(5).text()));
                                    obj.getSell().put(currency, floatParser(cols.get(6).text()));
                                    return obj;
                                })
                                .orElseGet(() -> {
                                    courseList.add(new CurrencyTable(cols.get(1).text(),
                                            new HashMap() {{ put(currency, floatParser(cols.get(5).text())); }},
                                            new HashMap() {{ put(currency, floatParser(cols.get(6).text())); }}));
                                    return new CurrencyTable();
                                });

                    } catch (IndexOutOfBoundsException e) { }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return courseList;
    }

    private static Float floatParser(String text) {
        if (text.equals("")) return null;
        else return Float.parseFloat(text);
    }

}
