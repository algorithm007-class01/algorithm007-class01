/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if(nums.length ==0) return 0;
    let k = 0;
    for(let i=1;i<nums.length;i++){
        if(nums[i] !== nums[k]){
           k += 1;
           nums[k]  = nums[i];
        }
    }
    return k+1;
};