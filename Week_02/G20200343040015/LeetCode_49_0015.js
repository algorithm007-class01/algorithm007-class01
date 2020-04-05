/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let hash = new Map();
    for(let i=0;i<strs.length;i++){
        let arr =new Array(26).fill(0);
        for(let j=0;j<strs[i].length;j++){
            arr[strs[i].charCodeAt(j)-97]++;
        }
        let arrStr=arr.join();
        if(hash.has(arrStr)){
            let temp = hash.get(arrStr);
            temp.push(strs[i]);
            hash.set(arrStr,temp);
        }else{
            hash.set(arrStr,[strs[i]]);
        }
    }
    return [...hash.values()];
};
