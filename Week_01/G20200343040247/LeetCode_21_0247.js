/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 哨兵， dummy node?
    var prevHead = new ListNode(-1);
    var prevNode = prevHead;
    while (l1 != null && l2 != null) {
        if(l1.val <= l2.val){
            prevNode.next = l1; 
            l1 = l1.next   //迭代
        }else{
            prevNode.next = l2;
            l2 = l2.next;  //迭代
        }
        prevNode = prevNode.next;
    }
    prevNode.next = l1 ? l1 :l2;   //把剩下的部分拼接上
    return prevHead.next;    
};
