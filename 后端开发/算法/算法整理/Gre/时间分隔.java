package Gre;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.时间分隔
 * @description TODO
 * @date 2019-11-28 10:24
 */
public class 时间分隔 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dept = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            for(int i = 0; i < n; i++)
                dept[i] = sc.nextInt();

            System.out.println(compute(arr,dept,n));
        }
    }
    public static int compute(int[]arr, int[]dept, int n) {
        int max=1,curr=1;
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 1,j = 0;
        while(i < n && j < n){
            if(arr[i] < dept[j]) {
                curr++;
                if(curr>max)
                    max=curr;
                i++;
            }else{
                curr--;
                j++;
            }
        }
        return max;
    }
}
