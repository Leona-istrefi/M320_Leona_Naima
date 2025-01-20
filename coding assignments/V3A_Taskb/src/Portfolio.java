import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> stocks; // stock name and quantity
    private StockExchange stockExchange;

    public Portfolio(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
        this.stocks = new HashMap<>();
    }

    public void addStock(String stockName, int quantity) {
        stocks.put(stockName, stocks.getOrDefault(stockName, 0) + quantity);
    }

    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            String stockName = entry.getKey();
            int quantity = entry.getValue();
            totalValue += stockExchange.getPrice(stockName) * quantity;
        }
        return totalValue;
    }
}