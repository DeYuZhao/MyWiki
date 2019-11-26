package Array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.子数组的取值范围
 * @description
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 * @date 2019-11-25 20:01
 */
public class 子数组的取值范围 {
    public static void main(String args[]) {
        getSubArrayNum();
    }

    private static void getSubArrayNum()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] string = sc.nextLine().split(" ");
            ArrayList<Integer> array = new ArrayList<>();
            for (String str : string)
            {
                array.add(Integer.parseInt(str));
            }
            int num = Integer.parseInt(sc.nextLine());

            Deque<Integer> min = new LinkedList<>();
            Deque<Integer> max = new LinkedList<>();

            int left = 0, right = 0, res = 0;
            while (left < array.size())
            {
                while (right < array.size())
                {
                    while (!min.isEmpty() && array.get(right) <= min.peekLast())
                    {
                        min.pollLast();
                    }
                    min.addLast(array.get(right));
                    while (!max.isEmpty() && array.get(right) >= max.peekLast())
                    {
                        max.pollLast();
                    }
                    max.addLast(array.get(right));
                    if (max.peekFirst() - min.peekFirst() > num)
                    {
                        break;
                    }
                    right++;
                }

                res += array.size() - right;
                if (min.peekFirst() == array.get(left).intValue())
                {
                    min.pollFirst();
                }
                if (max.peekFirst() == array.get(left).intValue())
                {
                    max.pollFirst();
                }
                left++;
            }
            System.out.println(res);
        }
    }
}
