package Array;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhaodeyu
 * @classname Array.子矩阵问题
 * @description
 * 给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 * @date 2019-11-25 19:59
 */
public class 子矩阵问题 {
    public static void main(String args[]) {
        getMaxSubMatrix();
    }

    private static void getMaxSubMatrix()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; ++i)
        {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            int[][] matrix = new int[rows][columns];
            for (int j = 0; j < rows; ++j)
            {
                for (int k = 0; k < columns; ++k)
                {
                    matrix[j][k] = sc.nextInt();
                }
            }

            for (int j = 1; j < rows; ++j)
            {
                for (int k = 0; k < columns; ++k)
                {
                    if (matrix[j][k] != 0)
                    {
                        matrix[j][k] = matrix[j-1][k] + 1;
                    }
                }
            }

            int[] res = new int[rows];
            for (int j = 0; j < rows; ++j)
            {
                Stack<Integer> stack = new Stack<>();
                for (int k = 0; k < columns; ++k)
                {
                    // 记录栈顶矩形的序号
                    int temp = !stack.empty() ? stack.peek() : 0;
                    while (!stack.empty() && matrix[j][k] < matrix[j][stack.peek()])
                    {
                        // 这里的矩形面积计算方式就是@brief中的第一条
                        int cal = matrix[j][stack.peek()] * (temp - stack.peek() + 1);
                        res[j] = cal > res[j] ? cal : res[j];
                        // 这里实现了@brief中的第二条
                        if (stack.size() > 1)
                        {
                            stack.pop();
                        }
                        else
                        {
                            matrix[j][stack.peek()] = matrix[j][k];
                        }

                    }
                    stack.push(k);
                }

                int temp = !stack.empty() ? stack.peek() : 0;
                while (!stack.empty())
                {
                    int cal = matrix[j][stack.peek()] * (temp - stack.peek() + 1);
                    res[j] = cal > res[j] ? cal : res[j];
                    stack.pop();
                }
            }

            int max = 0;
            for (int num : res)
            {
                if (num > max)
                {
                    max = num;
                }
            }

            System.out.println(max);
        }
    }
}
