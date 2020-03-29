/**
 * 347. 前 K 个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
  if (nums == null) {
    return null;
  }
  let dict = new Map();
  //保存每个数出现的频率
  for (let v of nums) {
    let t = dict.get(v);
    dict.set(v, t == undefined ? 1 : ++t);
  }
  let arr = [];
  dict.forEach(function(value, a) {
    if (arr[dict.get(a)] == undefined) {
      let tempArr = new Array();
      tempArr.push(a);
      arr[dict.get(a)] = tempArr;
    } else {
      let c = arr[dict.get(a)];
      c.push(a);
    }
  });
  let result = [];
  for (let i = arr.length - 1; i > 0; i--) {
    let t = arr[i];
    if (t != null) {
      t.forEach((item, index, array) => {
        if (result.length == k) {
          return result;
        }
        result.push(item);
      });
    }
  }
  return result;
};
