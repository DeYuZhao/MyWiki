package Array;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.数组和窗口
 * @description
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 * @date 2019-11-25 19:56
 */
public class 数组和窗口 {
    public static void main(String args[]) {
        getSumOfWindowMax();
    }

    private static void getSumOfWindowMax()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] string = sc.nextLine().split(" ");
            int[] array = new int[string.length];
            int windowSize = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < string.length; ++j)
            {
                array[j] = Integer.parseInt(string[j]);
            }

            int[] maxArray = new int[string.length - windowSize + 1];
            for (int j = 0; j < string.length - windowSize + 1; ++j)
            {
                int max = 0;
                for (int k = j; k < j + windowSize; ++k)
                {
                    if (array[k] > max)
                    {
                        max = array[k];
                    }
                }
                maxArray[j] = max;
            }

            int res = 0;
            for (int num : maxArray)
            {
                res += num;
            }

            System.out.println(res);
        }
    }
}
