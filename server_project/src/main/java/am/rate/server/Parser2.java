package am.rate.server;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

class Parser2 {
    static void pars() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Ruzanna/Desktop/rate_am/server_project/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        System.setProperty("phantomjs.binary.path", "C:/Users/Ruzanna/Desktop/rate_am/server_project/src/main/resources/phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver();
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
            driver.get("http://rate.am/en/armenian-dram-exchange-rates/banks/non-cash");
            List<CurrencyTable> currencyTables = new ArrayList<>();
            List<String> currency = driver.findElement(By.id("ctl00_Content_RB_dlCurrency1"))
                    .findElements(By.tagName("option"))
                    .stream().map(WebElement::getText).collect(Collectors.toList());
//        List<String> cur = (new Select(driver.findElement(By.id("ctl00_Content_RB_dlCurrency1")))).getOptions()
//                .stream().map(WebElement::getText).collect(Collectors.toList());
//        cur.forEach(System.out::println);
            for (int j = 0; j < currency.size(); j++) {
                String currencyName = currency.get(j);

                Select dropdown = new Select(driver.findElement(By.id("ctl00_Content_RB_dlCurrency1")));
                dropdown.selectByIndex(j);

//                WebElement webElement = (new WebDriverWait(driver, 20,500)
//                        .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
//                        .until(ExpectedConditions.presenceOfElementLocated((By.id("rb")))));
                WebElement webElement = driver.findElement(By.id("rb"));
                List<WebElement> row = webElement.findElements(By.tagName("tr"));

                for (int i = 2; i < row.size(); i++) {
                    List<WebElement> cols = row.get(i).findElements(By.tagName("td"));
                    if (cols.get(0).getText().equals("Minimum") || cols.get(0).getText().equals("Maximum") ||
                            cols.get(0).getText().equals("Average") || cols.get(0).getText().contains("Fluctuation")) {
                        break;
                    }
                    try {
                        currencyTables.stream().filter(obj -> obj.getCompanyName().equals(cols.get(1).getText()))
                                .findFirst()
                                .map(obj -> {
                                    obj.getBuy().put(currencyName, floatParser(cols.get(5).getText()));
                                    obj.getSell().put(currencyName, floatParser(cols.get(6).getText()));
                                    return obj;
                                })
                                .orElseGet(() -> {
                                    currencyTables.add(new CurrencyTable(cols.get(1).getText(),
                                            new HashMap() {{
                                                put(currencyName, floatParser(cols.get(5).getText()));
                                            }},
                                            new HashMap() {{
                                                put(currencyName, floatParser(cols.get(6).getText()));
                                            }}));
                                    return new CurrencyTable();
                                });
                    } catch (IndexOutOfBoundsException ex) {
                    }
                }
            }
            currencyTables.forEach(System.out::println);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } finally {
            System.out.println("quit");
            driver.quit();
        }
    }

    private static Float floatParser(String text) {
        if (text.equals("")) return null;
        else return Float.parseFloat(text);
    }
}
