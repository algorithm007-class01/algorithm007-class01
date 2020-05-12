class LRUCache:
    # class ListNode:
    #     def __init__(self, val):
    #         self.val = val
    #         self.pre = None
    #         self.next = None


    def __init__(self, capacity: int):
        self.data = collections.OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.data:
            return -1
        val = self.data.pop(key)
        self.data[key] = val
        return val

    def put(self, key: int, value: int) -> None:
        if key in self.data:
            self.data.pop(key)
        else:
            if self.capacity>0:
                self.capacity-=1
            else:
                self.data.popitem(last=False)
        self.data[key] = value

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)