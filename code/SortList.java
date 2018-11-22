/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode result = new ListNode(0);
        ListNode cur, left, right, tail;
        result.next = head;
        int len = 0;
        
        while (head != null) {
            len++;
            head = head.next;
        }
        
        for (int i = 1; i <= len; i = i*2) {
            cur = result.next;
            tail = result;
            
            while (cur != null) {
                left = cur;
                right = spilt(left, i);
                cur = spilt(right, i);
                
                List<ListNode> list = merge(left, right);
                tail.next = list.get(0);
                tail = list.get(1);
            }
        }
        
        
        return result.next;
    }
    
    ListNode spilt(ListNode node, int len) {
        ListNode result = node;
        for (int j = 1; j <= len; j++) {
            if (node == null)
                return node;
            
            if (j == len) {
                result = node.next;
                node.next = null;
            } else {
                node = node.next;
            }
        }
        
        return result;
    }
    
    List<ListNode> merge(ListNode left, ListNode right) {
        List<ListNode> list = new ArrayList();
        ListNode node = new ListNode(0);
        ListNode cur = node;
        
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            
            cur = cur.next;
        }
        
        if (left != null)
            cur.next = left;
        
        if (right != null)
            cur.next = right;
        
        while (cur.next != null) {
            cur = cur.next;
        }
            
        list.add(node.next);
        list.add(cur);
            
        return list;
    }
    
}