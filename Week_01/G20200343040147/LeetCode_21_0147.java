public class LeetCode_21_0147 {

    /**
     * 1、双指针
     * 2、比较大小，选择小的放入新链表
     * 3、移动指针
     * 4、插入剩余部分
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode cur = result;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        } else if (cur2 != null) {
            cur.next = cur2;
        }

        ListNode r = result.next;
        result.next = null;
        return r;
    }

    public static void main(String[] args) {
        new LeetCode_21_0147().test();
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        System.out.print("l1:");
        ListNode c1 = l1;
        while (c1 != null) {
            System.out.printf("==>%d", c1.val);
            c1 = c1.next;
        }
        System.out.println();
        System.out.print("l2:");
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        ListNode c2 = l2;
        while (c2 != null) {
            System.out.printf("==>%d", c2.val);
            c2 = c2.next;
        }
        System.out.println();
        System.out.print("r:");
        ListNode r = mergeTwoLists(l1, l2);
        while (r != null) {
            System.out.printf("==>%d", r.val);
            r = r.next;
        }

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}