/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res =0;
    for(let pos =31; n!=0; n = n >>>1, pos--){
        res += (n &1) << pos;
    }
    return res >>> 0;
};