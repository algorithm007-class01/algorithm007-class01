public class l21mergeTwoLists {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n2 = new ListNode(2, n4);
        ListNode l1 = new ListNode(1, n2);

        ListNode n24 = new ListNode(4);
        ListNode n23 = new ListNode(3, n24);
        ListNode l2 = new ListNode(1, n23);

        printListNode(l1);
        printListNode(l2);
        ListNode merge = new Solution().mergeTwoLists(l1, l2);
        printListNode(merge);
    }

    private static void printListNode(ListNode listNode) {
        System.out.println();
        ListNode next = listNode;
        while (next != null) {
            System.out.print(next.val + "->");
            next = next.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}