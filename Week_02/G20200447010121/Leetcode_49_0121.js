const groupAnagrams = function(strs) {
    let map = new Map()
    for(let i = 0; i < strs.length; i++) {
        const current = strs[i].split('').sort().join()
        map.set(current, [...(map.has(current) ? map.get(current) : []), strs[i]])
    }
    return [...map.values()]
}