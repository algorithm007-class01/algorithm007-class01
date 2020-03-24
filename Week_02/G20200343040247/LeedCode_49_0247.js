/**
 * @param {string[]} strs
 * @return {string[][]}
 * 思路就是： 
 * 1.比较  需要先sort排序之后直接比较
 * 2. hashmap  key的唯一性  添加记录
 * 3. map.values 返回一个新的Iterator对象，它按插入顺序包含了Map对象中每个元素的值 。
 */
var groupAnagrams = function(strs) {
    let has = new Map();
    for(var i = 0;i<strs.length;i++){
        let str = strs[i].split('').sort().join();
        if(has.get(str)){
           var temp = has.get(str);
           temp.push(strs[i]);
           has.set(str,temp);
        }else{
            has.set(str,[strs[i]])
        }
    }
    return [...has.values()]
};