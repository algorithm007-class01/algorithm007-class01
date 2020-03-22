class ListNode:
    """ 链表 """
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    """ 合并两个有序列表 """
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """ 迭代法
            参数：
                l1:给定的第一个链表
                l2:给定的第二个链表
            返回值：
                合并后的链表
            时间复杂度：
                O(m+n)
            空间复杂度：
                O(1)
        """
        newNode = ListNode(-1)
        prev = newNode
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
        prev.next = l1 if l1 is not None else l2
        return newNode.next

# class ListNode:
#     """ 链表 """
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# 
# class Solution:
#     """ 合并两个有序列表 """
#     def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
#         """ 递归法
#             参数：
#                 l1:给定的第一个链表
#                 l2:给定的第二个链表
#             返回值：
#                 合并后的链表
#             时间复杂度：
#                 O(m+n)
#             空间复杂度：
#                 O(m+n)
#         """
#         if l1 is None:
#             return l2
#         if l2 is None:
#             return l1
#         elif l1.val <= l2.val:
#             l1.next = self.mergeTwoLists(l1.next, l2)
#             return l1
#         else:
#             l2.next = self.mergeTwoLists(l1, l2.next)
#             return l2