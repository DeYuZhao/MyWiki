package Gre;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.格子里的整数
 * @description TODO
 * @date 2019-11-28 18:51
 */
public class 格子里的整数 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0)
        {
            int n = sc.nextInt();
            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            int[][] sum = new int[n][n];
            sum[0][0] = array[0][0];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int left = 0, top = 0;
                    if (i-1 >= 0)
                        top = sum[i-1][j];
                    if (j-1 >= 0)
                        left = sum[i][j-1];
                    if (left == 0) {
                        sum[i][j] = array[i][j] + top;
                        continue;
                    }
                    if (top == 0) {
                        sum[i][j] = array[i][j] + left;
                        continue;
                    }
                    if (left != 0 && top != 0)
                    {
                        sum[i][j] = Math.min(left, top) + array[i][j];
                        continue;
                    }
                }

            }


            System.out.println(sum[n-1][n-1]);
        }
    }
}
