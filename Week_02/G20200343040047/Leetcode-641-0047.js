/**
 * 641. 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
 */
/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
var MyCircularDeque = function(k) {
  var initialCapacity = 8;
  if (k >= initialCapacity) {
    initialCapacity = k;
    initialCapacity |= initialCapacity >>> 1;
    initialCapacity |= initialCapacity >>> 2;
    initialCapacity |= initialCapacity >>> 4;
    initialCapacity |= initialCapacity >>> 8;
    initialCapacity |= initialCapacity >>> 16;
    initialCapacity |= initialCapacity >>> 32;
    initialCapacity++;
    if (initialCapacity < 0)
      // Too many elements, must back off
      initialCapacity >>>= 1; // Good luck allocating 2 ^ 52 elements
  }
  this.ArrDeque = new Array(initialCapacity);
  this.front = 0;
  this.rear = 0;
  this.n = initialCapacity;
  this.k = k;
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
  if (this.isFull("front")) {
    return false;
  } else {
    this.front = (this.front - 1) & (this.n - 1);
    this.ArrDeque[this.front] = value;
    return true;
  }
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
  if (this.isFull("last")) {
    return false;
  } else {
    this.ArrDeque[this.rear] = value;
    this.rear = (this.rear + 1) & (this.n - 1);
    return true;
  }
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
  if (this.isEmpty()) {
    return false;
  } else {
    this.front = (this.front + 1) & (this.n - 1);
    return true;
  }
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
  if (this.isEmpty()) {
    return false;
  } else {
    this.rear = (this.rear - 1) & (this.n - 1);
    return true;
  }
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
  return this.isEmpty() ? -1 : this.ArrDeque[this.front];
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
  return this.isEmpty() ? -1 : this.ArrDeque[(this.rear - 1) & (this.n - 1)];
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
  if (this.front == this.rear) {
    return true;
  } else {
    return false;
  }
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function(x) {
  return ((this.rear - this.front) & (this.n - 1)) == this.k;
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
