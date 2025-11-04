package HashTable;


/**
 * @Author: Meric
 * @CreateTime: 2025-10-30
 * @Description: 242. 有效的字母异位词
 * @Version: 1.0
 */

/**
 * 构建一个数组arr[26]，每个字母对应一个位置，其中元素代表字符串的个数，对于s中的元素对应的字母个数++，再对于t中的元素对应的字母个数--，最后判断元素是否全为0
 */

public class validAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length()){
            return false;
        }
        int[] arr = new int[26];
        //s中的元素对应的字母个数++
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        //t中的元素对应的字母个数--
        for (int i = 0; i < len; i++) {
            arr[t.charAt(i) - 'a']--;
        }
        //遍历arr，存在非零元素直接返回false
        for (int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
