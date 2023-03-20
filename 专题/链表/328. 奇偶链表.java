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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        int count = 1;
        ListNode pre = head;
        ListNode p = head;
        ListNode p2 = dummy;
        while(p != null){
            if(count % 2 == 0){
                p2.next = p;
                p = p.next;
                pre.next = p;
                pre = p;
                p2 = p2.next;
                p2.next = null;
                count++;
                continue;
            }
            pre = p;
            p = p.next;
            count++;
        }
        p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = dummy.next;
        return head;
    }
}
