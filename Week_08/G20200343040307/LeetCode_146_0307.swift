/*
 * @lc app=leetcode.cn id=146 lang=swift
 *
 * [146] LRU缓存机制
 */

// @lc code=start

class LRUCache {

    var count: Int
    var dic: [Int: CacheNode]
    var head: CacheNode?
    var tail: CacheNode?
    init(_ capacity: Int) {
        self.dic = [Int: CacheNode]()
        self.count = capacity
        self.head = CacheNode()
        self.tail = CacheNode()
        head?.next = tail
        tail?.pre = head
    }
    
    func get(_ key: Int) -> Int {
        if let node =  dic[key] {
            node.pre?.next = node.next
            node.next?.pre = node.pre

            node.next = self.head?.next
            node.pre = head
            head?.next?.pre = node
            head?.next = node


            return node.value
        }
        return -1
    }
    
    func put(_ key: Int, _ value: Int) {
        var new = CacheNode(key, value)
        if var node = dic[key]{
            // 删除当前
            node.pre?.next = node.next
            node.next?.pre = node.pre
        }else{
            if self.count == 0 {
                let node = tail!.pre
                dic.removeValue(forKey: node!.key)
                node?.pre?.next = tail
                node?.next?.pre = node?.pre
            }else{
                count -= 1
            }
        }
        
        
        new.next = self.head?.next
        new.pre = head
        head?.next?.pre = new
        head?.next = new
        dic[key] = new
        // print("\(head?.next?.key)")
    }
}

class CacheNode {
    var key: Int
    var value: Int
    var pre: CacheNode?
    var next: CacheNode?

    init() {
        self.key = -1
        self.value = -1
        self.pre = nil
        self.next = nil
    }

    init(_ key: Int, _ value: Int) {
        self.key = key
        self.value = value
        self.pre = nil
        self.next = nil
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache(capacity)
 * let ret_1: Int = obj.get(key)
 * obj.put(key, value)
 */
// @lc code=end

