package com.szp.leetcode.q101_150;

import java.util.*;

public class A146_lru_cache {
    class LRUCache {
        private final int capacity;
        Map<Integer, Integer> map;
        List<Integer> keys;

        public LRUCache(int capacity) {
            if (capacity <= 0)
                throw new IllegalArgumentException("capacity must greater than 0");
            this.capacity = capacity;
            keys = new ArrayList(capacity);
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                keys.remove(new Integer(key));
                keys.add(0, key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            //map中存在，直接put，keys中把该key放到队列头
            if(map.containsKey(key)){
                keys.remove(new Integer(key));
            }else {
                if (keys.size() == capacity) {
                    Integer oldKey = keys.remove(keys.size() - 1);
                    map.remove(oldKey);
                } else {
                    keys.remove(new Integer(key));
                }
            }
            keys.add(0, key);

            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new A146_lru_cache().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

}
