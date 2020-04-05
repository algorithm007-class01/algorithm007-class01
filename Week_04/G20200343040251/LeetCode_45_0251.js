/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let ans = 0;
    let end = 0;
    let maxPos = 0;
    for (let i = 0; i < nums.length - 1; i++)
    {
        maxPos = Math.max(nums[i] + i, maxPos);
        if (i == end)
        {
            end = maxPos;
            ans++;
        }
    }
    return ans;
};