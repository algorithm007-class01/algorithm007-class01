/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {

    const len = digits.length;

    for (let i = len - 1; i >= 0; i--) {
        digits[i]++;
        digits[i] %= 10;
        if (0 === digits[i]) {
            continue;
        } else {
            break;
        }
    }

    if (0 === digits[0]) {
        digits = [...Array(len + 1)].map(() => 0);;
        digits[0] = 1;
    }

    return digits;
}


