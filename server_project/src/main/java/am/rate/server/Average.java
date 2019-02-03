package am.rate.server;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "average")
//@SQLInsert(sql = "INSERT INTO average (usd_buy, usd_sell, eur_buy, eur_sell, rur_buy, rur_sell, gbp_buy, gbp_sell) " +
//        " values ( ?, ?, ?, ?, ?, ?, ?, ?)" +
//        " ON DUPLICATE KEY UPDATE usd_buy = (usd_buy + ?) / 2 , usd_sell = (usd_sell + ?) / 2 ," +
//        " eur_buy = (eur_buy + ?) / 2 , eur_sell = (eur_sell + ?) / 2 ," +
//        " rur_buy = (rur_buy + ?) / 2 , rur_sell = (rur_sell + ?) / 2 ," +
//        " gbp_buy = (gbp_buy + ?) / 2 , gbp_sell = (gbp_sell + ?) / 2")
@SQLUpdate(sql = "UPDATE average SET usd_buy = (usd_buy + ?) / 2 , usd_sell = (usd_sell + ?) / 2 ," +
        " eur_buy = (eur_buy + ?) / 2 , eur_sell = (eur_sell + ?) / 2 ," +
        " rur_buy = (rur_buy + ?) / 2 , rur_sell = (rur_sell + ?) / 2 ," +
        " gbp_buy = (gbp_buy + ?) / 2 , gbp_sell = (gbp_sell + ?) / 2 WHERE day = ?")
public class Average implements Serializable {
    @Id
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day = new Date();
    @Column(name = "usd_buy")
    private BigDecimal a_usdBuy;
    @Column(name = "usd_sell")
    private BigDecimal b_usdSell;
    @Column(name = "eur_buy")
    private BigDecimal c_eurBuy;
    @Column(name = "eur_sell")
    private BigDecimal d_eurSell;
    @Column(name = "rur_buy")
    private BigDecimal e_rurBuy;
    @Column(name = "rur_sell")
    private BigDecimal f_rurSell;
    @Column(name = "gbp_buy")
    private BigDecimal g_gbpBuy;
    @Column(name = "gbp_sell")
    private BigDecimal h_gbpSell;

    public Average() {
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public BigDecimal getA_usdBuy() {
        return a_usdBuy;
    }

    public void setA_usdBuy(BigDecimal a_usdBuy) {
        this.a_usdBuy = a_usdBuy;
    }

    public BigDecimal getB_usdSell() {
        return b_usdSell;
    }

    public void setB_usdSell(BigDecimal b_usdSell) {
        this.b_usdSell = b_usdSell;
    }

    public BigDecimal getC_eurBuy() {
        return c_eurBuy;
    }

    public void setC_eurBuy(BigDecimal c_eurBuy) {
        this.c_eurBuy = c_eurBuy;
    }

    public BigDecimal getD_eurSell() {
        return d_eurSell;
    }

    public void setD_eurSell(BigDecimal d_eurSell) {
        this.d_eurSell = d_eurSell;
    }

    public BigDecimal getE_rurBuy() {
        return e_rurBuy;
    }

    public void setE_rurBuy(BigDecimal e_rurBuy) {
        this.e_rurBuy = e_rurBuy;
    }

    public BigDecimal getF_rurSell() {
        return f_rurSell;
    }

    public void setF_rurSell(BigDecimal f_rurSell) {
        this.f_rurSell = f_rurSell;
    }

    public BigDecimal getG_gbpBuy() {
        return g_gbpBuy;
    }

    public void setG_gbpBuy(BigDecimal g_gbpBuy) {
        this.g_gbpBuy = g_gbpBuy;
    }

    public BigDecimal getH_gbpSell() {
        return h_gbpSell;
    }

    public void setH_gbpSell(BigDecimal h_gbpSell) {
        this.h_gbpSell = h_gbpSell;
    }

    @Override
    public String toString() {
        return "Average{" +
                "day=" + day +
                ", a_usdBuy=" + a_usdBuy +
                ", b_usdSell=" + b_usdSell +
                ", c_eurBuy=" + c_eurBuy +
                ", d_eurSell=" + d_eurSell +
                ", e_rurBuy=" + e_rurBuy +
                ", f_rurSell=" + f_rurSell +
                ", g_gbpBuy=" + g_gbpBuy +
                ", h_gbpSell=" + h_gbpSell +
                '}';
    }
}
