package Sort;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Sort.冒泡排序
 * @description TODO
 * @date 2019-11-26 21:32
 */
public class 冒泡排序 {
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
            bubbleSort(is);
            print(is);

        }
    }
    private static void bubbleSort(int[] is) {
        int temp;
        int i;
        // 外层循环：n个元素排序，则至多需要n-1趟循环
        for (i = 0; i < is.length - 1; i++) {
            // 定义一个布尔类型的变量，标记数组是否已达到有序状态
            boolean flag = true;
            /*内层循环：每一趟循环都从数列的前两个元素开始进行比较，比较到无序数组的最后*/
            for (int j = 0; j < is.length - 1 - i; j++) {
                // 如果前一个元素大于后一个元素，则交换两元素的值；
                if (is[j] > is[j + 1]) {
                    temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                    //本趟发生了交换，表明该数组在本趟处于无序状态，需要继续比较；
                    flag = false;
                }
            }
            //根据标记量的值判断数组是否有序，如果有序，则退出；无序，则继续循环。
            if (flag) {
                break;
            }
        }
    }
}
