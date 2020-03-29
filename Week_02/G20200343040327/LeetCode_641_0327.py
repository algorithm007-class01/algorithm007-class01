from collections import deque


class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.queue = deque(maxlen=k)

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        return len(self.queue) < self.queue.maxlen and (self.queue.appendleft(value) or True)

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        return len(self.queue) < self.queue.maxlen and (self.queue.append(value) or True)

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        return len(self.queue) > 0 and (self.queue.popleft() or True)

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        return len(self.queue) > 0 and (self.queue.pop() or True)

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return not len(self.queue) and -1 or self.queue[0]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return not self.queue and -1 or self.queue[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return not self.queue

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.queue) == self.queue.maxlen
