# 学习笔记
## 1. 知识点
### 1.1 遍历搜索
- 每个节点都要访问一次，且仅访问一次
- 方法
    - 深度优先
    - 广度优先
    - 优先级优先
-- 代码模板
``` python
    # DFS
    visited = set()
    # 二叉
    def dfs(node):
        if node in visited:
            return
        
        visited.add(node)

        # process current node

        dfs(node.left)
        dfs(node.right)

    # 多叉
    def dfs(node):
        visited.add(node)

        # process current node 

        for next_ndoe in node.children():
            if not next_node in visited:
                dfs(next_node, visited)

    # BFS
    visited = []
    def BFS(graph, start, end):
        queue = []
        queue.append([start])
        visited.add(start)

        while queue:
            node = queue.pop()
            visited.add(node)

            process(node)
            node = generate_related_nodes(node)
            queue.push(nodes)
        
        # other processing work

    

```
### 1.2 贪心算法
- 在每一步选择中都采取在当前状态下最好或最优的选择，从而希望得到的结果是全局最好或最优的算法
- 工业中很少用，辅助算法
### 1.3 二分查找
- 适用于
    - 单调
    - 有界
    - 索引
- 代码模板
``` python 
    left, right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) / 2
        if array[mid] == target:
            break
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
```
## 2. 个人心得
- 学霸不会告诉你，学习最重要的方法是多练习