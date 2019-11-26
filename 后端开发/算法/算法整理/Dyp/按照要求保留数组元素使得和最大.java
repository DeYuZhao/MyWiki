package Dyp;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Dyp.按照要求保留数组元素使得和最大
 * @description
 * Given an array of N numbers, we need to maximize the sum of selected numbers.
 * At each step, you need to select a number Ai, delete one occurrence of Ai-1 (if exists) and Ai each from the array.
 * Repeat these steps until the array gets empty. The problem is to maximize the sum of selected numbers.
 * @date 2019-11-26 23:20
 */
public class 按照要求保留数组元素使得和最大 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int length = scanner.nextInt();
            int []arrNum=new int[length];
            for(int j=0;j<length;j++){
                arrNum[j]=scanner.nextInt();
            }
            System.out.println(maximize(arrNum,length));
        }
    }
    public static int maxNum(int [] arrNum){
        int max = arrNum[0];
        for(int i=0;i<arrNum.length;i++){
            if(arrNum[i]>=max){
                max=arrNum[i];
            }
        }
        return max;
    }
    public static int maximize(int []arrNum,int length){
        int sum = 0;
        int count = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        while (true) {
            flag1=true;
            flag2=true;
            int maxNum = maxNum(arrNum);
            sum+=maxNum;
            if(maxNum==0){
                break;
            }
            for (int i = 0; i < length; i++) {
                if(flag1&&arrNum[i]==maxNum){
                    arrNum[i]=0;
                    flag1=false;
                    count++;
                    continue;
                }
                if(flag2&&arrNum[i]==maxNum-1){
                    arrNum[i]=0;
                    flag2=false;
                    count++;
                    continue;
                }
            }
        }
        return sum;

    }
}
