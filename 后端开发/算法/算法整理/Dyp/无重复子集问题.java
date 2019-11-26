package Dyp;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Dyp.无重复子集问题
 * @description
 * Mike is a lawyer with the gift of photographic memory.
 * He is so good with it that he can tell you all the numbers on a sheet of paper by having a look at it without any mistake.
 * Mike is also brilliant with subsets so he thought of giving a challange based on his skill and knowledge to Rachael.
 * Mike knows how many subset are possible in an array of N integers. The subsets may or may not have the different sum.
 * The challenge is to find the maximum sum produced by any subset under the condition:
 *
 * The elements present in the subset should not have any digit in common.
 *
 * Note: Subset {12, 36, 45} does not have any digit in common and Subset {12, 22, 35} have digits in common.
 * Rachael find it difficult to win the challenge and is asking your help. Can youhelp her out in winning this challenge?
 *
 *
 * Input
 * First Line of the input consist of an integer T denoting the number of test cases. Then T test cases follow.
 * Each test case consist of a numbe N denoting the length of the array. Second line of each test case consist of N space separated integers denoting the array elements.
 *
 * Constraints:
 *
 * 1 <= T <= 100
 *
 * 1 <= N <= 100
 *
 * 1 <= array elements <= 100000
 *
 *
 * Output
 * Corresponding to each test case, print output in the new line.
 *
 *
 * Sample Input 1
 * 1
 * 3
 * 12 22 35
 * Sample Output 1
 * 57
 * @date 2019-11-25 23:12
 */
public class 无重复子集问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(sum(num, "", nums));
        }
    }

    private static int sum(int n, String trace, int[] nums) {
        if (n == 0) {
            return 0;
        }

        for (String s : String.valueOf(nums[n - 1]).split("|")) {
            if (trace.contains(s)) {
                return sum(n - 1, trace, nums);
            }
        }
        return Math.max(sum(n - 1, trace, nums), sum(n - 1, trace + nums[n - 1], nums) + nums[n - 1]);
    }
}
