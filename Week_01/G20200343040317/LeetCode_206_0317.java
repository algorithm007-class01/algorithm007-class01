/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    // 下一个pre 
    public ListNode reverse(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return reverse(next, head);
    }
}