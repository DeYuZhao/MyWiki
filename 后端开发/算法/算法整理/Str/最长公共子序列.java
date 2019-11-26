package Str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Str.最长公共子序列
 * @description
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 * @date 2019-11-25 22:12
 */
public class 最长公共子序列 {
    public static void main(String args[]) {
        maxPublicSubArray(new Scanner(System.in));
    }

    public static void maxPublicSubArray(Scanner sc)
    {
        int testNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testNum; ++i)
        {
            String[] stringA = sc.nextLine().split("");
            String[] stringB = sc.nextLine().split("");

            int[][] count = new int[stringA.length+1][stringB.length+1];
            String[][] result = new String[stringA.length+1][stringB.length+1];

            ArrayList<String> list = new ArrayList<>();
            for (int j = 1; j < count.length; ++j)
            {
                for (int k = 1; k < count[0].length; ++k)
                {
                    if (stringA[j-1].equals(stringB[k-1]))
                    {
                        count[j][k] = count[j-1][k-1] + 1;
                        if (result[j-1][k-1] == null)
                        {
                            result[j-1][k-1] = "";
                        }
                        if (!result[j-1][k-1].contains("/"))
                        {
                            result[j][k] = result[j-1][k-1] + stringA[j-1];
                            if (!list.contains(result[j][k]))
                            {
                                list.add(result[j][k]);
                            }
                        }
                        else
                        {
                            String[] temp = result[j-1][k-1].split("/");
                            result[j][k] = temp[0] + stringA[j-1];
                            if (!list.contains(result[j][k]))
                            {
                                list.add(temp[0] + stringA[j-1]);
                            }
                            for (int l = 1; l < temp.length; ++l)
                            {
                                result[j][k] += "/" + temp[l] + stringA[j-1];
                                if (!list.contains(temp[l] + stringA[j-1]))
                                {
                                    list.add(temp[l] + stringA[j-1]);
                                }
                            }
                        }
                    }
                    else if (count[j-1][k] > count[j][k-1])
                    {
                        if (result[j-1][k] == null)
                        {
                            result[j-1][k] = "";
                        }
                        count[j][k] = count[j-1][k];
                        result[j][k] = result[j-1][k];
                    }
                    else if (count[j-1][k] < count[j][k-1])
                    {
                        if (result[j][k-1] == null)
                        {
                            result[j][k-1] = "";
                        }
                        count[j][k] = count[j][k-1];
                        result[j][k] = result[j][k-1];
                    }
                    else
                    {
                        if (result[j-1][k] == null)
                        {
                            result[j-1][k] = "";
                        }
                        if (result[j][k-1] == null)
                        {
                            result[j][k-1] = "";
                        }
                        count[j][k] = count[j-1][k];
                        if (!result[j - 1][k].equals(result[j][k - 1]))
                        {
                            result[j][k] = result[j-1][k] + "/" + result[j][k-1];
                        }
                        else
                        {
                            result[j][k] = result[j-1][k];
                        }
                    }
                }
            }

            int len = count[stringA.length][stringB.length];

            Collections.sort(list);
            for (String string : list)
            {
                if (string.length() == len)
                {
                    System.out.println(string);
                }
            }

        }
    }
}
