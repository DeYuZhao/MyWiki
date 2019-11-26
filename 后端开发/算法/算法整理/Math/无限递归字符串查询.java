package Math;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Math.无限递归字符串查询
 * @description
 * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively.
 * In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.
 * Constraints:1<=Q<=10^5, 1<=POS<=10^12
 * @date 2019-11-25 22:45
 */
public class 无限递归字符串查询 {
    public static void main (String[] args) {
        final String PAT = "12345$54321";

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long pos = in.nextLong();
            if (pos == 0) {
                System.out.println("");
                continue;
            }

            while (pos > PAT.length()) {
                long[] iter = findIter(pos);
                long start = (iter[0]+iter[1]) / 2;
                pos -= start;
            }
            char res;
            if (pos <= 0) {
                res = '$';
            } else {
                res = PAT.charAt((int)pos-1);
            }
            System.out.println(res);
        }
    }

    private static long[] findIter(long pos) {
        long len = 5;
        int it = 0;
        while (pos > len) {
            it++;
            len = 2*len + it;
        }
        return new long[] {len, it};
    }
}
