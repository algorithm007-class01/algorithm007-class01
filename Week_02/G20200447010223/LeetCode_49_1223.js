/**
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const groupMap = new Map();
    function add(str) {
        const s = str.split('').sort().join('');
        if(groupMap.has(s)) {
            groupMap.get(s).push(str);
        }else{
            groupMap.set(s, [str]);
        }
    }
    for(let i = 0; i < strs.length; i ++) {
        add(strs[i]);
    }
    return [...groupMap.values()];
};
