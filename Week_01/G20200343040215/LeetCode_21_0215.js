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
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    let pre = new ListNode(-1);
    let preHead = pre;

    while( l1!=null && l2!=null){
        if(l1.val <= l2.val){
            preHead.next = l1;
            l1 = l1.next;
        }
        else{
            preHead.next = l2;
            l2 = l2.next;
        }
        preHead = preHead.next;//继续遍历
    }
    preHead.next = (l1==null)?(l2):(l1);
    return pre.next;

};