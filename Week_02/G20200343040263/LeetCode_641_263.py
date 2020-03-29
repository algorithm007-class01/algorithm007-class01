# 设计循环双端队列
def __init__(self, k):
    self.deque = []
    self.k = k
def insertFront(self, value):
    if self.isFull():
        return False
    self.deque.insert(0,value)
    return True
def insertLast(self, value):
    if self.isFull():
        return False
    # 队的插入是在后面插入元素
    self.deque.append(value)
    return True
def deleteFront(self):
    if self.isEmpty():
        return False
    else:
        self.deque.pop(0)
        return True
def deleteLast(self):
    if self.isEmpty():
        return False
    else:
        # 队的删除是在后面删除
        self.deque.pop()
        return True
def getFront(self):
    if self.isEmpty():
        return -1
    else:
        return self.deque[0]
def getRear(self):
    if self.isEmpty():
        return -1
    else:
        return self.deque[-1]
def isEmpty(self):
    if self.deque == []:
        return True
    else:
        return False
def isFull(self):
    if len(self.deque) == self.k:
        return True
    else:
        return False