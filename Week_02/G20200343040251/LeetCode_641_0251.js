var MyCircularDeque = function (k) {
    this.arr = [];
    this.size = k;
};

/**
 
Adds an item at the front of Deque. Return true if the operation is successful.
@param {number} value
@return {boolean}
*/
MyCircularDeque.prototype.insertFront = function (value) {
    if (this.size === this.arr.length) {
        return false;
    } else {
        this.arr.unshift(value);
        return true;
    }
};
/**
 
Adds an item at the rear of Deque. Return true if the operation is successful.
@param {number} value
@return {boolean}
*/
MyCircularDeque.prototype.insertLast = function (value) {
    if (this.size === this.arr.length) {
        return false;
    } else {
        this.arr.push(value);
        return true;
    }
};
/**
 
Deletes an item from the front of Deque. Return true if the operation is successful.
@return {boolean}
*/
MyCircularDeque.prototype.deleteFront = function () {
    if (this.arr.length === 0) {
        return false;
    } else {
        this.arr.shift();
        return true;
    }
};
/**
 
Deletes an item from the rear of Deque. Return true if the operation is successful.
@return {boolean}
*/
MyCircularDeque.prototype.deleteLast = function () {
    if (this.arr.length === 0) {
        return false;
    } else {
        this.arr.pop();
        return true;
    }
};
/**
 
Get the front item from the deque.
@return {number}
*/
MyCircularDeque.prototype.getFront = function () {
    if (this.arr.length === 0) {
        return -1;
    } else {
        return this.arr[0];
    }
};
/**
 
Get the last item from the deque.
@return {number}
*/
MyCircularDeque.prototype.getRear = function () {
    if (this.arr.length === 0) {
        return -1;
    } else {
        return this.arr[this.arr.length - 1];
    }
};
/**
 
Checks whether the circular deque is empty or not.
@return {boolean}
*/
MyCircularDeque.prototype.isEmpty = function () {
    return this.arr.length === 0
};
/**
 
Checks whether the circular deque is full or not.
@return {boolean}
*/
MyCircularDeque.prototype.isFull = function () {
    return this.arr.length === this.size;
};