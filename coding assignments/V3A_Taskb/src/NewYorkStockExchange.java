public class NewYorkStockExchange implements StockExchange {
    @Override
    public double getPrice(String stockName) {
        switch (stockName) {
            case "Microsoft":
                return 80.0;  // in USD
            case "Apple":
                return 140.0; // in USD
            default:
                return 0.0;
        }
    }
}