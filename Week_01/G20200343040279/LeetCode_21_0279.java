
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class Solution {
	public static void main(int[] args) {

	}

	public static void mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(-1);

		ListNode prev = preHead;
		 while (l1 != null && l2 != null) {
		 	if (l1.val > l2.val) {
		 		pre.next = l2;
		 		l2 = l2.next;
		 	} else {
		 		pre.next = l1;
		 		l1 = l1.next;
		 	}
		 	prev = prev.next;
		 }

		 prev.next =  l1 == null ? l2 : l1;
		 return preHead.next;
	}
}