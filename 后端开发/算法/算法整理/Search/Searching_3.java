package Search;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Searching_3
 * @description TODO
 * @date 2019-11-27 18:26
 */
public class Searching_3 {
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int q = s.nextInt();
            long[][] num = new long[n][2];
            long grp[] = new long[n];
            for(int i=0;i<n;i++){
                num[i][0] = s.nextLong();
                num[i][1] = s.nextLong();
                grp[i] = num[i][1]-num[i][0]+1;
            }
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<q;i++){
                long rank = s.nextLong();
                long marks = 0;
                int k = 0;
                while(true){
                    if(k<n && rank>grp[k]){
                        rank -= grp[k];
                        k++;
                    }else if(rank<=grp[k]){
                        marks = num[k][0]+rank-1;
                        builder.append(marks + " ");
                        break;
                    }
                    if(k==n){
                        marks = num[n-1][1] + rank;
                        builder.append(marks + " ");
                        break;
                    }
                }
            }
            System.out.println(builder.deleteCharAt(builder.length() - 1).toString());
        }
    }
}
