package Sort;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Sort.计数排序
 * @description TODO
 * @date 2019-11-26 21:33
 */
public class 计数排序 {
    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            countSort(is);
            print(is);

        }
    }

    private static void countSort(int[] is) {

        int[] result = new int[is.length];
        for (int item : is) {
            int count = 0;
            for (int value : is) {
                if (value < item) {
                    count++;
                }
            }
            result[count] = item;
        }

        for (int i = 0; i < result.length; i++) {
            is[i] = result[i] == 0 ? is[i - 1] : result[i];
        }
    }
}
