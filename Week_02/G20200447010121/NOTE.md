## 栈和队列的基本实现和特性
Stack： last in first out
Queue： last in last out

insert: O(1)
delete: O(1)
lookup: O(n)

## 栈的实现
```javascript 
function Stack() {
    this.dataStore = []
    this.top = 0
}
Stack.prototype.push = function(el) {
    this.dataStore[this.top++] = el
}
Stack.prototype.pop = function() {
    return this.dataStore[--this.top]
}
Stack.prototype.peek = function() {
    return this.dataStore[this.top-1]
}
Stack.prototype.length = function() {
    return this.top
}
```
## 队列的实现
```javascript 
function Queue() {
    this.dataStore = []
}
Queue.prototype.enqueue = function(el) {
    this.dataStore.push(el)
}
Queue.prototype.dequeue = function() {
    return this.dataStore.shift()
}
Queue.prototype.front = function() {
    return this.dataStore[0]
}
Queue.prototype.back = function() {
    return this.dataStore[this.dataStore.length - 1]
}
Queue.prototype.empty = function() {
    return this.dataStore.length === 0
}
```

## 双端队列的实现
```javascript
function Dequeue(k) {
    this.dataStore = []
}
Dequeue.prototype.insertFront = function (value) {
    this.dataStore.unshift(value)
}
Dequeue.prototype.insertLast = function (value) {
    this.dataStore.push(value)
}
Dequeue.prototype.deleteFront = function () {
    if(this.dataStore.length) {
        this.dataStore.shift()
    }
}
Dequeue.prototype.deleteLast = function () {
    if(this.dataStore.length) {
        this.dataStore.pop()
    }
}
Dequeue.prototype.getFront = function () {
    if (this.dataStore.length) {
        return this.dataStore[0]
    }
}
Dequeue.prototype.getRear = function () {
    if (this.dataStore.length) {
        return this.dataStore[this.dataStore.length - 1]
    }
}
Dequeue.prototype.empty = function () {
    return this.dataStore.length === 0
}
```
## 优先队列
insert: O(1)
delete: O(1)
lookup: O(logN)

## 哈希表
```javascript
function HashTable() {
    this.table = new Array(137)
}
HashTable.prototype.simpleHash = function (data) {
    var total = 0
    for(var i = 0; i < data.length; ++i) {
        total += data.charCodeAt(i)
    }
    return total % this.table.length
}
HashTable.prototype.put = function (data) {
    var pos = this.simpleHash(data)
    this.table[pos] = data
}
HashTable.prototype.get = function (data) {
    return this.table[this.simpleHash(data)]
}
```
## Map
get
set
has
delete

## set
has
add
delete

