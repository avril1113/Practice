/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        ArrayList<Integer> sortList = new ArrayList<>();
        ListNode node;
        for (int i = 0; i < lists.length; i++) {
            node = lists[i]; 
            while (node != null) {
                sortList.add(node.val);
                node = node.next;
            }
        }
        
        if (sortList.size() == 0)
            return null;
        
        Collections.sort(sortList);
        ListNode root = new ListNode(sortList.get(0));
        node = root;
        for (int i = 1; i < sortList.size(); i++) {
            ListNode cur = new ListNode(sortList.get(i));
            node.next = cur;
            node = node.next;
        }
        
        return root;
    }
}