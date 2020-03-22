
var MyCircularDeque = function(k) {
    var initialCapacity = 8;
    if (k >= initialCapacity) {
        initialCapacity = k;
        initialCapacity |= (initialCapacity >>>  1);
        initialCapacity |= (initialCapacity >>>  2);
        initialCapacity |= (initialCapacity >>>  4);
        initialCapacity |= (initialCapacity >>>  8);
        initialCapacity |= (initialCapacity >>> 16);
        initialCapacity |= (initialCapacity >>> 32);
        initialCapacity++;
 
        if (initialCapacity < 0)  
            initialCapacity >>>= 1;
    }
    this.ArrDeque = new Array(initialCapacity);
    this.front = 0;
    this.rear = 0;
    this.n = initialCapacity;
    this.k = k;
};

MyCircularDeque.prototype.insertFront = function(value) {
    if(this.isFull('front')){
        return false;
    }else{
        this.front = (this.front - 1) & (this.n-1);
        this.ArrDeque[this.front] = value;
        return true;
    }
};

MyCircularDeque.prototype.insertLast = function(value) {
    if(this.isFull('last')){
        return false;
    }else{
        this.ArrDeque[this.rear] = value; 
        this.rear = (this.rear+1) & (this.n-1);
        return true;
    }
};

MyCircularDeque.prototype.deleteFront = function() {
    if(this.isEmpty()){
        return false;
    }else{
        this.front = (this.front + 1) & (this.n-1);
        return true;
    }
};

MyCircularDeque.prototype.deleteLast = function() {
    if(this.isEmpty()){
        return false
    }else{
        this.rear = (this.rear-1) & (this.n-1);
        return true;
    }
};

MyCircularDeque.prototype.getFront = function() {
    return this.isEmpty() ? -1 : this.ArrDeque[this.front]
};

MyCircularDeque.prototype.getRear = function() {
    return this.isEmpty() ? -1 : this.ArrDeque[(this.rear-1) & (this.n-1)]
};

MyCircularDeque.prototype.isEmpty = function() {
    if(this.front == this.rear){
        return true;
    }else{
        return false;
    }
};

MyCircularDeque.prototype.isFull = function(x) {
    return ((this.rear - this.front) & (this.n-1)) == this.k;
};