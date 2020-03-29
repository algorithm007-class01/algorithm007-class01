[题目地址](https://leetcode-cn.com/problems/linked-list-cycle/)



- :grin: 第一次练习  2020年3月17日 五毒神掌
- :shit: 第二次练习 



### 利用两个栈

![image-20200317201851102](../.vuepress/public/image-20200317201851102.png)

查看上图，需要理解当 Stack 中入栈元素为 `5、6、4、2、7、9、1、3` 最小栈中对应元素为 `5、4、2、1`

```javascript
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.minStack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    if (this.minStack.length === 0 || this.minStack[this.minStack.length - 1] >= x) {
        this.minStack.push(x);
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if (this.stack.length === 0) {
        throw Error("Stack is Empty");
    }

    let e = this.stack.pop();
    if (this.minStack.length !== 0 && this.minStack[this.minStack.length - 1] === e) {
        this.minStack.pop();
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    if (this.stack.length === 0) {
        return null;
    }

    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    if (this.minStack.length === 0) {
        return null;
    }

    return this.minStack[this.minStack.length - 1];
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
```



### 两次入栈法

通过变量 min 存储当前最小的元素 `Number.MAX_VALUE` ，每次入栈的时候，如果发现当前元素比 `min` 小，就先将 min 入栈，而后在将元素入栈，这样在最小元素出栈的时候就出两次栈，这样就可以保证 `min` 变量存储的始终是最小的元素

```javascript
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.min = Number.MAX_VALUE;
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    if (x <= this.min) {
        this.stack.push(this.min);
        this.min = x;
    }
    
    this.stack.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if (this.stack.pop() === this.min) {
        this.min = this.stack.pop();
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    if (this.stack.length === 0) {
        return null;
    }

    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
```



### 易错点

- 需要注意，在判断元素大小的时候，需要考虑到等于的情况。
- 注意条件判断问题。
- 使用一个栈的方法时需要注意，需要先处理最小值问题，在入栈本来的元素，顺序不可颠倒![min_stack_js](../.vuepress/public/min_stack_js.png)
