public class PortfolioTest {
    public static void main(String[] args) {
        // Zurich Stock Exchange
        StockExchange zurichExchange = new ZurichStockExchange();
        Portfolio zurichPortfolio = new Portfolio(zurichExchange);
        zurichPortfolio.addStock("Microsoft", 10);
        zurichPortfolio.addStock("Apple", 5);
        System.out.println("Zurich Portfolio Value: " + zurichPortfolio.calculateTotalValue() + " CHF");

        // New York Stock Exchange
        StockExchange newYorkExchange = new NewYorkStockExchange();
        Portfolio newYorkPortfolio = new Portfolio(newYorkExchange);
        newYorkPortfolio.addStock("Microsoft", 10);
        newYorkPortfolio.addStock("Apple", 5);
        System.out.println("New York Portfolio Value: " + newYorkPortfolio.calculateTotalValue() + " USD");

        // London Stock Exchange
        StockExchange londonExchange = new LondonStockExchange();
        Portfolio londonPortfolio = new Portfolio(londonExchange);
        londonPortfolio.addStock("Microsoft", 10);
        londonPortfolio.addStock("Apple", 5);
        System.out.println("London Portfolio Value: " + londonPortfolio.calculateTotalValue() + " GBP");
    }
}
