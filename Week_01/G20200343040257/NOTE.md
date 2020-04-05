###学习笔记
数组:
插入O(n)
查找O(1)
删除O(n)

链表:  
插入O(1)
查找O(n)
删除O(1)


跳表：  
1.  对链表的元素查询进行优化；  
2.  只能用于元素是有序的情况下；  
3.  对标平衡树和二分查找 插入 删除 搜索 操作时间复杂度均为O(log n)；  
4.  应用于 redis LevelDB；  

数组题目的解法思路：  
1.  双指针夹逼  
    LeetCode题目：  
    [11.盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/ "11.盛最多水的容器")  
2.  快慢指针  
    LeetCode题目:  
    [283.移动零](https://leetcode-cn.com/problems/move-zeroes/ "283.移动零")  
    [26.删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ "26.删除排序数组中的重复项")
    

算法优化的方法：
1.  升维度 (一维升二维) 例如跳表
2.  空间换时间 例如解题中通过Map开辟新的内存空间缓存计算结果的方法来优化时间复杂度

存在的问题：   
链表操作的代码写的不是很熟练，没有掌握到一个比较好的方法，还需多写代码练习。