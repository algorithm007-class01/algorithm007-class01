## 学习笔记
* 这周的内容比较多，需要后期反过来好好消化一下，只是大体看了一遍，
本周涉及的算法题比较多，也需要好好消化一下


Linked List是特殊化的Tree  
Tree是特殊化的Graph
```java
public class TreeNode {
    public int val;
    public TreeNode left,right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
### 二叉树遍历Pre-order/In-order/Post-order
1. 前序（Pre-order）：根-左-右
2. 中序（In-order）：左-根-右
3. 后序（Post-order）：左-右-根

### 二叉搜索树Binary Search Tree
二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
1. 左子树上<font color=#FF8C00>所有结点</font>的值均小于它的根结点的值；
2. 右子树上<font color=#FF8C00>所有结点</font>的值均大于它的跟结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。（重复性）

中序遍历：升序排列

### 二叉搜索树常见操作
1. 查询
2. 插入新结点（创建）
3. 删除

Demo：https://visualgo.net/zh/bst

### 实战题目
[二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)  
[二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)  
[N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)  
[N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)  
[N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)  

### 堆 Heap
Heap：可以迅速找到一堆数中的最大或者最小值的数据结构

将根节点最大的堆叫做大顶堆或大根堆，根节点最小的堆叫做小顶堆或小根堆。常见的堆有二叉堆、斐波那契堆等。

假设是大顶堆，则常见操作（API）：

find-max: O(1)  
delete-max: O(logN)  
insert(create):O(logN) or O(1)

不同实现的比较：https://en.wikipedia.org/wiki/Heap_(data_structure)

### 二叉堆性质

通过完全二叉树来实现（注意：不是二叉搜索树）

二叉堆（大顶）它满足下列性质：

[性质一]是一棵完全树。
[性质二]树中任意节点的值总是>=其子节点的值；

### 二叉堆实现细节

1. 二叉堆一般通过“数组”来实现
2. 假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：
    1. 索引为i的左孩子的索引是(2*i+1);
    2. 索引为i的右孩子的索引是(2*i+2);
    3. 索引为i的父节点的索引是floor((i-1)/2);
    
### 二叉堆

0. 根节点（顶堆元素）是：a[0]
1. 索引为i的左孩子的索引是(2*i+1);
2. 索引为i的右孩子的索引是(2*i+2);
3. 索引为i的父节点的索引是floor((i-1)/2);

### Insert插入操作
1. 新元素一律先插入到堆的尾部
2. 依次向上调整整个堆的结构（一直到根即可）

HeapifyUp

### Delete Max 删除堆顶操作
1. 将堆尾元素替换到顶部（即堆顶被替代删除掉）
2. 依次从根部向下调整整个堆的结构（一直到堆尾即可）

HeapifyDown

**注意：二叉堆是堆（优先队列priority_queue）的一种常见且简单的实现；但是并不是最优的实现。**

https://en.wikipedia.org/wiki/Heap_(data_structure)

堆的实现代码：https://shimo.im/docs/GpwwDq66kC9RC3PX/read

### 实战题目
[最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)  
[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)  
[前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)  

### 图的属性
* Graph(V, E)
* V - vertex:点
1. 度-入度和出度
2. 点与点之间：连通与否
* E-edge：边
1. 有向和无向（单行线）
2. 权重（边长）

### 树的面试题解法一般都是<font color=#FF8C00>递归</font>
<font color=#FF8C00>1. 节点的定义</font>  
<font color=#FF8C00>2. 重复性（自相似性）</font>

### 递归 Recursion

递归-循环

通过函数体来进行的循环

### 递归代码模版
1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层

[递归代码模板](https://shimo.im/docs/DjqqGCT3xqDYwPyY/read)

### 思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

* BST-->中序遍历是递增的

### 分治、回溯
#### 递归状态数
* [分治代码模版](https://shimo.im/docs/3xvghYh3JJPKwdvt/read)  
