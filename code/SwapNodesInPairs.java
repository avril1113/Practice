/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode start = new ListNode(0);
        ListNode pre = start, cur = head, next, rest;
        
        while (cur != null) {
            if (cur.next == null) {
                pre.next = cur;
                break;
            }
                
            next = cur.next;
            rest = next.next;
            next.next = cur;
            pre.next = next;
            cur.next = null;
            pre = cur;
            cur = rest;
        }
        
        return start.next;
    }
}