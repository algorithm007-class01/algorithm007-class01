## 学习总结

### 二叉树

- 前序：根 - 左 - 右

- 中序：左 - 根 - 右

- 后序：左 - 右 - 根

### 二叉搜索树

左子树上所有节点值均小于根节点的值

右子树上所有节点值均大于根节点的值

空树也是二叉搜索树

查询、插入、删除：O(logn)

### 堆

- 可以迅速找到一堆数中的最大或者最小值
- 根节点最大的堆叫大顶堆或大根堆
- 根节点最小的堆交小顶堆或小根堆
- 常见堆有：二叉堆、斐波那契堆

#### 常见操作

- 找最大值：O(1)
- 删除最大值：O(logn)
- 插入（创建）：O(logn) or O(1)

### 二叉堆

二叉堆是对（优先队列 priority_queue)的一种常见且简单的实现，但并不是最优的实现。

通过完全二叉树（不是二叉搜索树）来实现，是一棵完全树（最后一层叶子可以不满），树中任意节点的值总是>=其子节点的值。

#### 实际的存储结构为数组

根节点（顶堆元素）是：`a[0]`

索引为 i 的左孩子索引是： `2 * i + 1`

索引为 i 的右孩子索引是： `2 * i + 2`

索引为 i 的父节点的索引时：`floor((i - 1) / 2)`

#### 插入操作 O(logn)

> 先直接插入到堆的尾部
> 然后不停和父节点比较，如果大于父节点，那么就交换，直至根节点
> 从下向上调整的函数称为：heapifyUp

#### 删除堆顶的操作 O(logn)

> 直接删除，然后用堆的最后一个元素替换堆顶
> 然后不停地和较大的儿子节点交换，直至最后一层
> 向下调整的操作称为：heapifyDown

### 图

#### 定义

Grath(V, E)

#### V - vertex: 点

度：入度和出度（即由多少条路可以到达和出去）

点与点之间：连通与否

#### E - Edge：边

有向（单行线）、无向（双行线）

权重，即边长

#### 分类

- 无向无权图

- 无向有权图

- 有向无权图

- 有向有权图

#### 表示方法

- 邻接矩阵

- 邻接表

#### 常见算法

- BFS
- DFS

写递归的时候需要有 visited 的 set (防止死循环)

#### 高级算法

- [连通图个数](https://leetcode-cn.com/problems/number-of-islands/)

- [拓扑排序（Topological Sorting）](https://zhuanlan.zhihu.com/p/34871092)

- [最短路径（Shortest Path）](https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158)

- [最小生成树（Minimum Spanning Tree）](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)

### 递归

代码模板

```JavaScript
function recursion(level, param1, param2, ...) {
  // 递归终止条件
  if (level > MAX_LEVEL) {
    process_result;
    return;
  }
  // 当前层的处理逻辑
  process(level, data...);
  // 下探到下一层
  recursion(level + 1, p1, ...);
  // 如果需要的，此处清理当前层的状态 ，通常在有一些全局变量或其他特殊情况时清理
}
```

#### 思维要点

- 禁止人肉递归

- 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）

- 数学归纳法思维

### 分治、回溯

分治和回溯本质上就是特殊的递归

#### 分治代码模板

```JavaScript
function divide_conquer(problem, param1, param2, ...) {
  // 递归结束条件
  if(!problem) {
    print_result;
    return;
  }
  // 准备数据
  let data = prepare_data(problem);
  let subproblems = split_problem(problem, data);
  // 分治解决所有子问题
  let subresult1 = divide_conquer(subproblems[0], p1, ...);
  let subresult2 = divide_conquer(subproblems[1], p1, ...);
  let subresult3 = divide_conquer(subproblems[2], p1, ...);
  // 处理、生成最终的结果
  result = process_result(subresult1, subresult2, subresult3);
  // 如果需要的，此处清理当前层的状态 ，通常在有一些全局变量或其他特殊情况时清理
}
```
