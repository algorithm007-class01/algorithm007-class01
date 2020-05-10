#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class LRUCache {
   private:
    // 定义容量、链表空间、hashTable
    int cap;
    list<pair<int, int>> cache;
    unordered_map<int, list<pair<int, int>>::iterator> map;

   public:
    LRUCache(int capacity) {
        this->cap = capacity;
    }

    int get(int key) {
        // 获取缓存记录，并更新到第一个
        auto it = map.find(key);
        if (it == map.end()) return -1;
        pair<int, int> kv = *map[key];
        cache.erase(map[key]);
        cache.push_front(kv);
        map[key] = cache.begin();
        return kv.second;
    }

    void put(int key, int value) {
        // 更新缓存记录，并更新到第一个，如果超过容量，则删除末尾节点
        auto it = map.find(key);
        if (it == map.end()) {
            if (cache.size() == cap) {
                auto lastPair = cache.back();
                int lastKey   = lastPair.first;
                map.erase(lastKey);
                cache.pop_back();
            }
            cache.push_front(make_pair(key, value));
            map[key] = cache.begin();
        } else {
            cache.erase(map[key]);
            cache.push_front(make_pair(key, value));
            map[key] = cache.begin();
        }
    }
};