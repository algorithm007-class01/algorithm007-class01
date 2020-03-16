/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if(nums.length === 0) {
        return 0;
    }
    let newLen = 0;
    nums.forEach((value) => {
        if(value !== nums[newLen]) {
            newLen += 1;
            nums[newLen] = value;
        }
    });
    return newLen + 1;
};

module.exports.removeDuplicates = removeDuplicates;