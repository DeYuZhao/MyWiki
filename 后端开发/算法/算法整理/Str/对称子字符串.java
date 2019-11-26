package Str;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Str.对称子字符串
 * @description
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’,
 * such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 * @date 2019-11-25 22:43
 */
public class 对称子字符串 {
    public static void main(String args[]) {
        getEqualSubString(new Scanner(System.in));
    }

    public static void getEqualSubString(Scanner sc)
    {
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum-- > 0)
        {
            String[] input = sc.nextLine().split("");
            int left = 0, maxLen = 0;
            while (left < input.length)
            {
                int right = left + 1;
                while (right < input.length)
                {
                    int mid = (left + right) / 2;
                    int leftSum = 0, rightSum = 0;
                    for (int i = left; i <= mid; ++i)
                    {
                        leftSum += Integer.parseInt(input[i]);
                    }
                    for (int i = mid + 1; i <= right; ++i)
                    {
                        rightSum += Integer.parseInt(input[i]);
                    }
                    if (leftSum == rightSum && (right - left + 1) > maxLen)
                    {
                        maxLen = right - left + 1;
                    }
                    right += 2;
                }
                left++;
            }
            System.out.println(maxLen);
        }
    }
}
