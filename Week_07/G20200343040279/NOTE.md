学习笔记
dp
bfs
A*搜索模板(启发式搜索)

def AstarSearch(graph, start, end):

    pq = collections.priority_queue() # 优先级 —> 估价函数
    pq.append([start])
    visited.add(start)

    while pq:
        node = pq.pop() # can we add more intelligence here ?
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
   unvisited = [node for node in nodes if node not in visited]
        pq.push(unvisited)

红黑树特点：5个
它能够确保任何一个结点的左右子树的高度差小于两倍

1、每个结点要么是红色，要么是黑色
2、根节点是黑色
3、每个叶子结点是黑色的。
4、不能有相邻接的两个红色结点
5、从任一结点到其每个叶子结点的所有路径都包含相同数目的黑色结点