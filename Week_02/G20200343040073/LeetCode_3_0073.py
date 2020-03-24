from collections import deque
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.capacity=k
        self.nums=deque()

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.nums)==self.capacity:
            return False
        else:
            self.nums.appendleft(value)
            return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.nums)==self.capacity:
            return False
        else:
            self.nums.append(value)
            return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if not self.nums:
            return False
        else:
            self.nums.popleft()
            return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if not self.nums:
            return False
        else:
            self.nums.pop()
            return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if not self.nums:
            return -1
        else:
            return self.nums[0]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if not self.nums:
            return -1
        else:
            return self.nums[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return not self.nums

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.nums)==self.capacity
