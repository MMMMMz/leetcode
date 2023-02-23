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
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        while(p != null){
            ListNode temp = p;
            p = p.next;
            temp.next = null;
            pq.offer(temp);
            
        }
        p = dummy;
        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
        }
        return dummy.next;
    }
}
