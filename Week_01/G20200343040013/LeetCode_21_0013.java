package arithmetic.leetcode;

public class MergeLinkList {

    class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
        }
    }

    /**
     * 合并有序的链表
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoLists(Node l1, Node l2) {

        //通过哨兵节点
        Node head = new Node(-1);
        Node pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
