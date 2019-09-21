package array;

public class BestTimeToBuyAndSellStock {
    public static int run(int[] prices) {
        return new BestTimeToBuyAndSellStock().maxProfit(prices);
    }

    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    private int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int priceAtBuyTime = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            if (priceAtBuyTime > currentPrice) {
                priceAtBuyTime = currentPrice;
            }

            int currentProfit = currentPrice - priceAtBuyTime;

            if (currentProfit > profit)
                profit = currentProfit;

        }

        return profit;
    }
}
