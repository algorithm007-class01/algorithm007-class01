class MyCircularDeque: 

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.k = k
        self.q = []

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.k:
            self.q.insert(0, value) 
            return True
        else:
            return False

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.k:
            self.q.append(value)
            return True
        else:
            return False

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) > 0:
            self.q.pop(0) 
            return True
        else:
            return False

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) > 0:
            self.q.pop() 
            return True
        else:
            return False

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[0]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[len(self.q) - 1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return True if len(self.q) == 0 else False

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return True if len(self.q) == self.k else False

