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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
        有头节点，不需要处理边界条件
         */
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode p1 = dummy;
      ListNode p2 = head;
      for(int i = 0 ; i < n ; i++){
          p2 = p2.next;
      }
      while(p2 != null){
          p2 = p2.next;
          p1 = p1.next;
      }

      p1.next = p1.next.next;
      return dummy.next;
    }
}
