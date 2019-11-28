package Gre;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.硬币最小数量
 * @description TODO
 * @date 2019-11-28 11:06
 */
public class 硬币最小数量 {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t-->0) {

            int m=sc.nextInt();
            int n=sc.nextInt();

            int[] a=new int[m];
            for(int i=0; i<m; i++)
                a[i]=sc.nextInt();

            int[] dp=new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0]=0;

            for(int i=1; i<=n; i++) {

                for(int j=0; j<m; j++) {

                    if(i>=a[j]) {

                        int x=dp[i-a[j]];
                        if(x!=Integer.MAX_VALUE)
                            dp[i]=Math.min(dp[i], 1+x);
                    }
                }
            }

            System.out.println((dp[n]==Integer.MAX_VALUE) ? -1 : dp[n]);
        }
    }
}
