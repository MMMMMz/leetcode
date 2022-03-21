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
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        ListNode newHead = new ListNode(cur.val);
        ListNode newCur = newHead;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cur != null){
                ListNode temp = new ListNode(cur.val);
                newCur.next = temp;
                newCur = newCur.next;
            } else {
                newCur.next = null;
            }
            
        }
        newCur = newHead;
        cur = pre;
        while(cur.next != null)
        {
            if(cur.val != newCur.val){
                return false;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return true;
    }
}
