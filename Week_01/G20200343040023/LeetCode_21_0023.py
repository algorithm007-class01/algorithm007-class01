# -*- coding: utf-8 -*-


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def __repr__(self):
        return '<%s>' % self.val

    __str__ = __repr__


class Solution(object):

    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        head = ListNode(0)
        l3 = head
        while l1 and l2:
            if l1.val > l2.val:
                l3.next = l2
                l2 = l2.next
            elif l1.val <= l2.val:
                l3.next = l1
                l1 = l1.next
            l3 = l3.next
        l3.next = l1 if l1 else l2
        return head.next
