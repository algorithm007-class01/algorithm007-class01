/**
 * @param {number[]} height
 * @return {number}
 */

 
var trap = function(height) {
    var ans = 0, current = 0, stack = [];
    Array.prototype.empty = function() {
        return this.length === 0;
    }
    Array.prototype.top = function() {
        if(this.length) {
            return this[this.length - 1];
        }
    }
    for(; current < height.length; current++) {
        while(!stack.empty() && height[current] > height[stack.top()]) { // 当栈非空且当前的大于栈顶
            var top = stack.pop(); // 弹出栈顶元素，即为洼地
            if(stack.empty()) { 
                break;
            }
            // 当前元素和栈顶元素的距离
            var distance = current - stack.top() - 1; 
            // 计算出高度 当前高度和弹出后的栈顶高度取最小，减去洼地高度
            var bounded_height = Math.min(height[current], height[stack.top()]) - height[top]; 
            ans += distance * bounded_height;
        }
        stack.push(current)
    }
    return ans
};