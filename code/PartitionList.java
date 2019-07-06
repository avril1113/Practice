/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        
        ListNode greater = new ListNode(0);
        ListNode less = new ListNode(0);
        ListNode start = less, end = greater;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            
            head = head.next;
        }
        
        greater.next = null;
        less.next = end.next;
        
        return start.next;
    }
}