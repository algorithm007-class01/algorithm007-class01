/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    let len = nums.length;
    if (len <= 1) return len;

    let tail = new Array(len).fill(0);
    tail[0] = nums[0];
    let end = 0;

    for (let i = 1; i < len; i++) {
        if (nums[i] > tail[end]) tail[++end] = nums[i];
        else {
            let left = 0, right = end;
            while (left < right) {
                let mid = (left + right) >> 1;
                if (tail[mid] < nums[i]) left = mid + 1;
                else right = mid;
            }
            tail[left] = nums[i];
        }
    }
    return ++end;
};