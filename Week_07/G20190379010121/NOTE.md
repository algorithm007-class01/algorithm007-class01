## Trie树
- 单词查找树或者键值树,典型应用是统计和排序大量字符串,,被用于搜索引擎的文本词频统计
- 优点:最大限度减少无谓的字符串比较,查询效率比哈希高

![image](https://note.youdao.com/yws/api/personal/file/WEBcc6cad9bd7420c624c20cd5e51aff0a2?method=download&shareKey=fb01d5110d5714799aa9774179f8aed3)

- 1. 结点本身不存完整单词;
- 2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
- 3. 每个结点的所有子结点路径代表的字符都不相同。

### tire树模版
```python
class Trie(object):
  
	def __init__(self): 
		self.root = {} 
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True
```

### 例题
- 二叉树的层次遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
- 实现 Trie https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/
- https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
- https://leetcode-cn.com/problems/word-search-ii/
  - words遍历-board 去找 o(N*m*n*4^k)
  - 所有words放入trie树,遍历board dfs o(N*m*n*logn)
  - 4连通 或者8连通记得用方向数组代码会更简洁方便
- https://leetcode-cn.com/problems/word-search-i/

## 并查集

- 知道这个数据结构就会用,没有很大的发挥空间
- 用来解决组团配对的问题

### 基本操作
- makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
- unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
 的集合不相交，如果相交则不合并。
- find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

### 模版
```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```
### 实战题目
- 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
- https://leetcode-cn.com/problems/friend-circles
  - 与岛屿数量类似转换成这个问题 dfs/bfs 查看相邻连接的1有多少
  - 并查集
- https://leetcode-cn.com/problems/number-of-islands/
- https://leetcode-cn.com/problems/surrounded-regions/

## 高级搜索

### 回顾初级搜索
- 1. 朴素搜索
- 2. 优化方式:不重复(fibonacci)、剪枝(生成括号问题)
- 3. 搜索方向:
DFS: depth first search 深度优先搜索 BFS: breadth first search 广度优先搜索
- 优化:双向搜索、启发式搜索

### 高级搜索

#### 零钱置换问题

- 一想到搜索问题,就先联想到对应的搜索状态树
![image](https://note.youdao.com/yws/api/personal/file/WEBf56a824d566fbe49df3ee033b762eb98?method=download&shareKey=f7d4bc95e6313b97b2e1a1f1dc1574fe)

#### DFS 代码模板

- 递归
```
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
- 非递归
```
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```
#### BFS 代码模板
```
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...

```
#### 剪枝相关阅读
https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/
https://en.wikipedia.org/wiki/Game_complexity

#### 回溯
采用了一种试错的思想,尝试分步解决问题 递归+分治


### 高级搜索实战
- https://leetcode-cn.com/problems/climbing-stairs/ 递归去重实现一下
- https://leetcode-cn.com/problems/generate-parentheses/ 感受剪枝的思想,再看看动态规划怎么解决
- https://leetcode-cn.com/problems/n-queens 本质也是剪枝的思想
```
def solveNQueens(self, n):
    if n < 1: return []
    self.result = []
    self.cols = set(); self.pie = set(); self.na = set()
    self.DFS(n, 0, [])
    return self._generate_result(n)
def DFS(self, n, row, cur_state):
    # recursion terminator
    if row >= n:
        self.result.append(cur_state)
        return
    for col in range(n):
        if col in self.cols or row + col in self.pie or row - col in self.na:
# go die!
continue
        # update the flags
       self.cols.add(col)
       self.pie.add(row + col)
       self.na.add(row - col)
       self.DFS(n, row + 1, cur_state + [col])
       self.cols.remove(col)
       self.pie.remove(row + col)
       self.na.remove(row - col)
```
- https://leetcode-cn.com/problems/valid-sudoku/description/ 写循环 判重
- https://leetcode-cn.com/problems/sudoku-solver/#/description 搜索+剪枝 和8皇后差不多  
  - 判断行列 块是否都满足条件
  - 3*3 怎么用代码实现
  - 看视频 对着例题讲解去理解
  - A* search 启发式搜索

## 双向bfs

- 总结模板

### 高频题目

- https://leetcode-cn.com/problems/word-ladder/
- https://leetcode-cn.com/problems/minimum-genetic-mutation/

## 启发式搜索

- 基于bfs
```python
def AstarSearch(graph, start, end):


	pq = collections.priority_queue() # 优先级 —> 估价函数 关在在于估价函数怎么找
	pq.append([start]) 
	visited.add(start)


	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)


		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisit
```

### 参考

- 相似度测量方法 https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/
- 二进制矩阵中的最短路径的 A* 解法 https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python
- 8 puzzles 解法比较 https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/


### 习题
- https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/ 
  - dp
  - bfs
- https://leetcode-cn.com/problems/sliding-puzzle/
  - https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/
  - dfs
  - bfs
- https://leetcode-cn.com/problems/sudoku-solver/

## 平衡树avl 

- 树和链表没有本质区别
- 性能关键
  - 保证二维纬度
  - 左右子树结点平衡
  - 四种旋转操作

## 红黑树(近似平衡二叉树)

## avl vs 红黑树
- avl 查找优于红黑树,因为它严格平衡
- 红黑树在插入、删除优于avl,因为它相对平衡,旋转操作比红黑树少一些
- 附加信息上红黑树优于avl,avl每个节点要存更多的信息 平衡因子和高度,红黑树只要一个bit来存是红还是黑
- 红黑树多用于语言库的实现,avl多用于需要更快检索性能的数据库