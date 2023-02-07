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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        int flag = 0;
        int next = 0;
        while(p1 != null && p2 != null){
            if(flag == 1){
                p.next = new ListNode((p1.val + p2.val + 1) % 10);
                p = p.next;
                next = p1.val + p2.val + 1;
                flag = 0;
            } else {
                p.next = new ListNode((p1.val + p2.val) % 10);
                p = p.next;
                next = p1.val + p2.val;
            }
            //当有进位的时候，下一位加1
            if(next>= 10){ 
                flag = 1;
            } 
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 != null){
           p2 = p1;
        }
        while(p2 != null){
            if(flag == 1){
                p.next = new ListNode((p2.val + 1) % 10);
                p = p.next;
                next = p2.val + 1;
                flag = 0;
            } else {
                p.next = new ListNode((p2.val));
                p = p.next;
                next = p2.val;
            }
            if(next>= 10){ 
                flag = 1;
            } 
            p2 = p2.next;
        }
        if(flag == 1){
            p.next = new ListNode(1);
            p = p.next;
        }
        return dummy.next;
    }
}
