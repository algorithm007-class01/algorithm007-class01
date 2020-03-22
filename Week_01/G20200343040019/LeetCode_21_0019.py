# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        prev = ListNode(-1)
        h = prev
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next, l1 = l1, l1.next
            else:
                prev.next, l2 = l2, l2.next
            prev = prev.next

        if l1:
            prev.next = l1
        if l2:
            prev.next = l2

        return h.next

        #   递归

        # if l1 is None:
        #     return l2
        # if l2 is None:
        #     return l1

        # curr = l1
        # if l1.val > l2.val:
        #     curr = l2
        #     curr.next = self.mergeTwoLists(l1, l2.next)
        # else:
        #     curr.next = self.mergeTwoLists(l1.next, l2)

        # return curr

        # 有序

        # if l1 is None:
        #     return l2
        # if l2 is None:
        #     return l1
