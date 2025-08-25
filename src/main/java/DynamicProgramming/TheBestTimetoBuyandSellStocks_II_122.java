package DynamicProgramming;


/**
 * @Author: Meric
 * @CreateTime: 2025-08-21
 * @Description: 122. 买卖股票的最佳时机 II (动态规划)
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @Version: 1.0
 */

/**
 * dp[i][0] 表示第i天持有股票所得现金
 * dp[i][1] 表示第i天不持有股票所得最多现金
 */

/**
 * 第i天持有股票所得现金：
 *      （1）：第i天持有股票所得现金
 *      （2）：第i天没有持有股票所得现金 - 买第i天股票花掉的现金
 * 第i天不持有股票所得现金：
 *      （1）：第i-1天不持有股票所得现金
 *      （2）：第i天持有股票所得现金 + 将第i-1天的股票卖掉的现金
 * 求最后一天不持有股票最大的现金
 */

public class TheBestTimetoBuyandSellStocks_II_122 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        int num = 0;
        dp[0][0] = num - prices[0];
        dp[0][1] = num;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[len - 1][1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

