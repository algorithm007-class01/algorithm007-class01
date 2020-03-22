/**
 * @param {number[]} nums
 * @return {number}
 */
/**
 * 
 * 思路：
 * 1.遇到不重复的，移动到重复的上一个元素的+1的位置
 */
var removeDuplicates = function(nums) {
    //定一一个下标，记录重复的次数
     var count = 0;
     for(var i = 1;i < nums.length;i++){
         //相邻元素不相等           交换原则是： 每个元素移动的距离等于 重复的次数 （移动到的下标位置，就是 i-count）
         if(nums[i] !== nums[i-1]){
            nums[i-count] = nums[i];
         }else{
             count++
         }
     }
     //数组开始不重复的部分的长度 = 数组长度  - 重复的次数（重复的内容长度）
     return nums.length - count
}; 