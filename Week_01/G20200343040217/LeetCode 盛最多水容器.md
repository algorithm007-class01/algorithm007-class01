[题目地址](https://leetcode-cn.com/problems/container-with-most-water/)

- 🤒 第一次练习  2020年3月9日
- 🙄 第二次练习  2020年3月9日
- 🙂 第三次练习  2020年3月10日



### 双指针解法

::: warning

没思路，直接看题解。🧓

:::



这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。

我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。

```javascript
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    // 双指针解法
    let l = 0, r = height.length - 1, m = 0;
    while (l < r) {
        m = Math.max(m, Math.min(height[l], height[r]) * (r - l));
        if (height[l] > height[r]) 
            r --;
        else 
            l ++;
    }
    return m;
};
```



第二次 2020年3月9日12:49:52

```javascript
var maxArea = function(height) {
  // 双指针
  let l = 0;
  r = height.length - 1;
  m = 0;

  while (l < r) {
    m = Math.max(Math.min(height[l], height[r]) * (r - l), m);
    if (height[l] < height[r]) {
      l++;
    } else {
      r--;
    }
  }
  return m;
};
```



第三次 2020年3月10日09:43:37

```javascript
/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
  let l = 0,
    r = height.length - 1,
    m = 0;

  while (l < r) {
    m = Math.max(m, Math.min(height[l], height[r]) * (r - l));
    if (height[l] < height[r]) {
      l++;
    } else {
      r--;
    }
  }
  return m;
};
// @lc code=end

```

