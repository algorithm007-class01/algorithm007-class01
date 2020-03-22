# Week01 Summary

个人作业题解地址：[https://github.com/Rovango/algorithm007-class01/tree/master/Week_01/G20200343040337](https://github.com/Rovango/algorithm007-class01/tree/master/Week_01/G20200343040337)

欢迎review。

## 基础知识

第一周知识内容为数组、链表和跳表。

### 数组

- 特性：内存地址连续;

- java的实现：ArrayList;

- 常见操作时间复杂度：
  
  - prepend: O(n)
  
  - append: O(1)
  
  - lookup: O(1)
  
  - insert: O(n)
  
  - delete: O(n)



### 链表

- 分类：单链表、双向链表、循环链表;

- Java的实现：LinkedList（双向链表）;

- 常见操作时间复杂度：
  
  - prepend: O(1)
  
  - append: O(1)
  
  - lookup: O(n)
  
  - insert: O(1)
  
  - delete: O(1)

- 应用：LRU 缓存机制



### 跳表

- 跳表是对有序链表的优化, 所以跳表中的元素是有序的;

- 跳表对标的是平衡树（AVL Tree）和二分查找;

- 跳表的目的是加快有序链表的随机查找（升维添加多级索引）;

- 常见操作的时间复杂度：
  
  - lookup：O(logn)
  
  - insert：O(logn)
  
  - delete: O(logn)

- 空间复杂度对比原始的链表仍为：O(n)

- 应用：redis



## 实战题目

#### 283 - 移动零

地址：[https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/](https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/)

解法：快慢指针遍历，快指针寻找非零元素，慢指针保证和快指针之间的都是零。时间复杂度O(n) , 空间复杂度O(1);

#### 

#### 11 - 盛最多水的容器

地址：[https://leetcode-cn.com/problems/container-with-most-water/](https://leetcode-cn.com/problems/container-with-most-water/)

解法一：暴力枚举，此方法应注意双层循环枚举数组时外层循环的条件为[0, length - 1)， 内层为[1, length)。 时间复杂度O(n^2), 空间复杂度为O(1);

解法二：双指针，双双向内寻找更长的。时间复杂度O(n), 空间复杂度O(1);



#### 12 - 爬楼梯

本质：求斐波那契数列第N项

地址：[https://leetcode-cn.com/problems/climbing-stairs/](https://leetcode-cn.com/problems/climbing-stairs/)

解法一：递归求第N项。时间复杂度0(2^n), 空间复杂度O(n)

解法二：递归+缓存。时间复杂度O(n), 空间复杂度O(n)

解法三：动态规划。时间复杂度O(n), 空间复杂度O(n)

解法四：直接循环求第N项。时间复杂度O(n), 空间复杂度O(1)

解法五：Binets方法。时间复杂度O(logN), 空间复杂度O(1);

解法六：通项公式法。时间复杂度O(logN), 空间复杂度O(1);

通项公式如下：

$$
1/√5[((1 + √5) / 2) ^ n - ((1 - √5) / 2) ^ n]
$$



#### 15  - 三数之和

地址：[https://leetcode-cn.com/problems/3sum](https://leetcode-cn.com/problems/3sum)

解法：排序+双指针。时间复杂度：O(n^2)， 空间复杂度： O(1)



#### 26  - 删除排序数组中的重复项

地址：[https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

解法：双指针法。时间复杂度：O(n)， 空间复杂度：O(1);



#### 186 - 旋转数组

地址：[https://leetcode-cn.com/problems/rotate-array/](https://leetcode-cn.com/problems/rotate-array/)

解法一：暴力。时间复杂度O(n*k), 空间复杂度O(1);

解法二：环状替换。时间复杂度O(n), 空间复杂度O(1);

解法三：反转。时间复杂度O(n), 空间复杂度O(1);



#### 21 - 合并两个有序的链表

地址：[https://leetcode-cn.com/problems/merge-two-sorted-lists](https://leetcode-cn.com/problems/merge-two-sorted-lists)

解法一：递归。 时间复杂度O(n+m), 空间复杂度O(n+m);

解法二：迭代。时间复杂度O(n+m), 空间复杂度O(1);



#### 88 - 合并两个有序数组

地址： [https://leetcode-cn.com/problems/merge-sorted-array/](https://leetcode-cn.com/problems/merge-sorted-array/)

解法一：合并后排序。时间复杂度O((n+m)*log(n+m)), 空间复杂度O(1)

解法二：两个下标从前往后遍历两个数组。时间复杂度O(n+m), 空间复杂度O(1);

解法二：两个下标从后往前遍历两个数组。时间复杂度O(n+m), 空间复杂度O(1);



#### 1 - 两数之和

地址：[https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/)

解法一：暴力枚举。时间复杂度O(n^2), 空间复杂度O(1);

解法二：两遍哈希表。时间复杂度O(n^2), 空间复杂度O(n);

解法三：一遍哈希表。时间复杂度O(n^2), 空间复杂度O(n)



#### 66 - 加一

地址：[https://leetcode-cn.com/problems/plus-one/](https://leetcode-cn.com/problems/plus-one/)

解法：从后往前均加一，直到没有进位。 时间复杂度O(1),空间复杂度O(1);


