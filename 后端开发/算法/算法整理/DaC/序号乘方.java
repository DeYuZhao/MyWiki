package DaC;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname DaC.序号乘方
 * @description
 * There are Infinite People Standing in a row, indexed from 1.A person having index 'i' has strength of (i*i).
 * You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.
 * You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.
 * @date 2019-11-25 22:49
 */
public class 序号乘方 {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int i;
        int r[]=new int[t];
        for(i=0;i<t;i++)
        {
            long p=sc.nextLong();
            long j=1;
            while(p>=(j*j))
            {
                p=p-(j*j);
                r[i]++;
                j++;
            }

        }
        for(i=0;i<t;i++)
        {
            System.out.println(r[i]);
        }

    }
}
