package GreedyAlgorithm;


/**
 * @Author: Meric
 * @CreateTime: 2025-08-21
 * @Description: 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/
 * @Version: 1.0
 */

/**
 * 查看每个元素加上其可以达到的最远位置，然后记住所有元素可以达到的最远位置，如果此位置可以抵达终点则可以，否则不可以。
 * 为了抵达终点，每个元素都贪婪的达到最远，如果遍历了全部元素都不可以就代表无法抵达终点
 */
public class JumpGame_55 {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i],cover);
            if(cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,8,2,0,0,1};
        System.out.println(canJump(nums));
    }
}
 