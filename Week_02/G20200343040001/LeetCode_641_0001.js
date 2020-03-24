/**
 * 双端队列
 */
var MyCircularDeque_1 = function(k) {
  this.dequeue = []
  this.size = k
};

MyCircularDeque_1.prototype.insertFront = function(value) {
  if (this.isFull())
    return false
  this.dequeue.unshift(value)
  return true
};

MyCircularDeque_1.prototype.insertLast = function(value) {
  if (this.isFull())
    return false
  this.dequeue.push(value)
  return true
};

MyCircularDeque_1.prototype.deleteFront = function() {
  if (this.isEmpty())
    return false
  this.dequeue.shift()
  return true
};

MyCircularDeque_1.prototype.deleteLast = function() {
  if (this.isEmpty())
    return false
  this.dequeue.pop()
  return true
};

MyCircularDeque_1.prototype.getFront = function() {
  if (this.isEmpty()) return -1
  return this.dequeue[0]
};


MyCircularDeque_1.prototype.getRear = function() {
  if (this.isEmpty()) return -1
  return this.dequeue[this.dequeue.length - 1]
};

MyCircularDeque_1.prototype.isEmpty = function() {
  if (this.dequeue.length === 0)
    return true
  return false
};

MyCircularDeque_1.prototype.isFull = function() {
  if (this.dequeue.length === this.size)
    return true
  return false
};


/**
 * 循环双端队列
 */

var MyCircularDeque = function (k) {
  this.size = k;
  this.tail = 0;
  this.head = 0;
  this.len = 0;
  this.list = [];
};

MyCircularDeque.prototype.insertFront = function (value) {
  if (!this.isFull()) {
    this.head = (this.head + this.size - 1) % this.size; //头指针往前移动类型跳到队尾
    this.list[this.head] = value;
    this.len++;
    return true;
  }
  return false;
};

MyCircularDeque.prototype.insertLast = function (value) {
  if (!this.isFull()) {
    this.list[this.tail] = value;
    this.tail = (this.tail + 1) % this.size;
    this.len++;
    return true;
  }
  return false;
};

MyCircularDeque.prototype.deleteFront = function () {
  if (!this.isEmpty()) {
    this.head = (this.head + 1) % this.size;
    this.len--;
    return true;
  }
  return false;
};

MyCircularDeque.prototype.deleteLast = function () {
  if (!this.isEmpty()) {
    this.tail = (this.tail + this.size - 1) % this.size;
    this.len--;
    return true;
  }
  return false;
};

MyCircularDeque.prototype.getFront = function () {
  if (!this.isEmpty()) {
    return this.list[this.head];
  }
  return -1;
};

MyCircularDeque.prototype.getRear = function () {
  if (!this.isEmpty()) {
    return this.list[(this.tail + this.size - 1) % this.size];
  }
  return -1;
};

MyCircularDeque.prototype.isEmpty = function () {
  return this.len == 0;
};

MyCircularDeque.prototype.isFull = function () {
  return this.len == this.size;
};