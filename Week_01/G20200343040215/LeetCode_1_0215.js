/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let res = [];
    if(!nums || nums.length<=1) return res;

    let map = {};//key-value
    for(let i =0; i< nums.length; i++){
        let diff = target - nums[i];
        if(map[diff]!== undefined){
            res = [map[diff], i];
        }
        map[nums[i]] = i;
    }
    return res;
};