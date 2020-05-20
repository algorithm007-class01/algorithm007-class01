/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    if (!s || s === "") return s;
    let max = s[0];
    let loop = 0;

    while (loop < s.length && max.length <= s.length - loop) {

        let idx = Math.floor((s.length - 1) / 2) + Math.ceil(loop / 2) * (loop % 2 ? 1 : -1);

        let n = 0;
        let same = 0;
        let isBreak = false;
        while (idx - n - 1 >= 0 && s[idx - n - 1] == s[idx + n + 1]) {
            if (!isBreak && s[idx] == s[idx + n + 1]) {
                same++;
            } else {
                isBreak = true;
            }
            n++;
        }
        max = n * 2 + 1 > max.length ? s.slice(idx - n, idx + n + 1) : max;
        if (s[idx] == s[idx + same + 1] && s[idx] != s[idx - same - 1]) {
            n = same;
            while (idx - n - 1 >= 0 && s[idx - n - 1] == s[idx + n + 2]) {
                n++;
            }
            max = n * 2 + 2 > max.length ? s.slice(idx - n, idx + n + 2) : max;
        }
        loop++;
    }
    return max;
};