package removeNthFromEnd;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr1 = head;
        ListNode curr2 = head.next;
        ListNode result = head;
        int total = 0;
        int index = 0;
        while(curr1 != null){
            total++;
            curr1 = curr1.next;
        }
        System.out.println(total);
        while(curr2 != null){
            index++;
            if(index == total-n){
                System.out.println(index);
                result.next = curr2.next.next;
            }else{
                result.next = curr2;
            }
            curr2 = curr2.next;
        }
        return result;
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
        ListNode listNode = removeNthFromEnd(listNode1, 2);
        ListNode node = listNode;
        while (node.next!=null){
            node = node.next;
            System.out.print(listNode.toString());
        }
    }
}
