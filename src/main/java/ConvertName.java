/**
 * @Author: Meric
 * @CreateTime: 2025-11-03
 * @Description:
 * @Version: 1.0
 */

public class ConvertName {
    public static String toCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                nextUpperCase = true;
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(ch));
                    nextUpperCase = false;
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "find-x-sum-of-all-k-long-subarrays-i";
        String result = toCamelCase(input);
        System.out.println(result); // 输出: minimumTimeToMakeRopeColorful
    }
}
