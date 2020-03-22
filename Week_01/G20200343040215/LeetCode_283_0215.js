/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    if(!nums || nums.length<=1){
        return nums;
    }
    let indexNoneZero = 0;
    for(let i = 0; i< nums.length; i++){
        if(0!=nums[i]){
            let tep = nums[i];
            nums[i]=0;
            nums[indexNoneZero++] = tep;
        }            
    }
    return nums;

};