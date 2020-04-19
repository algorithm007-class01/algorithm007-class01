/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let dis = 0;
    const len = nums.length;
    for(let i = 0; i < len; i ++) {
        if(nums[i] === 0 && dis <= i) break;
        dis = Math.max(dis, nums[i]+i);
    }
    return dis >= len- 1;
};