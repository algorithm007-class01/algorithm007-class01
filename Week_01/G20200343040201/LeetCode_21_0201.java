public class LeetCode_21_0201 {

    /**
     * Definition for singly-linked list.
     * public class essential.ListNode {
     * int val;
     * essential.ListNode next;
     * essential.ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 建立一个头节点，以便用来持有 结果链表的指针。
         * 这是一些链表题目的常规操作了。
         */
        ListNode resHead = new ListNode(-1);
        ListNode point = resHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
                point = point.next;
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        /**
         * 如果其中一个链表遍历完了，另一个链表直接接到结果链表后面
         */
        point.next = (l1 == null) ? l2 : l1;
        return resHead.next;
    }

}
