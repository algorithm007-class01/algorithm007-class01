/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if(!nums || nums.length <=1) return;
    let index =1;//nums[0]作为第一次比较的基准，故需要修改的下标从1开始
    for( let i =0; i< nums.length-1; i++){
        if(nums[i]!= nums[i+1]){
            nums[index++] = nums[i+1];
        }
    }
    return index;
};