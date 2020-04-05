#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
155. Min Stack
Easy
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        from collections import deque
        self.s = deque()

    def push(self, x: int) -> None:
        if self.s:
            self.s.append((x, min(x, self.s[-1][1])))
        else:
            self.s.append((x, x))

    def pop(self) -> None:
        if self.s:
            self.s.pop()

    def top(self) -> int:
        if self.s:
            return self.s[-1][0]

    def getMin(self) -> int:
        if self.s:
            return self.s[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
