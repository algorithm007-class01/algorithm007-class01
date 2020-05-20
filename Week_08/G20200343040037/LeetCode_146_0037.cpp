class LRUCache {
private:
    int size_;// 记录缓存数目
    //双链表，装<key, value>元组.
    list<pair<int, int>> lru_;// 最近最少使用列表
    unordered_map<int, list<pair<int, int>>::iterator> mp_;// key - list iterator
public:
    LRUCache(int capacity) {
        size_ = capacity;
    }
    
    int get(int key) {
        // 访问的key不存在
        if(mp_.find(key) == mp_.end()) {
            return -1;
        }
        // key存在，把<k，v>放到队头
        pair<int, int> kv = *mp_[key];
        lru_.erase(mp_[key]);
        lru_.push_front(kv);

        // 更新key,value在cache中的位置
        mp_[key] = lru_.begin();
        return kv.second;

    }
    
    void put(int key, int value) {
        // 判断是否已经存在
        if(mp_.find(key) == mp_.end()) {
            // key不存在，判断cache是否已经满了.
            if(lru_.size() == size_) {
                // cache已满，删除尾部的数据以腾出位置.
                // cache和map都需要删除.
                auto lastPair = lru_.back();
                int lastKey = lastPair.first;
                mp_.erase(lastKey);
                lru_.pop_back();
            }
            // cache未满，直接插入.
            lru_.push_front(make_pair(key, value));
            mp_[key] = lru_.begin();
            
        } else {
            // key已经存在，更换至队头.
            lru_.erase(mp_[key]);
            lru_.push_front(make_pair(key, value));
            mp_[key] = lru_.begin();

        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
/*
 * class LRUCache {
private:
    int size_;// 记录缓存数目
    list<int> lru_;// 最近最少使用列表
    unordered_map<int, list<int>::iterator> mp_;// key - list iterator
    unordered_map<int, int> kv_; // key - value.
public:
    LRUCache(int capacity):size_(capacity) {

    }

    int get(int key) {
        // 判断unordered_map中是否有key，0表示没有key,则返回-1
        if (kv_.count(key) == 0) {
            return -1;
        }
        updateLRU(key);//
        return kv_[key];
    }

    void put(int key, int value) {
        // kv装满了，并且kv容器中没有key。
        if (kv_.size() == size_ && kv_.count(key) == 0) {
            // 清除.
            clear();
        }

        updateLRU(key);
        kv_[key] = value;
    }
    // 更新lru
    void updateLRU(int key) {
        // 如果kv容器中有key,删除
        if(kv_.count(key)) {
            lru_.erase(mp_[key]);
        }
        // 添加到lru中
        lru_.push_front(key);
        // 更新key, value.
        mp_[key] = lru_.begin();
    }

    void clear() {
        // 删除数据
        mp_.erase(lru_.back());
        kv_.erase(lru_.back());
        lru_.pop_back();
    }
};
 * */

