/**
 * 66. 加一 https://leetcode-cn.com/problems/plus-one/
 * @param {number[]} digits
 * @return {number[]}
 */
// 使用数组 从后向前计算
var plusOne = function(digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    let item = digits[i];
    if (item + 1 > 9) {
      digits[i] = 0;
      if (i == 0) {
        digits.unshift(1);
        return digits;
      }
    } else {
      digits[i]++;
      return digits;
    }
  }
};

// 使用 ES10 基本类型 BigInt
// var plusOne = function(digits) {
//     // console.log();
//    return ((BigInt(digits.join("")) + 1n) + "").split("");
// };
