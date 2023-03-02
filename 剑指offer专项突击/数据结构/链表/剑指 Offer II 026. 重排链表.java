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
    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode l2 = reverse(middle.next);
        middle.next = null;
        ListNode p1 = head;
        ListNode p2 = l2;
        while(p2 != null){
            ListNode temp1 = p1;
            ListNode temp2 = p2;
            p1 = p1.next;
            p2 = p2.next;
            temp1.next = temp2;
            temp2.next = p1;
        }
    }

    ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode p = head;
        while(p != null){
            ListNode temp = p;
            p = p.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
}
