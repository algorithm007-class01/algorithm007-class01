/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *  2个链表的合并，根据链表的特性，链表的尾部会指向next=null的节点
 *  则只需要对2个链表的值进行大小比较即可，和数组合并类似，只是特性不一样
 *
 *  时间复杂度O(n)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 定义一个新的结点赋值为-1
        ListNode pre = new ListNode(-1);

        // 将pre作为头结点（其实是一个虚节点）
        ListNode head = pre;

        // 如果l1和l2都不为空的情况下
        // 判断l1和l2对应的值
        // 如果l1 < l2，则head的next ListNode就用l1来填充，并将l1往后移
        // 如果l1 >= l1,则head的next ListNode就用l2来填充，并将l2往后移
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        // 最后的一个判断，可能l1和l2存在为空的情况，如果有null的，则用另一个替代就行
        head.next = null == l1 ? l2 : l1;

        // .next即舍去了头节点（虚节点）
        return pre.next;
    }