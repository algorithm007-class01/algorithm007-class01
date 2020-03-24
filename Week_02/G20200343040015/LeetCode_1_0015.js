/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = new Map();
    for(let i=0;i<nums.length;i++){
        let con = target - nums[i];
        if(map.has(con)) {
            return [map.get(con),i];
        };
        map.set(nums[i],i);
    }
};