/**
 * 66. 加一 https://leetcode-cn.com/problems/plus-one/
 * @param {number[]} digits
 * @return {number[]}
 */
// 时间复杂度 O(n) 空间复杂度 O(1)
var plusOne_1 = function(digits) {
  // 数组反向循环
  for (let i = digits.length - 1; i >= 0; i--) {
    // 当前项
    let item = digits[i];
    // 判断当前项加一是否大于9（即等于10）
    if (item + 1 > 9) {
      // 将此项置为0
      digits[i] = 0;
      // 如果当前项为数组首项时
      if (i == 0) {
        // 向数组首项添加1,并返回当前数组
        digits.unshift(1);
        return digits;
      }
    } else {
      // 当前项小于9时进行加一操作并返回当前数组
      digits[i]++;
      return digits;
    }
  }
};

// 使用 ES10 基本类型 BigInt 时间复杂度 O(1)
var plusOne_2 = function(digits) {
  /**
   * 将数组每一项合并成字符串，再将此字符串转化为大数整型,
   * 将此大数整型加一(大数整型加一时需要在常量后面加 n),
   * 将结果转化为字符串并截取为数组
   */
  return (BigInt(digits.join("")) + 1n + "").split("");
};

// 快慢双指针 时间复杂度 O(n) 空间复杂度 O(1)
var plusOne_3 = function(digits) {
  // 创建慢指针 j
  let j = digits.length - 1;
  // 数组反向循环，i 为快指针
  for (let i = digits.length - 1; i >= 0; i--) {
    // 数组当前项
    let item = digits[i];
    // 判断当前项加一是否大于9
    if (item + 1 > 9) {
      // 如果大于9 将此项置为0，并将慢指针向左移动一位
      digits[i] = 0;
      j--;
    } else {
      // 如果小于等于9 将此项加一，并返回当前数组
      digits[i] = item + 1;
      return digits;
    }
    // 如果慢指针超出数组范围，则将此数组进行追加一个首项值为1，且返回当前数组
    if (j === -1) {
      digits.unshift(1);
      return digits;
    }
  }
};
