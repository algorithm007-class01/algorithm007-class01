// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

var mergeTwoLists = function(l1, l2) {
    var head = new ListNode(0)
    var prev = head
    while(l1 != null && l2 != null) {
        if(l1.val > l2.val) {
            prev.next = l2
            l2 = l2.next
        } else {
            prev.next = l1
            l1 = l1.next
        }
        prev = prev.next
    }
    prev.next = l1 ? l1 : l2
    return head.next
}