package HashTable;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Meric
 * @CreateTime: 2025-11-01
 * @Description: 56. 合并区间
 * @Version: 1.0
 */

/**
 * 将原二位数组中的每个区间起始与末尾*2，放入新的数组哈希表中，然后遍历数组哈希表，遇到连续的区间即为新区间，但是起始与末尾需要/2
 * 将区间长度扩到2倍的原因为，1-3，4-6两个区间没有重叠的，但是在哈希表中显示为连续区间，因此乘以二倍消除特殊情况
 */

public class mergeIntervals_56 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int[] arr = new int[20002];
        int begin = 0;
        int end = 0;
        int len = 0;
        for (int i = 0; i < intervals.length; i++) {
            begin = intervals[i][0] * 2;
            end = intervals[i][1] * 2;
            for (int j = begin; j <= end; j++) {
                arr[j]++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                begin = i;
                while(arr[i] > 0){
                    i++;
                }
                i--;
                end = i;
                int[] temp = new int[2];
                temp[0] = begin / 2;
                temp[1] = end / 2;
                res.add(temp);
                len++;
            }
        }
        return res.toArray(new int[len][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }


}
