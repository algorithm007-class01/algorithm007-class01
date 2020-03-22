/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }

        ListNode newList = new ListNode(0);
        ListNode first = newList;
        for (; null != l1 && null != l2; ) {
            if (l1.val < l2.val) {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newList.next = new ListNode((l2.val));
                l2 = l2.next;
            }
            newList = newList.next;
        }
        newList.next = null != l1 ? l1 : l2;
        return first.next;
    }
}