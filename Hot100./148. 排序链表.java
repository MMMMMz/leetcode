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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while(p != null){
            pq.offer(new ListNode(p.val));
            p = p.next;
        }
        p = dummy;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
        }
        return dummy.next;
    } 
}
