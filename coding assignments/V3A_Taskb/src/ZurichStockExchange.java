public class ZurichStockExchange implements StockExchange {
    @Override
    public double getPrice(String stockName) {
        switch (stockName) {
            case "Microsoft":
                return 90.0;  // in CHF
            case "Apple":
                return 150.0; // in CHF
            default:
                return 0.0;
        }
    }
}

