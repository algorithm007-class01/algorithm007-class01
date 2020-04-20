#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
21. Merge Two Sorted Lists
Easy
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # # 解法1, 声明一个假头结点, 循环遍历 iteratively
        # # 为空判断
        # if not l1 or not l2: return l1 or l2
        # dummy = ListNode(0)
        # cur = dummy
        # while l1 and l2:
        #     if l1.val <= l2.val:
        #         cur.next = l1
        #         cur = l1
        #         l1 = l1.next
        #     else:
        #         cur.next = l2
        #         cur = l2
        #         l2 = l2.next
        # cur.next = l1 or l2
        # return dummy.next

        # # 解法2, 精简赋值操作, 循环遍历 iteratively
        # # 为空判断
        # if not l1 or not l2: return l1 or l2
        # cur, cur.next = self, None
        # while l1 and l2:
        #     if l1.val <= l2.val:
        #         cur.next, cur, l1 = l1, l1, l1.next
        #     else:
        #         cur.next, cur, l2 = l2, l2, l2.next
        # cur.next = l1 or l2
        # return self.next

        # 解法3: 递归合并, recursion, 杀鸡焉用牛刀...纯属练手
        # 终止条件
        if not l1 or not l2: return l1 or l2
        # 交换
        if l1.val > l2.val:
            l1, l2 = l2, l1
        l1.next = self.mergeTwoLists(l1.next, l2)
        return l1
