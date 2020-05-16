#include <iostream>
#include <vector>
#include <list>
#include <unordered_map>

using namespace std;

class LRUCache {
public:
    LRUCache(int capacity):capacity_(capacity){
    }

    int get(int key) {
        auto it = map_.find(key);
        if (it == map_.end()) {
            return -1;
        }

        pair<int, int> elem = *map_[key];
        cache_.erase((map_[key]));
        cache_.push_front(elem);

        return elem.second;
    }

    void put(int key, int value) {
        if (map_.find(key) == map_.end()) {
            if (cache_.size() == capacity_) {
                auto last_elem = cache_.back();
                int last_key = last_elem.first;
                map_.erase(last_key);
                cache_.pop_back();
            }

            cache_.push_front(make_pair(key, value));
            map_[key] = cache_.begin();
        } else {
            cache_.erase(map_[key]);
            cache_.push_front(make_pair(key, value));
            map_[key] = cache_.begin();
        }
    }

private:
    int capacity_;
    // store (key, value) tuple
    list<pair<int, int>> cache_;
    // hash table, kep map to tuple location in cache_
    unordered_map<int, list<pair<int, int>>::iterator> map_;
};

void test_case() {
    LRUCache cache(2);

    cache.put(1, 1);
    cache.put(2, 2);
    cout << cache.get(1) << endl;      // 返回  1
    cache.put(3, 3);            // 该操作会使得密钥 2 作废
    cout << cache.get(2) << endl;      // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cout << cache.get(1) << endl;       // 返回 -1 (未找到)
    cout << cache.get(3) << endl;       // 返回  3
    cout << cache.get(4) << endl;       // 返回  4
}

int main(int argc, char* argv[]) {
    test_case();
    return 0;
}