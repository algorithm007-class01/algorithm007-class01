学习笔记

搜索的条件：每个节点都要访问一次   且每个节点只访问一次

```python
DFS代码模板
    递归写法：
    visited = set();
    def dfs(node,visited):
        if node in visited:
        return;
        
        visited.add(node);
        #! process current node here
        
        for next_node in node.children():
            if next_node not in visited:
                dfs(next_node,visited);


    非递归写法:
    dfs DFS(self,tree):
        
        if tree.root is none:
            return [];
        
        visited,stack = [],[tree.root];
        
        while stack:
            node = stack.pop();
            visited.add(node);
            
            process(node);
            nodes = generate_related_node(node);
            stack.push(nodes);

            
    

```

```python
def BFS(graph,start,end):
    visiteg = set();
    queue = [];
    queue.append([start]);
    
    while queue:
        node = queue.pop();
        visited.add(node);
        
        process(node);
        nodes = genrate_related_nodes(node);
        queue.push(nodes);
           

```
```python
   
二分查找代码模板：

left,right = 0,len(array)-1;
    while left <= right:
        mid = (left+right)/2;
        if(array[mid] == target):
            break or return result;
        elif array[mid] < target:
            left = mid+1;
        elif array[mid] > target:
            right = mid-1;  

``` 