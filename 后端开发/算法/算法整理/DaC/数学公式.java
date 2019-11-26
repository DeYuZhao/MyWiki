package DaC;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname DaC.数学公式
 * @description
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 * @date 2019-11-25 22:37
 */
public class 数学公式 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(cal(a,b,c));
        }
    }
    static int cal(int x,int y,int p){
        int res = 1;

        // Update x if it is more
        // than or equal to p
        x = x % p;

        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;

            // y must be even now
            // y = y / 2
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
