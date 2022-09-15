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
        /**
        f = 2s
        f = nb + s
        s = nb
        假设两个指针都从head以1的速度出发，则若存在环一定走了a+nb步
        此时s已经走了nb步，只需再走a步就可到达环的入口
        正好从head出发到达环的入口需要走a步，因此让一个指针从head出发，与s相遇时即找到了环的入口
         */
        if(head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p2 = p2.next.next;
            p1 = p1.next;
            if(p1 == p2){
                break;
            }
        }
        if(p2 == null || p2.next == null){
            return null;
        }
       p2 = head;
       while(p1 != p2){
           p1 = p1.next;
           p2 = p2.next;
       }

       return p2;
    }
}
