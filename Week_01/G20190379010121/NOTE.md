# 数组
## 时间复杂度

- 查询 o(1)
- 插入 o(n)
- 删除 o(n)


# 链表
## 时间复杂度

- 查询 o(n)
- 插入 o(1)
- 删除 o(1)

## 应用
lru 缓存

# 跳表
- 时间负载度 o(log n)
- 空间复杂度 o(n)

## redis 

https://www.zhihu.com/question/20202931

# 习题

## 0移动
- https://leetcode-cn.com/problems/move-zeroes/
- 双指针,碰到非零数就和前面的0交换
- 双指针是一种常用的办法

## 装水最多的容器
- https://leetcode-cn.com/problems/container-with-most-water/
- 左右边界同时向中间收敛,两个棒子分别在两端,逐渐向中间移动,每次移动比较低的那根棒子,移动的时候,移动以后的棒子如果比当前的棒子低,那面积肯定不如原来大,直接忽略,只有碰到更高的棒子,面积才有可能更大
- 左右夹逼的办法是一种常用的策略

## 爬楼梯
- https://leetcode.com/problems/climbing-stairs/
- 蒙蔽的时候
- 先尝试暴力解法
- 不行的时候,例举一些简单的情况
- 然后泛化自己例举的简单情况,碰到这种类似递归的题,去找重复子问题-找重复性,因为计算机只能做这种重复的操作
- 抽出一个片段去思考,假如要上第三级台阶,只能从第二级台阶跨一级上来,或者从第一级台阶跨两级台阶上来,所以f(n) = f(n-1) + f(n-2);



## https://leetcode-cn.com/problems/3sum/ (高频老题）

- 简化版 两数之和 leetcode 1
- 排序+双指针,左右判断条件不断夹逼

## 链表相关
- 熟练移动指针 


https://leetcode.com/problems/reverse-linked-list/
https://leetcode.com/problems/swap-nodes-in-pairs
https://leetcode.com/problems/linked-list-cycle
https://leetcode.com/problems/linked-list-cycle-ii
https://leetcode.com/problems/reverse-nodes-in-k-group/

## 作业
- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
- https://leetcode-cn.com/problems/rotate-array/
- https://leetcode-cn.com/problems/merge-two-sorted-lists/
- https://leetcode-cn.com/problems/merge-sorted-array/
- https://leetcode-cn.com/problems/two-sum/
- https://leetcode-cn.com/problems/move-zeroes/
- https://leetcode-cn.com/problems/plus-one/
