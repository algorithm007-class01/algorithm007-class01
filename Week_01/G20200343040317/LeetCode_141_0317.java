/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode worker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            // 一定要走起来，才能做后面的if 判断
            // 如果不先走那么worker runner 起点就不能一样,否则结果就不正确
            worker = worker.next;
            runner = runner.next.next;
            if (worker == runner) {
                return true;
            }
        }
        return false;
    }
}