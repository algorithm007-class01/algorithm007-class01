# 树及搜索优化
## 1. Trie树
应用：搜素提示
优点：查询比哈希效率高
缺点：内存空间占用大
主要方法: insert, search, startsWith


Action：插入（结束true），搜素（返回bool），是否起始（不在子节点，false。否则返回true）

## 2. 并查集
场景：分组，是否在同一组
主要方法: makeUniun(size), uniun(o1,o2), find(o1):p
优化：路径压缩，对于多个点的判断，可以加速

## 3. 高级搜索
3.1 剪枝
3.2 双向BFS
3.3 启发式搜索

## 4. 红黑树和AVL树
特性：自平衡，平衡检索时间