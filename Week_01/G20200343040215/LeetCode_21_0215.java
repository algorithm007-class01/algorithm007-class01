package Week_01;

/*
 * Definition for singly-linked list.
         */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class LeetCode_21_0215 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resultNode= new ListNode(-1);
        ListNode index = resultNode;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                index.next = l1;
                l1 = l1.next;
            }else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        index.next = l1 == null? l2:l1;
        return resultNode.next;
    }
}
