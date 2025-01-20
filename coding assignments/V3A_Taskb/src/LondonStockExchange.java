public class LondonStockExchange implements StockExchange {
    @Override
    public double getPrice(String stockName) {
        switch (stockName) {
            case "Microsoft":
                return 75.0;  // in GBP
            case "Apple":
                return 130.0; // in GBP
            default:
                return 0.0;
        }
    }
}