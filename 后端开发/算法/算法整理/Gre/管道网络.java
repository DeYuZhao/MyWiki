package Gre;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.管道网络
 * @description TODO
 * @date 2019-11-28 09:36
 */
public class 管道网络 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum-- > 0)
        {
            String[] inputs = sc.nextLine().split(" ");
            int houseNum = Integer.parseInt(inputs[0]);
            int pipeNum = Integer.parseInt(inputs[1]);

            int[] startPtr = new int[houseNum+1];
            int[] endPtr = new int[houseNum+1];
            int[] diameter = new int[houseNum+1];
            int result = 0;

            int[][] input = new int[pipeNum][3];
            for (int i = 0; i < pipeNum; i++) {
                String[] temp = sc.nextLine().split(" ");
                input[i][0] = Integer.parseInt(temp[0]);
                input[i][1] = Integer.parseInt(temp[1]);
                input[i][2] = Integer.parseInt(temp[2]);
                startPtr[input[i][0]] = input[i][1];
                endPtr[input[i][1]] = input[i][0];
                diameter[input[i][0]] = input[i][2];
            }

            for (int i = 0; i < houseNum; i++) {
                if(endPtr[i] == 0 && startPtr[i] != 0)
                    result++;
            }

            System.out.println(result);

            for (int i = 0; i < houseNum; i++) {
                if (endPtr[i] == 0 && startPtr[i] > 0)
                {
                    result = Integer.MAX_VALUE;
                    int n = i;
                    while (startPtr[n] != 0)
                    {
                        if (diameter[n] < result)
                        {
                            result = diameter[n];
                        }
                        n = startPtr[n];
                    }
                    System.out.println(i + " " + n + " " + result);
                }
            }
        }
    }

}
