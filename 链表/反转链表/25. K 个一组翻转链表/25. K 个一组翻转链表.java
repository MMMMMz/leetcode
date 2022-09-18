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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = head;
        int nodeLen = 0;
        while(p != null){
            p = p.next;
            nodeLen++;
        }

        int reverseCount = nodeLen / k;
        p = head;
        ListNode pre = dummy;
        for(int i = 0 ; i < reverseCount ; i++)
        {
            for(int j = 0 ; j < k - 1; j++)
            {
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = p;
            p = p.next;
        }

        return dummy.next;
    }
}
