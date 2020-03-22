[题目地址](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)



- 😨 第一次刷题 2020年3月10日
- 😜 第二次刷题 2020年3月11日



### **利用 hash 表存储值和索引**

::: warning

以前练习的时候做过，结果现在记不到了💩

:::

```javascript
/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  // loop -> i, nums[i] - target
  let map = new Map();

  for (let i = 0; i < nums.length; i++) {
    if (map.has(target - nums[i])) {
      return [map.get(target - nums[i]), i];
    }

    map.set(nums[i], i);
  }

  return null;
};
// @lc code=end

```



### 问题集锦

- 在每次的向 Hash 表中添加元素时，不需要再 else 中的逻辑写。直接在 循环的最后写就好![code](../.vuepress/public/code.png)

  **推荐写法**

  ![double_sum](../.vuepress/public/double_sum.png)