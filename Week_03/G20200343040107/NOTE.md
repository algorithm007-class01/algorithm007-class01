# 学习笔记
## 1. 解决问题思想
- 分治
- 回溯
- 递归
- 以空间换时间，以时间换空间
## 2. 掌握知识点
### 2.1 树概念
- 根结点、高度、叶子结点
### 2.2 二叉树
- 二叉搜索树
- 前、中、后序遍历
- 二叉堆
    - 大顶堆、小顶堆
### 3.2 图
- 存储
    - 邻接矩阵
    - 链表法
- 遍历
    - DFS
    - BFS
- 高级算法
    - 连通图个数
    - 拓扑排序
    - 最短路径 
    - 最小生成树
## 3. 几个编程模板
- 递归
``` python 
 def recursion(level, param1, param2):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return 
    
    # process logic in current level
    process(level, data...)

    # drill down
    self.resursion(level + 1, p1)

    # reverse the current level status if needed
```
- 分治
- 回溯
- DFS 
``` python 
visited = set()
def dfs(node, visited):
    if node in visited: # terminator
        # already visited 
        return 

    visited.add(node)
    ### process current node here
    ...
    
    for next_node in node.children():
        if not next_node in visied:
            dfs(next_node, visited)
```
- BFS 
``` python 
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    
    visited = set()

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```