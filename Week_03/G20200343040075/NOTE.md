学习笔记

Linked List 是特殊化的 Tree
Tree 是特殊化的 Graph

二叉树遍历：
前序：根-左-右
中序：左-根-右
后序：左-右-根
归根结底就是根结点的先后情况

二叉搜索树 BST
也称有序二叉树（Ordered Binary Tree）/ 排序二叉树（Sorted Binary Tree），
是指一颗空树或者具有下列性质的二叉树：
1.左子树上**所有结点**的值均小于它的根结点的值；
2.右子树上**所有结点**的值均大于它的根结点的值；
3.以此类推：左/右子树也分别为二叉查找树。（这就是**重复性**）
中序遍历：升序排列
常见操作：
1.查询
2.插入新结点（创建）
3.删除
Demo：https://visualgo.net/zh/bst
平均的时间复杂度为O(logn)

树的面试题解法一般都是递归，为什么？
1.其左右子树的特性--有重复性
2.树是一种有向的图，可以保证递归的方向正确

````python  
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

def inorder(self, root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)

def postorder(self, root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
````

##代码模版：  

深度优先搜索（DFS）
DFS 代码 - 递归写法
````python 
visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return

    visited.add(node)

    # process current node here
    ...

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
````

宽度优先搜索（BFS）
BFS 代码
````python 
visited = set()
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```` 

BFS & DFS 简化四部曲
1. 建立 queue/stack， visited set
2. whild queue/stack 不空 {
3.     处理当前节点
4.     扩展节点/更新visited/入queue/stack
5. }

栈应用于深度优先搜索
队列(先进先出)，增删O(1)-->广度优先搜索
````java
List<Integer> values = new ArrayList<>();
Queue<Node> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
    Node nextNode = queue.remove();
    values.add(nextNode.val);
    for (Node child : nextNode.children) {
        queue.add(child);
    }
}
````

递归代码模版
````python
def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return

    # process logic in current level
    process(level, data, ...)

    # drill down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed
````
````java
public void recursion(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process (level, param);

    // drill down
    recursion (level + 1, newParam);

    // restore current status
}
````
思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维