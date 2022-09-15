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
        /**
        将两条链合并，然后相遇后就看下一个是否为null，如果为null则不相交，为null则相交
         */
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if(p2 == null){
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
