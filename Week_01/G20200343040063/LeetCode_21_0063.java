class Solution {

    // 解题1 递归
    // 1. 终止条件 l1 == null || l2 == null
    // 2. 进入下一层的条件
    // 3. 最终返回一个链表的头节点
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    // 2. 迭代的方式解题
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(l1 != null || l2 != null){
            if(l1 == null) {
                pre.next = l2;
                 break;
            }
            if(l2 == null) {
                pre.next = l1;
                break;
            }
        
            if(l1.val < l2.val ){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        return preHead.next;
    }
}