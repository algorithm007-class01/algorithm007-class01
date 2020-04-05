/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g = g.sort((a,b)=>a-b);
    s = s.sort((a,b)=>a-b);

    let glen = g.length, sLen = s.length;
    let i=0, j=0, res=0;

    while(i<glen && j<sLen){
        if(s[j]>=g[i]){
            res++;
            i++;
            j++
        } else j++;
    }
    return res;
    
};