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
    public ListNode partition(ListNode head, int x) {
        /**
        使用两个链表进行模拟，一条装小的一条装大的，最后再合并
         */
        ListNode dummy1 = new ListNode(101);
        ListNode dummy2 = new ListNode(101);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
                //p.next = null;
            } else {
                p2.next = p;
                p2 = p2.next;
               // p.next = null;
            }
            ListNode temp = p;
            p = p.next;
            temp.next = null;
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
