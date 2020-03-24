/*
 * @lc app=leetcode.cn id=641 lang=swift
 *
 * [641] 设计循环双端队列
 */

// @lc code=start

class MyCircularDeque {

    var array: [Int]()
    var count: Int
    var max: Int
    /** Initialize your data structure here. Set the size of the deque to be k. */
    init(_ k: Int) {
        self.array = [Int]()
        self.max = k
        self.count = 0
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    func insertFront(_ value: Int) -> Bool {
        if count == max {
            return false
        }
        count += 1
        maxArr.insert(value, at: 0)
        return true
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    func insertLast(_ value: Int) -> Bool {
        if count == max {
            return false
        }
        count += 1
        maxArr.append(value)
        return true
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    func deleteFront() -> Bool {
        if count == 0 {
            return false
        }
        deque.removeFirst()
        count -= 1 
        return true
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    func deleteLast() -> Bool {
        if count == 0 {
            return false
        }
        deque.removeLast()
        count -= 1 
        return true
    }
    
    /** Get the front item from the deque. */
    func getFront() -> Int {
        return array.first！
    }
    
    /** Get the last item from the deque. */
    func getRear() -> Int {
        return array.last！
    }
    
    /** Checks whether the circular deque is empty or not. */
    func isEmpty() -> Bool {
        return count == 0
    }
    
    /** Checks whether the circular deque is full or not. */
    func isFull() -> Bool {
        return count == max
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * let obj = MyCircularDeque(k)
 * let ret_1: Bool = obj.insertFront(value)
 * let ret_2: Bool = obj.insertLast(value)
 * let ret_3: Bool = obj.deleteFront()
 * let ret_4: Bool = obj.deleteLast()
 * let ret_5: Int = obj.getFront()
 * let ret_6: Int = obj.getRear()
 * let ret_7: Bool = obj.isEmpty()
 * let ret_8: Bool = obj.isFull()
 */
// @lc code=end

