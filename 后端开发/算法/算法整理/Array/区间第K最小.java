package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.区间第K最小
 * @description
 * 找到给定数组的给定区间内的第K小的数值。
 * @date 2019-11-25 20:02
 */
public class 区间第K最小 {
    public static void main(String args[]) {
        getKMinOfInteval();
    }

    private static void getKMinOfInteval()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] string = sc.nextLine().split(" ");
            LinkedList<Integer> array = new LinkedList<>();
            String[] interval = sc.nextLine().split(" ");
            int left = Integer.parseInt(interval[0]);
            int right = Integer.parseInt(interval[1]);
            int level = Integer.parseInt(sc.nextLine());

            for (int j = left-1; j <= right-1; ++j)
            {
                array.add(Integer.parseInt(string[j]));
            }

            ArrayList<Integer> list = new ArrayList<>();
            while (list.size() < right - left - level + 2)
            {
                int max = -1, index = -1;
                for (int j = 0; j < array.size(); ++j)
                {
                    if (array.get(j) > max)
                    {
                        max = array.get(j);
                        index = j;
                    }
                }
                list.add(max);
                array.remove(index);
            }

            System.out.println(list.get(list.size() - 1));
        }
    }
}
