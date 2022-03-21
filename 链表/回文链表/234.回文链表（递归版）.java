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
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    boolean traverse(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        if(left.val != right.val){
            res = res && false;
        }
        left = left.next;
        return res;
    }
}
