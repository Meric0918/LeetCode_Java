package DynamicProgramming;


/**
 * @Author: Meric
 * @CreateTime: 2025-11-03
 * @Description: 1578. 使绳子变成彩色的最短时间
 * @Version: 1.0
 */

public class minimumTimeToMakeRopeColorful_1578 {
    public static int minCost(String colors, int[] neededTime) {
        int[] dp = new int[colors.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if(colors.charAt(i-1) != c){
                    dp[i] = dp[i - 1];
                    max = 0;
            }
            else{
                max = Math.max(neededTime[i-1],max);
                if(neededTime[i] > max){
                    dp[i] = dp[i-1] + max;
                    max = neededTime[i];
                }
                else{
                    dp[i] = dp[i-1] + neededTime[i];
                }
            }
        }
        return dp[colors.length()-1];
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = new int[]{1,2,3,4,5};
        System.out.println(minCost(colors, neededTime));
    }
}
