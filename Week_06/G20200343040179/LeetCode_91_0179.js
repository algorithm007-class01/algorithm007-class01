var numDecodings = function(s) {
    if(s[0] === "0") return 0;
    const len = s.length;
    let dp = new Array(len+1).fill(0);
    dp[0] = dp[1] = 1;
    for(let i = 2; i <= len; i++){
        if(s[i-1] !== "0"){
            dp[i] += dp[i-1];
        }
        if((s[i-2] === "1") || (s[i-2] === "2" && s[i-1] <= 6)){
            dp[i] += dp[i-2];
        }
    }
    return dp[len]
};