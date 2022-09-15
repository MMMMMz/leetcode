/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
        没有头节点，一些边界情况需要特殊处理
         */
        ListNode p1 = head;
        ListNode p2 = head;

        if(p1.next == null){
            return null;
        }

        for(int i = 0 ; i < n ; i++)
        {
            p2 = p2.next;
        }
        if(p2 == null){
            head = head.next;
        } else {
             while(p2 != null && p2.next != null){
                p2 = p2.next;
                p1 = p1.next;
            }
            p1.next = p1.next.next;
        }
        
        return head;
    }
}
