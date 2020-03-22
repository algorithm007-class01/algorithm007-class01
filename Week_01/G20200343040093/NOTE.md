## 学习笔记
### 看题解套路
* 理清思路(有几种解法)
* 这么写的原因(原理或数学公式)
* 背下写法
* 反复练习
* feedback，寻求反馈并转化为自己的东西

### 解法套路
* 暴力求解
* 简单解法(基本解法)
* 套路解法 泛化找最近重复子问题，理清套路后隐藏的数学公式，或题目要考察的知识点

### 解题总结
* 暴力解法，有些题目的暴力解法也能锻炼代码能力，值得练习
* 理清解题逻辑
* 注意边界条件，循环中结束条件、大小比较、变量赋值

### 数组、链表、跳表
* 原理和实现，三者的时间复杂度和空间复杂度
* *ArrayList*  
  [Java源码分析](http://developer.classpath.org/doc/java/util/ArrayList-source.html)

* *Linked List*   
每个元素用class来定义，一般来说是node

  [Linked List的标准实现代码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)  
  [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)  
  [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)  
  LRU Cache - Linked list：  
  [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
  Redis - Skip List：  
  [跳跃表](https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)
  [为啥 redis 使用跳表(skiplist)而不是使用 red-black？](https://www.zhihu.com/question/20202931)

* 跳表的特点
  *注意：只能用于元素有序的情况*  
  跳表（skip list）对标的是平衡树和二分查找

  一维加速就是升维，升级为二维  
  升维思想+空间换时间

