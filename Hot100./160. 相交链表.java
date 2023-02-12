/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) return headA;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null){
            p1 = headB;
            while(p1 != p2){
                if(p2 == null){
                    p2 = headA;
                } else{
                    p1 = p1.next;
                    p2 = p2.next;
                }
                
            } 
        } else {
            p2 = headA;
            while(p1 != p2){
                if(p1 == null){
                    p1 = headB;
                } else{
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return p1;
    }
}
