[题目地址](https://leetcode-cn.com/problems/3sum/submissions/)



- :cry: 第一次刷题 2020年3月9日 
- 😒 第二次刷题 2020年3月10日
- :joy: 第三次刷题 2020年3月11日 整体思路有了，不过写代码太粗心，代码错误太多了



### 利用双指针

:::warning

正常人都想不到的解法，直接看题解 👻

:::



```javascript
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let result = [];

    if (nums.length < 3) 
        return result;

    nums.sort((x, y) => x - y);
    for (let i = 0; i < nums.length - 1; i ++) {
        if (nums[i] > 0) 
            break;

        if (i > 0 && nums[i] == nums[i - 1])
            continue;

        let l = i + 1, r = nums.length - 1;

        while(l < r) {
            let sum = nums[l] + nums[r] + nums[i];

            if (sum == 0) {
                result.push([nums[i], nums[l], nums[r]]);
                
                while(l < r && nums[l] == nums[l + 1])
                    l ++;
                while(l < r && nums[r] == nums[r - 1])
                    r --;
                l ++;
                r --;
            } else if (sum > 0) 
                r --;
            else if (sum < 0) 
                l ++;
        }

    }

    return result;

};
```



### 错误集锦

- for 循环终止条件写成 `nums.length` 正确应是 `nums.length - 1` 粗心导致 :grimacing:

  ![image-20200311093442183](../.vuepress/public/image-20200311093442183.png)

- 找到满足条件的结果，添加到结果数组时`没有写数组` 粗心导致 :grimacing:

  ![code](../.vuepress/public/err_01.png)