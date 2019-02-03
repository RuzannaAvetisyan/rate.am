package am.rate.server;

import java.util.List;

public class Server {

    public static void main(String[] args) {
        List<CurrencyTable> banksNonCash = Parser.pars("http://rate.am/en/armenian-dram-exchange-rates/banks/non-cash");
        banksNonCash.forEach(System.out::println);
//        List<CourseTable> banksCash = Parser.pars("http://rate.am/en/armenian-dram-exchange-rates/banks/cash");
//        List<CourseTable> banksCardTransaction = Parser.pars("http://rate.am/en/armenian-dram-exchange-rates/banks/card-transaction");
//        List<CourseTable> exchangePointsCorporate = Parser.pars("http://rate.am/en/armenian-dram-exchange-rates/exchange-points/cash/corporate");
//        List<CourseTable> exchangePoints = Parser.pars("http://rate.am/en/armenian-dram-exchange-rates/exchange-points/cash/retail");
//        EmailManager.addUser();
        Parser2.pars();
    }
}
