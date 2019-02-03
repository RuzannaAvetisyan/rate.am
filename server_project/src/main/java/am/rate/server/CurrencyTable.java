package am.rate.server;


import java.util.HashMap;
import java.util.Objects;

public class CurrencyTable {
    private String companyName;
    private HashMap<String, Float> buy = new HashMap<>();
    private HashMap<String, Float> sell = new HashMap<>();

    public CurrencyTable() {
    }

    public CurrencyTable(String companyName) {
        this.companyName = companyName;
    }

    public CurrencyTable(String companyName, HashMap<String, Float> buy, HashMap<String, Float> sell) {
        this.companyName = companyName;
        this.buy = buy;
        this.sell = sell;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public HashMap<String, Float> getBuy() {
        return buy;
    }

    public void setBuy(HashMap<String, Float> buy) {
        this.buy = buy;
    }

    public HashMap<String, Float> getSell() {
        return sell;
    }

    public void setSell(HashMap<String, Float> sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "CurrencyTable{" + companyName + '\'' +
                ", buy=" + buy.toString() +
                ", sell=" + sell.toString() +
                '}';
    }
}
