/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map = new Map();
    // 遍历的时候从 map 中 取  target - v; 取到就返回; 否则 设置 v, 继续
    for(let index = 0; index < nums.length; index += 1) {
        if(map.has(target - nums[index])) {
            return [map.get(target-nums[index]), index];
        }else {
            map.set(nums[index], index);
        }
    }
};