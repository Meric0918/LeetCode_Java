package GreedyAlgorithm;


/**
 * @Author: Meric
 * @CreateTime: 2025-08-21
 * @Description: 122. 买卖股票的最佳时机 II （贪心算法）
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @Version: 1.0
 */

/**
 * 本题可以多次买卖股票，可以画出每天股票的折线图，可以看出向上的片段即可获得收益。
 * 因此可以将全部时间进行分割，只要相邻时间的收益为正，就可以买股票
 */

public class TheBestTimetoBuyandSellStocks_II_122 {
    public static int maxProfit(int[] prices) {
        int len = prices.length - 1;
        int[] minus = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            minus[i] = prices[i + 1] - prices[i];
            sum += (minus[i] > 0 ? minus[i] : 0);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}

