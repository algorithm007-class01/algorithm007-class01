# Week02 Summary

个人作业题解地址：[https://github.com/Rovango/algorithm007-class01/tree/master/Week_02/G20200343040337](https://github.com/Rovango/algorithm007-class01/tree/master/Week_02/G20200343040337)

欢迎review。

## 基础知识

### 栈  Stack

- 先进后出（FILO）

- 添加、删除皆为O(1)，查询O(n)

### 队列  Queue

- 先进先出（FIFO）

- 添加、删除皆为O(1)，查询O(n)

### 双端队列  Double-End Queue

- 头尾均可pop及push

- 插入、删除为O(1), 查询O(n)

### 优先队列

- 元素有权重的队列 

### 哈希表

- 键-值

- 查询、添加、删除都为O(1)

## 实战题目

### 20 - 有效的括号

- 解法：出栈入栈法
  
  - 时间复杂度：O(n)
  
  - 空间复杂度：O(n)

### 155 - 最小栈

- 解法：同步使用辅助栈
  
  - 时间复杂度：O(1)
  
  - 空间复杂度：O(n)

### 84 - 柱状图中最大的矩形

- 解法1：暴力求解
  
  - 时间复杂度：O(n^3)
  
  - 空间复杂度：O(1)

- 解法2：分治
  
  - 时间复杂度：O(nlogn)
  
  - 空间复杂度：O(n)

### 239 - 滑动窗口最大值

- 解法1：暴力求解
  
  - 时间复杂度：O(Nk)
  
  - 空间复杂度：O(N - k + 1)

- 解法2：双向队列
  
  - 时间复杂度：O(N)
  
  - 空间复杂度：O(N)

- 解法3：动态规划
  
  - 时间复杂度：O(N)
  
  - 空间复杂度：O(N)

### 42 - 接雨水

- 解法1：暴力求解
  
  - time: O(n^2)
  
  - space: O(1)

- 解法2：动态编程
  
  - time: O(n)
  
  - space: O(n)

- 解法3：栈
  
  - time: O(n)
  
  - space: O(n)

- 解法4：双指针
  
  - time: O(n)
  
  - space: O(1)

### 242 - 有效的字母异位词

- 解法1：排序后比较
  
  - time: O(nlogn)
  
  - space: O(1)

- 解法2：哈希表
  
  - time: O(n)
  
  - space: (1)

### 49 - 字母异位词分组

- 解法1： 排序数组分类
  
  - time: O(nklogk)
  
  - space: O(NK)

- 解法2：按计数分类
  
  - time: O(nk)
  
  - space: O(nk)
