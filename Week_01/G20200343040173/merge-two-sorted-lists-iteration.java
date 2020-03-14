class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if( l2 == null) {
            return l1;
        }
        
        ListNode preHead;
        // ensure head node
        if (l1.val <= l2.val) {
            preHead = l1;
        } else {
            preHead = l2;
        }

        ListNode prev = new ListNode(-1);
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next; // for iterate
            } else {
                prev.next = l2;
                l2 = l2.next; // for iterate
            }
            prev = prev.next; // record the last node
        }

        // link to the iterator ramining node
        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return preHead;
    }
}