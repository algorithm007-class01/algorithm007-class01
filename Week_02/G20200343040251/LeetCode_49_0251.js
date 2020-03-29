var groupAnagrams = function(strs) {
    if(strs.length<=0) return [];

    let res = new Map();

    for(let index = 0; index < strs.length; index++) {
        let str = strs[index].split("").sort().join();
        if(res.has(str)) {
            let val = res.get(str);
            val.push(strs[index]);
            res.set(str, val);
        } else {
            res.set(str, [strs[index]])
        }
    }
    return [...res.values()];
};