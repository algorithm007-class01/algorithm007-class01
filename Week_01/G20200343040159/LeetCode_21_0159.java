/**
*
* 21. 合并两个有序链表 <p>
* https://leetcode-cn.com/problems/merge-two-sorted-lists/
*/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int currentVal;
        if (l1.val <= l2.val) {
            currentVal = l1.val;
            l1 = l1.next;
        } else {
            currentVal = l2.val;
            l2 = l2.next;
        }

        ListNode newListNode = new ListNode(currentVal);

        ListNode temp = newListNode;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else if (l2 != null) {
            temp.next = l2;
        }

        return newListNode;
    }
}