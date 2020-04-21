/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function (s) {
    let n = s.length,
        dp = new Array(n),
        count = 0;

    for (let i = 0; i < n; i++) {
        dp[i] = new Array(n).fill(false);
    }

    for (let i = 0; i < n; i++) {
        for (let j = i; j >= 0; j--) {
            if (s.charAt(j) === s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                dp[j][i] = true;
                count++;
            }
        }
    }

    return count;
};