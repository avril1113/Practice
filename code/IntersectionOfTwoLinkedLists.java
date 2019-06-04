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
        if (headA == null || headB == null)
            return null;
        
        ListNode node = headA, next;
        int countA = 0, countB = 0;
        
        while (node != null) {
            countA++;
            node = node.next;
        }
        
        node = headB;
        while (node != null) {
            countB++;
            node = node.next;
        }
        
        if (countA > countB) {
            int temp = countA - countB;
            while (temp > 0) {
                headA = headA.next;
                temp--;
            }
        } else if (countB > countA) {
            int temp = countB - countA;
            while (temp > 0) {
                headB = headB.next;
                temp--;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}