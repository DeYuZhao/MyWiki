import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname 链表区间逆序
 * @description
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 * @date 2019-11-25 22:16
 */
public class 链表区间逆序 {
    public static void main(String args[]) {
        linkedListBackSort(new Scanner(System.in));
    }

    public static void linkedListBackSort(Scanner sc)
    {
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum-- > 0)
        {
            String[] input = sc.nextLine().split(" ");
            int len = Integer.parseInt(input[0]);
            String[] array = new String[len];
            for (int i = 0; i < len; ++i)
            {
                array[i] = input[i+1];
            }
            int block = Integer.parseInt(input[input.length-1]);
            LinkedList<String> list = new LinkedList<>();
            for (int i = block-1; i < len; i+=block)
            {
                for (int j = i; j >= i - block + 1; --j)
                {
                    list.add(array[j]);
                }
            }
            int count = len % block;
            while (count > 0)
            {
                list.add(array[len - count]);
                count--;
            }

            StringBuilder builder = new StringBuilder();
            list.forEach(t -> builder.append(t + " "));
            System.out.println(builder.deleteCharAt(builder.length()-1).toString());
        }
    }
}
