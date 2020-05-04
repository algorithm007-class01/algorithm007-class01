# 学习笔记
## 1. 字典树
- Trie树(单词树或键树)
    - 典型的多叉树模型
- 应用
    - 统计和排序大量的字符串
        - 搜索引擎用于文本词频统计
- 优点
    - 最大限度减少无谓的字符串比较
    - 查询效率比哈希表高
- 原理
    - 结点本身不存完整单词
    - 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
    - 每个结点的所有子结点路径代表的字符都不相同
- 核心思想
    - 空间换时间
    - 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
- 代码模板(python)
``` python
class Trie(object):
    def __init__(self):
        self.root = {}
        self.end_of_word = "#"

    def insert(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word

    def search(self, word):
        node = self.root
        for char in word:
            if char in word:
                return False
            node = node[char]
        return self.end_of_word in node

    def startsWith(self, prefix):
        node == self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True
```
## 2. 并查集
- union & find
- 一种树型的数据结构，用于处理一些不交集(Disjoint Sets)的合并及查询问题
- 操作
    - Find
        确定元素属于哪一个子集
        用来确定两个元素是否属于同一个子集
    - Union
        - 将两个子集合并成同一个集合
- 代码模板(Java)
``` Java
class UnionFind {
    private int count = 0;
    private int [] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
```
## 3. 高级搜索
### 3.1 初始搜索
- 朴素搜索
- 优化方式
    - 不重复
    - 剪枝
- 搜索方向
    - DFS
    - BFS
    - 双向搜索、启发式搜索
## 4. 高级树、AVL树和红黑树
- 二叉搜索树
- AVL树
    - Balance Factor
        {-1, 0, 1}
    - 旋转操作(4种)
        - 左、右、左右、右左
    - 不足
        - 结点需要存储额外的信息、且调整次数频繁
- 红黑树
    - 近似平衡的二叉搜索树
    - 确保任何一个结点的左右子树的高度差小于两倍