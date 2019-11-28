package Gre;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.路上的球
 * @description TODO
 * @date 2019-11-28 19:32
 */
public class 路上的球 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0)
        {
            int nLeft = sc.nextInt();
            int nRight = sc.nextInt();
            int[] left = new int[nLeft];
            int[] right = new int[nRight];

            for (int i = 0; i < nLeft; i++)
            {
                left[i] = sc.nextInt();
            }

            for (int i = 0; i < nRight; i++)
            {
                right[i] = sc.nextInt();
            }


            int max = 0, leftSum = 0, rightSum = 0;
            int lptr = 0, rptr = 0;
            while (lptr < nLeft || rptr < nRight)
            {
                if (lptr >= nLeft)
                {
                    while (rptr < nRight)
                    {
                        rightSum += right[rptr++];
                    }
                    max += Math.max(leftSum, rightSum);
                }
                else if (rptr >= nRight)
                {
                    while (lptr < nLeft)
                    {
                        leftSum += left[lptr++];
                    }
                    max += Math.max(leftSum, rightSum);
                }
                else
                {
                    if (left[lptr] < right[rptr])
                    {
                        leftSum += left[lptr++];
                    }
                    else if (left[lptr] > right[rptr])
                    {
                        rightSum += right[rptr++];
                    }
                    else
                    {
                        leftSum += left[lptr++];
                        rightSum += right[rptr++];
                        max += Math.max(leftSum, rightSum);
                        leftSum = 0;
                        rightSum = 0;
                    }
                }
            }
            System.out.println(max);

        }
    }


}
