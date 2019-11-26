package Sort;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Sort.插入排序
 * @description TODO
 * @date 2019-11-25 22:17
 */
public class 插入排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            insertionSort(is);
            print(is);

        }
    }
    private static void insertionSort(int[] ins){

        for(int i=1; i<ins.length; i++){
            int temp = ins[i];//保存每次需要插入的那个数
            int j;
            for(j=i; j>0&&ins[j-1]>temp; j--){//这个较上面有一定的优化
                ins[j] = ins[j-1];//吧大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            ins[j] = temp;//将需要插入的数放入这个位置
        }
    }

    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}
