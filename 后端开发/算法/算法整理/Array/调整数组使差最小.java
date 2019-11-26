package Array;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.调整数组使差最小
 * @description
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。
 * @date 2019-11-25 20:07
 */
public class 调整数组使差最小 {
    public static void main(String args[]) {
        getMinDValue();
    }

    private static void getMinDValue()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] stringA = sc.nextLine().split(" ");
            String[] stringB = sc.nextLine().split(" ");
            int[] array = new int[2*stringA.length];

            for (int j = 0; j < stringA.length; ++j)
            {
                array[j] = Integer.parseInt(stringA[j]);
            }

            for (int j = 0; j < stringB.length; ++j)
            {
                array[j+stringA.length] = Integer.parseInt(stringB[j]);
            }

            int sum = 0;
            for (int j = 0; j < array.length; ++j)
            {
                sum += array[j];
            }

            boolean[][] dp = new boolean[stringA.length+1][sum/2+1];

            dp[0][0] = true;
            for (int j = 1;  j <= array.length; ++j)
            {
                for (int k = Math.min(j, array.length / 2); k >= 1; --k)
                {
                    for (int s = 1; s <= sum / 2; ++s)
                    {
                        if (s >= array[j-1] && dp[k-1][s-array[j-1]])
                        {
                            dp[k][s] = true;
                        }
                    }
                }
            }

            int s = sum / 2;
            while (s >= 1 && !dp[array.length / 2][s])
            {
                s--;
            }

            System.out.println(sum - 2 * s);
        }
    }
}
