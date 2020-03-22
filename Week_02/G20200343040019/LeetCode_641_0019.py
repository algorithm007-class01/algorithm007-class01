class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.deque = [-1 for x in range(k)]
        self.index = 0
        self.length = k


    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if  self.index  < self.length:
            pre = value
            for i in range(self.index + 1):
                pre, self.deque[i] = self.deque[i], pre
            self.index += 1
            return True
        return False


    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.index < self.length:
            self.deque[self.index] = value
            self.index += 1
            return True
        return False


    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.index>0:
            for i in range(self.index-1):
                self.deque[i] = self.deque[i+1]
            self.index -= 1
            self.deque[self.index] = -1
            return True
        return False
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.index > 0:
            self.index -= 1
            self.deque[self.index] = -1
            return True
        return False
        

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return self.deque[0]


    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return self.deque[self.index-1]
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.index == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.index==self.length
        


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()