/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while(p != null){
            ListNode temp = p;
            p = p.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }
}
