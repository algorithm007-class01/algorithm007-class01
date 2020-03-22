# 第一课

> 数据结构与算法总结 & 刷题方法

## 如何精通一个领域
* Chunk it up 切碎知识点
* Deliberate Practicing 刻意练习
* Feedback 反馈

## 数据结构
* 一维
    * 基础：数组 array (string), 链表 linked list
    * 高级：栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc
* 二维：
    * 基础：树 tree，图 graph
    * 高级：二叉搜索树 binary search tree (red-black，AVL), 堆 heap, 并查集 disjoint set, 字典树 Trie, etc
* 特殊：
    * 位运算 Bitwise, 布隆过滤器 BloomFilter
    * LRU Cache

<img width="1759" alt="数据结构" src="https://user-images.githubusercontent.com/20024532/76697018-bbe61100-66cc-11ea-8516-f632807743c1.png">


## 算法
* If-else, switch -> branch
* for, while loop -> Iteration
* 递归 Recursion (Divide & Conquer, Backtrace)
* 搜索 Search: 深度优先搜索 Depth first search, 广度优先搜索 Breadth first search, A*, etc
* 动态规划 Dynamic Programming
* 二分查找 Binary Search
* 贪心 Greedy
* 数学 Math, 几何 Geometry

<img width="1339" alt="算法" src="https://user-images.githubusercontent.com/20024532/76697021-c56f7900-66cc-11ea-9261-3d44ba4fcc1e.png">

## 反馈
* 及时反馈
* 主动型反馈
    * 高手代码（Github, LeetCode, etc.）
* 被动式反馈
    * code review

## 五步刷题法
* 刷题第一遍
    * 5 分钟：读题 + 思考
    * 直接看解法：注意！多解法，比较解法优劣
    * 背诵、默写好的解法
* 刷题第二遍
    * 马上自己写 -> LeetCode 提交
    * 多种解法比较、体会 -> 优化
* 刷题第三遍
    * 过了一天后，再重复做题
    * 不同解法的熟练程度 -> 专项练习
* 刷题第四遍
    * 过了一周：反复回来练习相同题目
* 刷题第五遍
    * 面试前一周恢复性训练

# 第二课

> 训练准备和复杂度分析

## 电脑设置

* Google 搜索入口
* Mac: iTerm2 + zsh (oh my zsh)
Windows: Microsoft new terminal: (https://github.com/microsoft/terminal)
* VSCode; Java: IntelliJ; Python: Pycharm;
* LeetCode plugin (VSCode & IntelliJ)
* https://vscodethemes.com

## Code Style
Java、Python…
* Google code style
* Facebook
* Airbnb

## 指法操作
> 想成为大牛，首先要学着他们的样子去做事，装也要装的像
* home, end （行头、行尾）
* Word 单词、选单词、选整行
* IDE 的自动补全
* Top tips for <IDE-name>

## 自顶向下的编程方式

> 用代码块或者空的 method 去绘制思路轮廓，而后再实现具体内容，可降低思维复杂度，也让代码结构清晰整洁

## 时间复杂度 & 空间复杂度

* O(1): Constant Complexity 常数复杂度
* O(log n): Logarithmic Complexity 对数复杂度
```
for (int i = 1; i < n; i = i * 2) { }
```
* O(n): Linear Complexity 线性时间复杂度
```
for (int i = 1; i <= n; i++) { }
```
* O(n^2): N square Complexity 平方
```
for (int i = 1; i <= n; I = i++) {
    for (int j = 1; j <= n; j++) {
    }
}
```
* O(n^3): N square Complexity 立方
* O(2^n): Exponential Growth 指数
```
int fib(int n) {
    If (n <= 2) return n;
    Return fib(n - 1) + fib(n - 2);
}
```
* O(n!): Factorial 阶乘

# 第三课

> 数组、链表、跳表

## Array（数组）
Array 增加、删除元素，需要挪动平均一半数组长度的元素，所以，对于 Array 来说，**增删慢**。但 Array 可以随意访问到任意元素，**查询速度很快**。

**Array 时间复杂度：**
* prepend O(1)
* append O(1)
* lookup O(1)
* insert O(n)
* delete O(n)

## Linked List（链表）
Linked List 增加、删除元素，因为只需要改变 next 指针，增删不需要大量挪动链表中的元素，所以，**增删很快**，但想找到一个元素必须从头结点或者尾结点一个一个的都查找一遍才能找到目标元素，**查询速度就慢了**。

**Double Linked List 时间复杂度：**
* prepend O(1)
* append O(1)
* lookup O(n)
* insert O(1)
* delete O(1)

## Skip List（跳表）
为了解决链表查询速度慢的缺陷。添加一级索引、二级索引、多级索引。**跳表是在链表的基础上根据升维思想和空间换时间的手法。**



现实中因为链表元素的增删频繁变化，索引要随着每次的增删进行维护，所以，现实中的索引可能是不规整的，有的跳 2 步，有的可能跳 3 步。

* 跳表时间复杂度 O(logn)
* 跳表空间复杂度为 O(n)

### 工程中的应用：
* LRU Cache - Linked list
    * https://www.jianshu.com/p/b1ab4a170c3c
* Redis - Skip List
    * https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html

# 第四课

> 栈、队列、双端队列、优先队列

## Stack（栈）
* First in - Last out（先进后出）
* Last in - First out （后进先出）
* 添加、删除皆为 O(1)

## Queue（队列）
* First in - First out（先进先出）
* Last in - Last out（后进后出）
* 添加、删除皆为 O(1)

## Deque: Double-End Queue（双端队列）
* 两端可以进出的 Queue
* 添加、删除皆为 O(1) 操作

## Priority Queue（优先队列）
* 插入操作：O(1)
* 取出操作：O(logN) - 按照元素的优先级取出
* 底层具体实现的数据结构较为多样和复杂：heap（堆）、bst（二叉搜索树）、treap（树堆）
* java 中的 PriorityQueue https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html

* java:
    * Stack: http://developer.classpath.org/doc/java/util/Stack-source.html
    * Queue: https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
    * Priority Queue: http://developer.classpath.org/doc/java/util/PriorityQueue-source.html
* Python:
    * heapq: https://docs.python.org/2/library/heapq.html
    * 高性能的 container 库: https://docs.python.org/2/library/collections.html

## 如何查询接口信息？
* google Java + Deque or Python + Deque 查看官方文档或者源码实现

![E63E76E3-7538-4079-B0D8-BAFD6EB549F2](https://user-images.githubusercontent.com/20024532/76697011-a8d34100-66cc-11ea-99b8-4085a4f04be8.png)

