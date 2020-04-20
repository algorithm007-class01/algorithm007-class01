https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/



## 1 题目内容

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

```
示例 1:
给定数组 nums = [1,1,2], 
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

```



## 2 我的思考与实现

因为受到课上“移动零”题目启发，所以这道题很容易可以想到解法。

也是双指针，一个指针指向需要填写的位置的下标，另一个指针在前面推进，排除重复的元素。一旦发现了有不重复的了，就把数据填到前面指针所指的位置。然后两根指针继续往前推进。 这也有"快慢指针"这么个说法。

### 方法1

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null|| nums.length == 0) return 0;
        int j = 0;  //不重复元素的下标
        
        // 快指针i，遍历整个数组，寻找不重复元素
        for (int i = 0; i < nums.length - 1; i++) {
            // i与i+1 元素不相等，说明i的元素应该被填入到j位置
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        // 因为i没有到最后一个位置，因为要顾及到i+1不越界
        // 但数组最后一个元素不管是否有重复元素，都一定是要填入到位置j的
        // 因为就算有重复元素，上面的循环，它也没能放到j位置，这里要补放。
        nums[j] = nums[nums.length - 1];
        
        //因为j是不重复数组的最后一个元素的下标，所有，数组长度要+1 
        return j + 1;
    }
}
```

#### 复杂度

- 时间复杂度: $O((m+n)log(m+n))$ ,

> 因为基于比较的排序算法时间复杂度是$O(nlogn)$

- 空间复杂度: $O(1)$





## 3 官方解答

https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/

### 方法：双指针法

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
```

#### 复杂度分析

- 时间复杂度：O(n)，假设数组的长度是 n，那么 i和 j分别最多遍历 n步。
- 空间复杂度：O(1)

#### 我的点评

> 官方的解法，也是快慢指针。但是判断是否重复元素的元素做法，只直接拿两个指针所指的值来比较。简单明了.
>
> 相比之下，我单纯使用快指针的 i 和 i+1 的值做比较来判断重复元素的方式，就显得很笨拙了！

