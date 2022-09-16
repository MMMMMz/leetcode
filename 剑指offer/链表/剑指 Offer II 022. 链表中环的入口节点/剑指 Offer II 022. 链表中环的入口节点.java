/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        //注意while的循环条件，如果只有p1 != p2 上来就会终止循环
        while(p1 != p2 || (p1 == head)){
            if(p2 == null || p2.next == null){
                return null;
            }
            p2 = p2.next.next;
            p1 = p1.next;
            if(p1 == p2){
                break;
            }
        }

        p2 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
