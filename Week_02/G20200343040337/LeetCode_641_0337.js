/*
 * @lc app=leetcode.cn id=641 lang=javascript
 *
 * [641] 设计循环双端队列
 *
 * https://leetcode-cn.com/problems/design-circular-deque/description/
 *
 * algorithms
 * Medium (49.30%)
 * Likes:    26
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 11.2K
 * Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n' +
  '[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * 
 * 
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 
 * 
 * 示例：
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);                    // 返回 true
 * circularDeque.insertLast(2);                    // 返回 true
 * circularDeque.insertFront(3);                    // 返回 true
 * circularDeque.insertFront(4);                    // 已经满了，返回 false
 * circularDeque.getRear();                  // 返回 2
 * circularDeque.isFull();                        // 返回 true
 * circularDeque.deleteLast();                    // 返回 true
 * circularDeque.insertFront(4);                    // 返回 true
 * circularDeque.getFront();                // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * 
 * 
 */

// @lc code=start
/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
var MyCircularDeque = function(k) {
  this.maxLen = k;
  this.dq = [];
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
  if (this.dq.length == this.maxLen) return false;
  this.dq.unshift(value);
  return true
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
  if (this.dq.length == this.maxLen) return false;
  this.dq.push(value);
  return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
  if (this.dq.length == 0) return false;
  this.dq.splice(0, 1);
  return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
  if (this.dq.length == 0) return false;
  this.dq.pop();
  return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
  return this.dq.length == 0 ? -1 : this.dq[0];
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
  return this.dq.length == 0 ? -1 : this.dq[this.dq.length - 1];
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
  return 0 == this.dq.length;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
  return this.maxLen == this.dq.length;
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
// @lc code=end

