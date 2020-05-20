/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
    let reg = /^[\-|\+]?\d+/;
    let res = reg.exec(str.trim());
    if (res && res.length) {
        return Math.max(Math.min(parseInt(res[0]), 2 ** 31 - 1), -(2 ** 31));
    }
    return 0;
};