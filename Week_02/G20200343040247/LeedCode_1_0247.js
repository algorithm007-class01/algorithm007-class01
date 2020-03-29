/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let has = new Map();
    //arr transform map
    for(let i = 0;i<nums.length;i++){
      has.set(nums[i],i)
    }
    for(let i = 0;i<nums.length;i++){
        let tarIndex = has.get(target-nums[i]);
      if(tarIndex && tarIndex != i){
          return [i,tarIndex]
      }
    }
};