import java.util.ArrayList;

/**
 * @Classname LeetCode3
 * @Description 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Date 2019-06-11 19:35
 * @Created by zhaodeyu
 */
public class LeetCode3 {
    public static void main(String args[]) {
        String test = "chgvchfgh";
        System.out.println(lengthOfLongestSubstring(test));
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        ArrayList<String> temp = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (!temp.contains(s.substring(i,i+1))) {
                temp.add(s.substring(i, i+1));
            }else {
                max = (temp.size() > max)?temp.size():max;
                int offset = temp.size() - temp.indexOf(s.substring(i, i+1));
                i = i - offset;
                temp.clear();
            }

        }

        if (temp.size() != 0)
            max = (temp.size() > max)?temp.size():max;

        return max;
    }
}

/**
 * python 解法
 * def lengthOfLongestSubstring(self, s):
 *     temp = {}
 *     i, res = -1, 0
 *     for j in range(len(s)):
 *         if s[j] in temp:
 *             i = max(temp[s[j]], i)
 *         res = max(len(temp), j-i)
 *         temp[s[j]] = j+1
 *     return res
 */