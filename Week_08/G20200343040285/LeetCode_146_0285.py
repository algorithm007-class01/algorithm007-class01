class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.dic = collections.OrderedDict()
        self.remain = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.dic:
            return -1
        v = self.dic.pop(key)
        self.dic[key] = v
        return v

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.dic:
            self.dic.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:
                self.dic.popitem(last=False)
        self.dic[key] = value