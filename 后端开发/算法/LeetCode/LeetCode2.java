/**
 * @Classname LeetCode2
 * @Description
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中,它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * @Date 2019-06-11 16:31
 * @Created by zhaodeyu
 */
public class LeetCode2 {
    public static void main(String args[]) {
        System.out.println("in");
        int[] set1 = {0,8,6,5,6,8,3,5,7};
        int[] set2 = {6,7,8,0,8,5,8,9,7};

        ListNode test1 = new ListNode(set1[0]);
        ListNode head1 = test1;
        ListNode test2 = new ListNode(set2[0]);
        ListNode head2 = test2;
        for (int i=1; i<set1.length; i++){
            test1.next = new ListNode(set1[i]);
            test1 = test1.next;
        }

        for (int i=1; i<set2.length; i++){
            test2.next = new ListNode(set2[i]);
            test2 = test2.next;
        }
        addTwoNumbers(head1, head2);

        System.out.println("finish");
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) return l2;

        if (l2.val == 0 && l2.next == null) return l1;

        ListNode temp = new ListNode(0);
        ListNode result = temp;
        int carry_bit = 0;

        while (l1 != null || l2 != null) {

            int cache1 = (l1 != null)?l1.val:0;
            int cache2 = (l2 != null)?l2.val:0;

            temp.next = new ListNode((cache1 + cache2 + carry_bit) % 10);
            carry_bit = (cache1 + cache2 + carry_bit) / 10;
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (carry_bit > 0) {
            temp.next = new ListNode(1);
        }

        return result.next;
    }
}

