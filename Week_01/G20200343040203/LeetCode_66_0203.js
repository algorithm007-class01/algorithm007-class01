/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

/**
 * 输入: [1,2,3]
 * 输出: [1,2,4] 
*/

// /**
//  * @param {number[]} digits
//  * @return {number[]}
//  */
// var plusOne = function(digits) { //  js的最大安全整数是2^{53}-12 
//     return ( Number(digits.join('')) + 1).toString().split('');  // js 运算的局限性...  error...
// };


// 1. 无进位 一般化处理 12 -》 13
// 2. 有进位且最后一位无进位  199 -》 200
// 3. 有进位且最后一位要进位：999 -》 1000

var plusOne = function(digits) {
    // 倒叙遍历..
    for (var i = digits.length - 1 ; i >= 0; i--) {
        var  number = digits[i];
        if (number + 1 > 9) {
            digits[i] = 0;
            if (i == 0) {
                digits.unshift(1);
                return digits;
            }
        } else {
            digits[i] ++;
            return digits;
        }
    }
}

// 2. BigInt

var plusOne = function(digits) {
    return BigInt(BigInt(digits.join('')) + 1n).toString().split('')  // 无敌...;
};