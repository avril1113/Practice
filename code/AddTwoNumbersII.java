/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode pre = null;
        int num1 = 0, num2 = 0, sum = 0;
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            num1 = stack1.isEmpty() ? 0 : stack1.pop();
            num2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = sum + num1 + num2;
            
            ListNode node = new ListNode(sum%10);
            sum = sum / 10;
            node.next = pre;
            pre = node;
        }
        
        if (sum != 0) {
            ListNode node = new ListNode(sum);
            node.next = pre;
            return node;
        }
        
        return pre;
    }
}