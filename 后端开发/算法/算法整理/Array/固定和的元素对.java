package Array;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.固定和的元素对
 * @description
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 * @date 2019-11-25 20:04
 */
public class 固定和的元素对 {
    public static void main(String args[]) {
        getNumOfSum();
    }

    private static void getNumOfSum()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] string = sc.nextLine().split(" ");
            int[] array = new int[string.length];
            for (int j = 0; j < string.length; ++j)
            {
                array[j] = Integer.parseInt(string[j]);
            }

            int sum = Integer.parseInt(sc.nextLine());
            int res = 0;
            for (int j = 0; j < array.length - 1; ++j)
            {
                for (int k = j+1; k < array.length; ++k)
                {
                    if (array[k] + array[j] == sum)
                    {
                        res ++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
