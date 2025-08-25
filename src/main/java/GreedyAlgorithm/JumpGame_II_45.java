package GreedyAlgorithm;


/**
 * @Author: Meric
 * @CreateTime: 2025-08-25
 * @Description: 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/description/
 * @Version: 1.0
 */

/**
 *  （1）计算每一步的可以达到的最远距离
 *  （2）如果移动下标达到了当前这一步的最大覆盖最远距离了，还没有到终点的话，那么就必须再走一步来增加覆盖范围，直到覆盖范围覆盖了终点。
 */

public class JumpGame_II_45 {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //记录当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //计算每个格子可以达到的最远距离
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;    //加上这最后一步
                break;
            }
            //已经走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
