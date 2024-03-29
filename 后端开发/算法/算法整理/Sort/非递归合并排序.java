package Sort;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Sort.非递归合并排序
 * @description TODO
 * @date 2019-11-25 22:34
 */
public class 非递归合并排序 {
    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            mergeSort(is);
            print(is);

        }
    }
    private static void mergeSort(int[] arr) {
        if(arr==null || arr.length<=0)
            return;
        int width = 1;
        while(width<arr.length) {
            mergePass(arr,width);
            width*=2;
        }
    }

    private static void mergePass(int[] arr,int width) {
        int start=0;
        while(start+2*width-1<arr.length) {
            int mid=start+width-1;
            int end=start+2*width-1;
            merge(arr,start,mid,end);
            start=start+2*width;
        }
        //剩余无法构成完整的两组也要进行处理
        if(start+width-1<arr.length)
            merge(arr, start, start+width-1, arr.length-1);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i=start;
        int j=mid+1;
        int[] temp = new int[end-start+1];
        int index=0;
        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j])
                temp[index++]=arr[i++];
            else
                temp[index++]=arr[j++];
        }
        while(i<=mid)
            temp[index++]=arr[i++];
        while(j<=end)
            temp[index++]=arr[j++];

        for(int k=start;k<=end;k++)
            arr[k]=temp[k-start];
    }
}
