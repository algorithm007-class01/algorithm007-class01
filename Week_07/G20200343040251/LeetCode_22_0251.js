/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    if(n == 0) return [];

    let dp = [[""]];
    for(let i =1; i<= n; i++){
        let tmp =[];
        for(let j=0; j<i; j++){
            let str1 = dp[j];
            let str2 = dp[i-1-j];
            for(let s1 of str1){
                for(let s2 of str2){
                    tmp.push(`(${s1})${s2}`);
                }
            }
        }
        dp.push(tmp);
    }
    return dp[n];
};