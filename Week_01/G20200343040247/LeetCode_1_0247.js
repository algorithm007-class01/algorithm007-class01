/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var ans = [];
    var exist = {};

    for (var i = 0; i < nums.length; i++){
        // target-nums[i] 检索差值是否存在遍历的过程中  
       if (typeof(exist[target-nums[i]]) !== 'undefined'){
        ans.push(exist[target-nums[i]]);
        ans.push(i);
       }
       exist[nums[i]] = i;
    }
    return ans;
};