package Lesson9_lab9_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);


        System.out.println("===============================================");
        // Query 2: What are all the unique cities where the traders work?
        transactions.stream()
                .map(Transaction -> Transaction.getTrader().getCity())
                .distinct()   //to remove duplicates
                .forEach(System.out::println);

        System.out.println("==============================================");
        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(Transaction::getTrader)
                //.map(Transaction->Transaction.getTrader().getCity().equals("Cambridge"))
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        //  .sorted(Comparator.comparing(Transaction::getTrader).thenComparing(Trader::getCity);


        System.out.println("==================================================");
        // Query 4: Return a string of all traders names sorted alphabetically.
        String tradersName = transactions.stream()
                .map(Transaction::getTrader)
//                .sorted(Comparator.comparing(Trader::getName))
//                .forEach(System.out::println);
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(tradersName);


        System.out.println("====================================================");
        // Query 5: Are there any trader based in Milan?
        boolean traderInMilan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny()
                .isPresent();
        System.out.println(traderInMilan);

//        boolean anyTraderInMilan = transactions.stream()
//                .map(Transaction::getTrader)
//                .anyMatch(trader -> trader.getCity().equals("Milan"));
//        System.out.println("Traders based in Milan: " + anyTraderInMilan);


        System.out.println("=====================================================");
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));
        transactions.forEach(System.out::println);


        System.out.println("=====================================================");
        // Query 7: What's the highest value in all the transactions?
        IntSummaryStatistics summ = transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println("Highest value = " + summ.getMax());
    }
}
