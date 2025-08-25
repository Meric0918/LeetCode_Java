package GreedyAlgorithm;


/**
 * @Author: Meric
 * @CreateTime: 2025-08-20
 * @Description: 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * @Version: 1.0
 */

public class maxSubArray_53 {
    public static int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i],sum[i-1] + nums[i]);
            res = Math.max(res,sum[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
