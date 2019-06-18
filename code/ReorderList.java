/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode fast = head, slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode end = revert(slow.next), start, node = head;
        slow.next = null;
        
        while (end != null) {
            start = node.next;
            node.next = end;
            end = end.next;
            node.next.next = start;
            node = start;
        }
    }
    
    private ListNode revert(ListNode node) {
        ListNode pre = null, cur = node, next;
        
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}