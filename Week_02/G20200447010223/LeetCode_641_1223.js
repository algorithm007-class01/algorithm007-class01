/*
 *  设计实现双端队列。
 *  你的实现需要支持以下操作：
 *  MyCircularDeque(k)：构造函数,双端队列的大小为k。
 *  insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 *  insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 *  deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 *  deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 *  getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 *  getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 *  isEmpty()：检查双端队列是否为空。
 *  isFull()：检查双端队列是否满了。
 */

/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
var MyCircularDeque = function(k) {
    this.deque = new Array(k);
    this.first = 0;
    this.last = 1;
    this.size = 0;
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
    if(this.size === this.deque.length) {
        return false;
    }
    const nextFirst = this.first === 0 ? this.deque.length - 1 : this.first - 1;
    this.deque[this.first] = value;
    this.first = nextFirst;
    this.size += 1;
    return true;
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
    if(this.size === this.deque.length) {
        return false;
    }
    const nextLast = this.last === this.deque.length - 1 ? 0 : this.last + 1;
    this.deque[this.last] = value;
    this.last = nextLast;
    this.size += 1;
    return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
    if(this.size === 0) {
        return false;
    }
    const nextFirst = this.first === this.deque.length - 1 ? 0 : this.first + 1;
    delete this.deque[nextFirst];
    this.size -= 1;
    this.first = nextFirst;
    return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
    if(this.size === 0) {
        return false;
    }
    const nextLast = this.last === 0 ? this.deque.length - 1 : this.last - 1;
    delete this.deque[nextLast];
    this.size -= 1;
    this.last = nextLast;
    return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
    if(this.size === 0) {
        return -1;
    }
    if(this.first === this.deque.length - 1) {
        return this.deque[0];
    }
    return this.deque[this.first + 1];
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
    if(this.size === 0) {
        return -1;
    }
    if(this.last === 0) {
        return this.deque[this.deque.length - 1];
    }
    return this.deque[this.last - 1];
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
    return this.size === 0;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
    return this.size === this.deque.length;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
