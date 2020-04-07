一、题目
1. DFS、BFS
    1. https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
    2. https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
    3. https://leetcode-cn.com/problems/generate-parentheses/#/description
    4. https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
    5. https://leetcode-cn.com/problems/word-ladder/description/
    6. https://leetcode-cn.com/problems/word-ladder-ii/description/
    7. https://leetcode-cn.com/problems/number-of-islands/
    8. https://leetcode-cn.com/problems/minesweeper/description/
2. 二分查找
    1. https://leetcode-cn.com/problems/sqrtx/
    2. https://leetcode-cn.com/problems/valid-perfect-square/
    3. https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    4. https://leetcode-cn.com/problems/search-a-2d-matrix/
    5. https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    6. 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中
二、知识点
1. DFS和BFS就是像for和if一样，是一种约定成俗，固定的写法
2. 深度优先搜索
    1. 递归版代码模版
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

    1. 非递归版代码模版（借助栈实现）
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


3. 广度优先搜索：
    1. 代码模版（借助队列实现）：
def BFS(graph, start, end):

    visited = set()

queue = [] 

queue.append([start]) 

while queue:
    nodes = []
    # 遍历当前层所有节点
    while queue: 

        node = queue.pop() 

        visited.add(node)

        process(node) 
        # 将当前层所有节点的子节点，加入nodes中
        nodes.add(generate_related_nodes(node))
    # 将nodes赋值给queue作为下一层遍历的数据
    queue.push(nodes)



# other processing work 
...

4. 二分查找
    1. 前提：
        1. 目标函数单调性（单调递增或递减，即必须有序）
        2. 存在上下界
        3. 能够通过索引访问
    2. 代码模版
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
