package HashTable;


import java.util.*;

/**
 * @Author: Meric
 * @CreateTime: 2025-11-04
 * @Description: 3318. 计算子数组的 x-sum I
 * @Version: 1.0
 */

public class findXSumOfAllKLongSubarraysI_3318 {
    public static int[] findXSum(int[] nums, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int[] arr = splitArray(nums,k,i);
            xSum(arr,x);
            list.add(xSum(arr,x));
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static int[] splitArray(int[] nums, int k, int begin){
        if((begin + k) > nums.length){
            return null;
        }
        int[] arr = new int[k];
        int j = 0;
        for (int i = begin; i < begin + k; i++) {
            arr[j] = nums[i];
            j++;
        }
        return arr;
    }

    public static int xSum(int[] arr, int x){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i : arr){
            if(map.containsKey(i)){
                int num = map.get(i);
                num++;
                map.put(i,num);
            }
            else{
                map.put(i,1);
            }
            sum += i;
        }

        //如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
        int keyCount = map.size();
        if(keyCount < x){
            return sum;
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> {
            int valueCompare = e2.getValue().compareTo(e1.getValue()); // value 降序
            if (valueCompare != 0) {
                return valueCompare;
            }
            return e2.getKey().compareTo(e1.getKey()); // key 降序
        });
        sum = 0;
        for (Map.Entry<Integer, Integer> m : list){
            sum += m.getKey() * m.getValue();
            x--;
            if(x == 0){
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,4,2,3};
        System.out.println(findXSum(nums, 6, 2));

    }

}
