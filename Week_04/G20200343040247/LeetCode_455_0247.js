/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 * 贪心算法
 */
var findContentChildren = function(g, s) {
    var newG = g.sort((a,b)=>{return a-b})
    var newS = s.sort((a,b)=>{return a-b})
    var i = 0;
    var j = 0;
    var gLen = g.length;
    var sLen = s.length;
    var max  = 0;
    while(i<gLen && j < sLen){
        if(newS[j] >= newG[i]){
            max++;
            i++;
            j++
        }else{
            j++
        }    
    }
    return max;
};