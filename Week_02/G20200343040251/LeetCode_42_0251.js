/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(!height || height.length == 0){
        return 0;
    }
    let stack = [];
    let res = 0;
    for(let i = 0;i < height.length;i++){
        while(stack.length != 0 && height[stack[stack.length-1]] < height[i]){
            let tmp = stack.pop();
            if(stack.length == 0){
                break;
            }
            res += (Math.min(height[i],height[stack[stack.length-1]]) - height[tmp]) * (i - stack[stack.length-1] - 1);
        }
        stack.push(i);
    }
    return res;
};