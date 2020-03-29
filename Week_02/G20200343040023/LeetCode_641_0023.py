# -*- coding: utf-8 -*-


class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.length = k
        self.queue = []

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if value is None:
            return False
        if len(self.queue) == self.length:
            return False
        self.queue.insert(0, value)
        return True

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if value is None:
            return False
        if len(self.queue) == self.length:
            return False
        self.queue.append(value)
        return True

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if not self.queue:
            return False
        self.queue.pop(0)
        return True

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if not self.queue:
            return False
        self.queue.pop(-1)
        return True

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if not self.queue:
            return -1
        return self.queue[0]

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if not self.queue:
            return -1
        return self.queue[-1]

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return len(self.queue) == 0

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return len(self.queue) == self.length


if __name__ == '__main__':
    obj = MyCircularDeque(5)
    param_1 = obj.insertFront(7)
    param_2 = obj.insertLast(0)
    param_3 = obj.getFront(3)
    param_4 = obj.insertFront(4)
    param_5 = obj.getRear()
    param_6 = obj.isFull()
    param_7 = obj.deleteLast()
    param_8 = obj.insertFront(4)
    param_9 = obj.getFront()
