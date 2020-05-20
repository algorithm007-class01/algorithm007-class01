/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
    if (!s || s.length <= 0 || !p || p.length <= 0) return [];
    let res = [];
    let letters = new Array(26).fill(0);
    let windows = new Array(26).fill(0);
    let left = 0, right = 0, total = p.length;
    let a = 'a'.charCodeAt(0);

    for (let ch of p) letters[ch.charCodeAt(0) - a]++;

    while (right < s.length) {
        let ch = s[right].charCodeAt(0);
        if (letters[ch - a] > 0) {
            windows[ch - a]++;
            if (windows[ch - a] <= letters[ch - a]) total--;
        }
        while (total == 0) {
            if (right - left + 1 == p.length) res.push(left);
            let chl = s[left].charCodeAt(0);
            if (letters[chl - a] > 0) {
                windows[chl - a]--;
                if (windows[chl - a] < letters[chl - a]) total++;
            }
            left++;
        }
        right++;
    }
    return res;
};