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
    public ListNode mergeKLists(ListNode[] lists) {
        //使用优先队列，将所有的节点首先放在优先队列，自动排好序，然后挨个取出
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->(a.val - b.val));
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
