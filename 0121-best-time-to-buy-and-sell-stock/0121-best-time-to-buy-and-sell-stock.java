class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }

        return result;
    }
}