# 第四周学习总结

## 深度优先搜索和广度优先搜索
### 深度优先搜索
* 代码模板 递归写法

```java
visited = set()
def dfs(node, visited):
# process current node here
for next_node in node.children():
    if not next_node in visited:
        dfs(next_node, visited)
```

* 另一种递归

```java
visited = set()
def dfs(node, visited):
    if node in visited: # terminator
        return;
    visited.add(node)
    for next_node in node:
        if next_node not visited:
            dfs(next_node, visited)

```

* 非递归

```java

def DFS(tree):
	if tree.root is None:
		return []

	visited, stack = [], [tree.root]

	while stack:
		node = stack.pop()
		visited.add(node)

		process(node))
		nodes = generate_related_nodes(node)
		stack.push(nodes)

		# orther proccessing work
		...
```
### 广度优先搜索

* 代码模板

```java
def BFS(graph, start, end):
	queue = []
	queue.append([start])
	visited.add(start)

	while queue:
		node = queue.pop()
		visited.add(node)

		process(node)
		nodes = generate_relate_nodes(node)
		queue.push(nodes)

		# orther proccessing work
		....
```
## 贪心算法

* 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(最有利)的选择，丛儿希望导致结果是全局最好或最优的算法。
* 贪心算法与动态规划的不同在于它对每个子问题的解决方案都作出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

### 总结

* 贪心：当下做局部最优判断
* 回溯：能够回退
* 动态规划：最优判断 + 回退

### 应用范围

* 贪心算法可以解决一些最优化问题，如 求图中最小生成树、求赫夫曼编码等。然而工程和生活中不能得到我们所要求的答案。

* 一旦一个问题可以通过贪心算法解决，那么贪心就是解决这个问题的最好办法，他也可以用作辅助算法或者直接解决一些要求不那么非常精确的问题。


### 适用范围
* 简单的说，问题能够分解成子问题来解决，子问题的最优解能够递推到最终问题的最优解，这种子问题最优解成为最优子结构。

* 贪心算法和动态规划的不同在于它对每个子问题的解决方案都作出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

## 二分查找

### 二分查找前提(三个)

* 目标函数单调性(单调增或单调减) 有序的
* 存在上下界
* 能够通过索引访问

### 代码模板

```java
left, right = 0, len(array) - 1
while (left <= right):
    mid = (left + right) / 2;
    if array[mid] == target:
        break or return result;
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid -1

```


