package Array;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Array.汉诺塔
 * @description
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
 * @date 2019-11-25 19:52
 */
public class 汉诺塔 {
    public static void main(String[] args) {
        calTowerOfHanoi();
    }

    private static void calTowerOfHanoi()
    {
        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; ++i)
        {
            int num = sc.nextInt();
            System.out.println(getResult(num));
        }
    }

    private static int getResult(int num)
    {
        if (num == 1)
        {
            return 2;
        }
        return 3 * getResult(num - 1) + 2;
    }
}
