# 学习笔记

## 递归

### 思维要点

* 不要人肉递归（最大误区）
* 找到最近最简方法，将其拆解成可重复解决的问题（寻找重复子问题）
* 数学归纳法思维

### 模板代码

````
    private static final int MAX_LEVEL = 10;

    /**
     * 递归模板
     */
    public void recursion(int level,int params1,int params2){

        // 终结条件
        if(level > MAX_LEVEL){
            return;
        }

        // 当前层处理逻辑
        processLogic(params1,params2);

        // 下探到下一层
        recursion(level+1,params1,params2);

        // 清理当前层数据

    }

    private void processLogic(int params1, int params2) {
        // 处理逻辑
    }
````

## 树

### 二叉树

* 特点：子节点只有两个左右节点  
* 平衡二叉树： 一个空树或左右两个子树高度差绝对值不大于1

####树节点定义代码
````
public class TreeNode{
    public int val;
    public TreeNode left,right;
    
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = right;
    }
}
````

#### 用数组存储二叉树

![avatar](https://github.com/cxl123156/algorithm007-class01/raw/master/Week_03/G20200343040257/binaryTree.jpg)  

[1,2,3,4,5,null,6,null,8]  
左子节点下标：2 * parent+1  
右子节点下标：2 * parent+2  
下标为i的父节点下标为：floor((i-1)/2)  


#### 二叉树的遍历
* 前序遍历(pre-order):根-左-右
* 中序遍历(In-order): 左-根-右
* 后续遍历(Post-order):左-右-根

#### 二叉搜索树 Binary Search Tree

二叉搜索树也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）是指一颗空树或者具有下列性质的二叉树：
* 左子树上所有结点的值均小于他的根节点的值。
* 右子树上所有结点的值均大于他的根节点的值。
* 以此类推：左、右子树也分别为二叉查找树。（重复性）

二叉树的中序遍历为升序遍历

时间复杂度：
* 查询：O(logN)
* 插入：O(logN)
* 删除：O(logN)


## 堆 Heap

是一种可以迅速找到一堆数中的最大或最小值的数据结构。

* 大顶堆：根节点最大。
* 小顶堆：更节电最小。
* 常见的堆：二叉堆 斐波那契堆

堆的实现代码：https://shimo.im/docs/GpwwDq66kC9RC3PX/read  
### 堆的常见操作（大顶堆）

* find-max: O(1)
* delete-max: O(logN)
* insert(create): O(logN) or O(1)

### 二叉堆

二叉堆通过完全二叉树来实现
二叉堆（大顶）满足以下性质：
* 是一颗完全数
* 数中任意节点的值总是>=子节点的值

#### 数组存储堆元素
* 根节点（堆顶元素）：a[0]
* 索引为i的左子节点的索引是 (2*i+1)
* 索引为i的右子节点的索引是 (2*i+2)
* 索引为i的父节点的索引是floor((i-1)/2)

## 图
Graph(V,E)
  
V-vertex:点
* 度 - 入度 和 出度
* 点与点之间连通与否

E-edge:边  
* 有向和无相
* 权重（边长）或（损耗）

![avatar](https://github.com/cxl123156/algorithm007-class01/raw/master/Week_03/G20200343040257/graph.PNG)  

表示方法：  
* 临界矩阵（二维数组）

* 临接表（链表）


## 分治

将大问题拆分多个小问题并将各个小问题的结果组合成大问题的结果。

### 分治模板代码
````
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```` 


