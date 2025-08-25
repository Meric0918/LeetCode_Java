package GreedyAlgorithm;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Meric
 * @CreateTime: 2025-08-20
 * @Description: 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 * @Version: 1.0
 */

public class distributeCookies_455 {

    public static int findContentChildren(int[] g, int[] s) {
        //g与s都升序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = g.length - 1;
        int cookieIndex = s.length - 1;
        int count= 0;


        while(cookieIndex >= 0 && childIndex >= 0){
            //饼干可以满足孩子胃口
            if(s[cookieIndex] >= g[childIndex]){
                count++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g ={1,2};
        int[] s ={1,2,3};
        System.out.println(findContentChildren(g, s));
    }

}
