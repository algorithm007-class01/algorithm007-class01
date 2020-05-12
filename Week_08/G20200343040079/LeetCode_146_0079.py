#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/lru-cache/
题目描述
146. LRU Cache
Medium
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
"""

import collections


class LRUCache:

    def __init__(self, capacity: int):
        self.d = collections.OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        val = -1
        if key in self.d:
            val = self.d.pop(key)
            self.d[key] = val
        return val

    def put(self, key: int, value: int) -> None:
        if key in self.d:
            self.d.pop(key)
        elif len(self.d) >= self.capacity:
            self.d.popitem(last=False)
        self.d[key] = value
        return


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
