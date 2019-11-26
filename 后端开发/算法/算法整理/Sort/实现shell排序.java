package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Sort.实现shell排序
 * @description TODO
 * @date 2019-11-26 21:45
 */
public class 实现shell排序 {
    private static void shellSort(int[] nums, int step) {
        for (int i = 0; i < step; i++) {
            List<Integer> list = new ArrayList<>();
            int j = i;
            while (j < nums.length) {
                list.add(nums[j]);
                j += step;
            }
            Collections.sort(list);
            j = i;
            int index = 0;
            while (j < nums.length) {
                nums[j] = list.get(index++);
                j += step;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < times; t++) {
            String numStr = scanner.nextLine();
            String[] numsStr = numStr.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            String step = scanner.nextLine();
            for (String s : step.split(" ")) {
                shellSort(nums, Integer.parseInt(s));
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : nums) {
                stringBuilder.append(" ").append(i);
            }
            stringBuilder.deleteCharAt(0);
            System.out.println(stringBuilder);
        }
    }
}
