# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def mergeTwoLists(self, l1, l2):
        head = ListNode(None)
        node = head
        while l1 and l2:
            if l1.val >= l2.val:
                node.next, l2 = l2, l2.next 
            else:
                node.next, l1 = l1, l1.next
            node = node.next

        if l1 is None:
            node.next = l2
        elif l2 is None and l1:
            node.next = l1

        return head.next          