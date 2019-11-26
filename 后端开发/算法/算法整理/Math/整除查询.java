package Math;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Math.整除查询
 * @description
 * Given an array of positive integers and many queries for divisibility.
 * In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.
 *
 * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
 * @date 2019-11-25 23:01
 */
public class 整除查询 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int a1[] = new int[l1];
            int a2[] = new int[l2];
            for(int j=0;j<l1;j++){
                a1[j] = scanner.nextInt();
            }
            for(int k=0;k<l2;k++){
                a2[k] = scanner.nextInt();
            }
            cal(a1,a2);
        }
    }
    static void cal(int []a1,int []a2){
        String ans = "";
        for(int i=0;i<a2.length;i++){
            int div = a2[i];
            int count = 0;
            for(int j=0;j<a1.length;j++){
                if(a1[j]%div==0){
                    count++;
                }
            }
            ans+=count+" ";

        }
        ans = ans.substring(0,ans.length()-1) ;
        System.out.println(ans);
    }
}
