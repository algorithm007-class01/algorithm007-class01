// javascript
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
// 输入: [0,1,0,3,12]  i = 1;  => value: 1  j = 0  num[0] = 1; 
// 输出: [1,3,12,0,0]

// 1. leetcode 解析es6语法需要耗时间 导致效率特别低..  116ms
// const moveZeroes = (numsArr) => {
//     let j = 0;
//     for(let i = 0; i<numsArr.length; i++) {  // O(n^2) 
//         if (numsArr[i] !== 0) {
//             numsArr[j] = numsArr[i];
//             if (i !== j) {
//                  numsArr[i] = 0;
//             }
//             j++;
//         } 
//     }
// }

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.  => 72ms
 */
var moveZeroes = function(nums) {
    var j = 0;
    for(var i = 0; i<nums.length; i++) {  
        if (nums[i] !== 0) {
            nums[j] = nums[i];
            if (i !== j) {
                nums[i] = 0; 
            }
        } 
    }
};

// 2. 不推荐 还是写下 开辟额外的空间.. arr;

const moveZeroes = (nums, arr = [])  => {
    nums.forEach(element => {
        if (element !== 0)  arr.push(element);
    });
    arr.fill(0, arr.length-1, nums.length);
    return arr;
}
