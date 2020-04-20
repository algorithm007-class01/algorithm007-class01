class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []
        self.min_s = []

    def push(self, x: int) -> None:
        self.s.append(x)
        if self.min_s == []:
            self.min_s.append(x)
        elif x<=self.min_s[-1]:
            self.min_s.append(x)

    def pop(self) -> None:
        value = self.s.pop()
        if value == self.min_s[-1]:
            self.min_s.pop()
        return value

    def top(self) -> int:
        if self.s != []:
            return self.s[-1]

    def getMin(self) -> int:
        if self.min_s != []:
            return self.min_s[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()