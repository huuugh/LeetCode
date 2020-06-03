package LinkedList.removeNthFromEnd;

import LinkedList.ListNode;

/**
 * 删除链表的倒数第n个节点
 */
public class Solution {
    /**
     * 我们注意到这个问题可以容易地简化成另一个问题：删除从列表开头数起的第 (L - n + 1)(L−n+1) 个结点，其中 LL 是列表的长度。
     * 只要我们找到列表的长度 LL，这个问题就很容易解决。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr1 = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode result = dummy;
        int total = 0;
        int index = 0;
        while (curr1 != null) {
            total++;
            curr1 = curr1.next;
        }
        System.out.println(total);
        index = total - n;
        while (index > 0) {
            index--;
            result = result.next;
        }
        result.next = result.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndByOnce(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i=0;i<n+1;i++){
            second = second.next;
        }
        while (second != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = removeNthFromEndByOnce(listNode1, 2);
        ListNode node = listNode;
        while (node.next != null) {
            node = node.next;
            System.out.print(listNode.toString());
        }
    }
}
