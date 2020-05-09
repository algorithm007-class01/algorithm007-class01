/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length != t.length) return false;
    let countMap = {};
    for(let item of s){
        countMap[item] = (countMap[item]||0)+1;
    }
    for(let item of t){
        if(!countMap[item]) return false;
        countMap[item]--;
    }
    for(let attr in countMap){
        if(countMap[attr] > 0) return false;
    }
    return true;
};