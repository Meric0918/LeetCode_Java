package GreedyAlgorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Meric
 * @CreateTime: 2025-08-20
 * @Description: 376. 摆动序列
 * @Version: 1.0
 */

public class swingSequence_376 {
    public static int wiggleMaxLength(int[] nums){
        //边界情况
        if(nums.length == 1) return 1;
        if(nums.length == 2){
            if(nums[0] != nums[1]){
                return 2;
            }
            else{
                return 1;
            }
        }

        //对nums数组进行相邻元素去重
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        int[] newnums = Arrays.copyOf(nums, j + 1);

        if(newnums.length == 1) return 1;

        int len = newnums.length - 1;
        int[] minus = new int[len];

        for (int i = 0; i < newnums.length - 1; i++) {
            minus[i] = newnums[i + 1] - newnums[i];
        }

        int [] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            if(minus[i] * minus[i-1] < 0) {
                res[i] = res[i - 1] + 1;
            }
            else{
                res[i] = res[i - 1];
            }
        }

        return res[len - 1]+ 1;
    }

    public static int[] removeConsecutiveDuplicatesInPlaceStyle(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int j = 0; // 指向结果数组的最后一个位置

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        return Arrays.copyOf(arr, j + 1); // 截取有效部分
    }

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }
}
