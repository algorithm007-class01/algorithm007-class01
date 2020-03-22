# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2: return l1 or l2
        r,a,b = (l1,l1,l2) if (l1.val <= l2.val) else (l2,l2,l1)
        while b:
            if not a.next:
                a.next = b
                break
            if a.next.val > b.val:
                a.next,b.next,b = b,a.next,b.next
            a = a.next
        return r
