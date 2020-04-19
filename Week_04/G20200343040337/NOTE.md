# Week04 Summary

## 树或图的搜索

目标是将所有的节点都遍历一遍（仅一遍）

- 深度优先搜索

```javascript
// 二叉树
let visited= new Set();
function dfs(node) {
    if (visited.has(node)) {
        // 该节点已经被访问过
        return
    }

    // 记录该节点
    visited.add(node);

    // 处理当前节点

    // 下探到下一层
    dfs(node.left);
    dfs(node.right);        
}

// N叉树
let visited = new Set();
function dfs(node, visited) {
    // 加入到已已访问的节点中
    visited.add(node);

    // 此处处理当前节点

    // 下探到下一层
    for (let next_node of node.children) {
        if (!visited.has(next_node)) {
            dfs(next_node, visited);
        }
    }           
}
```

- 广度优先搜索

```javascript
function BFS(graph, start, end) {
    let visited = new Set();
    // 定义一个双端队列
    let queue = [];
    // 将当前节点接入队列
    queue.push([start]);
    // 将当前节点标记为已读
    visited.add(start);

    while (queue.length) {
        let node = queue.pop();
        visited.add(node);
        // 处理当前节点
        process(node);
        // 生成下一次需要遍历的节点(周围的节点)
        let nodes = genereate_related_nodes(node);
        queue.push(nodes);
    }

    // 其他处理逻辑
}
```

- 优先级优先搜索
  
  也称为启发式搜索，依赖于估价函数。可应用于各种推荐算法。

# 贪心算法（Greedy）

为了达到全局最好或最优，采用在当下每一步选择中都采取最好或最优（即最有利）的选择。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

- 贪心：当下做出局部最优判断；

- 回溯：能够回退；

- 动态规划：最优判断 + 回退；

# 二分查找

能够进行二分查找的前提条件：

- 目标函数单调性（单调递增或单调递减）

- 存在上下界（bounded）

- 能够通过索引访问（index accessible）

代码模板：

```javascript
function search(arr, target) {
  let left = 0, right = arr.length - 1;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] == target) {
        // 找到了要找的元素
        break; or return mid;
    } else if (arr[mid] > target) {
        right = mid - 1;
    } else if (arr[mid] < target) {
        left = mid + 1;
    }
  }
}
```
