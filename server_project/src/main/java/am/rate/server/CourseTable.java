package am.rate.server;

import java.util.HashMap;

public class CourseTable {
    String bankName;
    Float usdBuy;
    Float usdSell;
    Float eurBuy;
    Float eurSell;
    Float rurBuy;
    Float rurSell;
    Float gbpBuy;
    Float gbpSell;

    public CourseTable(String text) {
    }

    public CourseTable(String bankName, Float usdBuy, Float usdSell, Float eurBuy, Float eurSell, Float rurBuy, Float rurSell, Float gbpBuy, Float gbpSell) {
        this.bankName = bankName;
        this.usdBuy = usdBuy;
        this.usdSell = usdSell;
        this.eurBuy = eurBuy;
        this.eurSell = eurSell;
        this.rurBuy = rurBuy;
        this.rurSell = rurSell;
        this.gbpBuy = gbpBuy;
        this.gbpSell = gbpSell;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public Float getUsdBuy() {
        return usdBuy;
    }

    public void setUsdBuy(Float usdBuy) {
        this.usdBuy = usdBuy;
    }

    public Float getUsdSell() {
        return usdSell;
    }

    public void setUsdSell(Float usdSell) {
        this.usdSell = usdSell;
    }

    public Float getEurBuy() {
        return eurBuy;
    }

    public void setEurBuy(Float eurBuy) {
        this.eurBuy = eurBuy;
    }

    public Float getEurSell() {
        return eurSell;
    }

    public void setEurSell(Float eurSell) {
        this.eurSell = eurSell;
    }

    public Float getRurBuy() {
        return rurBuy;
    }

    public void setRurBuy(Float rurBuy) {
        this.rurBuy = rurBuy;
    }

    public Float getRurSell() {
        return rurSell;
    }

    public void setRurSell(Float rurSell) {
        this.rurSell = rurSell;
    }

    public Float getGbpBuy() {
        return gbpBuy;
    }

    public void setGbpBuy(Float gbpBuy) {
        this.gbpBuy = gbpBuy;
    }

    public Float getGbpSell() {
        return gbpSell;
    }

    public void setGbpSell(Float gbpSell) {
        this.gbpSell = gbpSell;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                " " + bankName + '\'' +
                ",  " + usdBuy +
                ",  " + usdSell +
                ",  " + eurBuy +
                ",  " + eurSell +
                ",  " + rurBuy +
                ",  " + rurSell +
                ",  " + gbpBuy +
                ",  " + gbpSell +
                '}';
    }
}
