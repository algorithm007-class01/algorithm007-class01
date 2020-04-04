# 深度/广度优先
## 深度优先搜索

### 递归
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

### 非递归
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

## 广度优先搜索
### 非递归

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

## 相关习题

- https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
  - 深度/广度都可以做
- https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
  - 深度/广度都可以做
- https://leetcode-cn.com/problems/generate-parentheses/#/description
  - 尝试用广搜去做
- https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
- https://leetcode-cn.com/problems/word-ladder/description/
  - 高频
- https://leetcode-cn.com/problems/word-ladder-ii/description/
- https://leetcode-cn.com/problems/number-of-islands/
  - 深搜
- https://leetcode-cn.com/problems/minesweeper/description/

# 贪心算法

- 贪心:每一步都选择当下最好或者最优的选择,从而希望全局结果最好或者最优
- 回溯:可以回退
- 动态规划:最优选择+回退 https://zh.wikipedia.org/wiki/动态规划

## 贪心条件
- 能证明贪心可以得到全局最优解
- 贪心切入的角度比较巧妙,常规是从前往后贪心、还有可能从后往前或者从中间开始贪心,例如下面的跳跃游戏题目

## 零钱兑换讲解
https://leetcode-cn.com/problems/coin-change/
- 要证明贪心可以得到最有结果
- 此题中由于备选硬币存在整除关系,所以用大面额硬币可以替代小面额硬币
- 每次选择面额最大的硬币满足要求

## 相关习题

- https://leetcode-cn.com/problems/lemonade-change/description/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
  - 只要前一天价格小于后一天,就买出然后买进获取利润
- https://leetcode-cn.com/problems/assign-cookies/description/
  - 用小饼干先满足小需求的孩子
- https://leetcode-cn.com/problems/walking-robot-simulation/description/
- https://leetcode-cn.com/problems/jump-game/ 
  - 暴力搜索
  - 从后往前贪心
- https://leetcode-cn.com/problems/jump-game-ii/

# 二分查找

## 前提条件
- 目标函数单调性
- 存在上下界
- 能通过索引查找

## 模版
```
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

## sqrt 实现
https://www.beyond3d.com/content/articles/8/


使用二分查找能解题之前要先证明是可以的

## 相关题目
- https://leetcode-cn.com/problems/sqrtx/
  - 二分查找
  - 牛顿迭代法
- https://leetcode-cn.com/problems/valid-perfect-square/
- https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
  - 在局部存在单调性
- https://leetcode-cn.com/problems/search-a-2d-matrix/
- https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
- 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方




