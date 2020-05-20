/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
    if (s == null || s.length == 0) return 0;
    const dp = Array(s.length + 1).fill(0);
    dp[0] = 1;
    dp[1] = s[0] !== "0" ? 1 : 0;
    for (let i = 2; i < s.length + 1; i++) {
        const one = +s.slice(i - 1, i);
        const two = +s.slice(i - 2, i);

        if (two >= 10 && two <= 26)  dp[i] = dp[i - 2];
        if (one >= 1 && one <= 9) dp[i] += dp[i - 1];
    }
    return dp[dp.length - 1];
};

//dp[i] = dp[i-1]+ dp[i-2]