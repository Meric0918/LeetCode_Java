package slidingWindow;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @Author: Meric
 * @CreateTime: 2025-11-04
 * @Description: 56. 合并区间
 * @Version: 1.0
 */

/**
 * 类似滑动窗口，先根据begin排序，不断比较后续begin与设定的end（end总是区遍历所有区间的endMax）的大小关系，判断是否需要改变begin
 * 一旦修改了begin，就需要将之前的begin与end加入res
 */

public class mergeIntervals_56 {
    public static int[][] merge(int[][] intervals) {
        int begin = 0;
        int end = 0;
        List<int[]> res = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            begin = intervals[i][0];
            end = intervals[i][1];
            list.add(Map.entry(begin,end));
        }

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey()); // key 升序
            }
        });
        begin = list.get(0).getKey();
        end = list.get(0).getValue();
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getKey() <= end){
                end = Math.max(list.get(i).getValue(),end);
            }
            else{
                int[] temp = new int[2];
                temp[0] = begin;
                temp[1] = end;
                res.add(temp);
                begin = list.get(i).getKey();
                end = list.get(i).getValue();
            }
        }
        int[] temp = new int[2];
        temp[0] = begin;
        temp[1] = end;
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " | "+ res[i][1]);
        }
    }


}
