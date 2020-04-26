学习笔记

## Trie树的基本性质和实现

### 基本结构

字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

**它的优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。**



### 基本性质

1. 结点本身不存完整单词；
2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点相对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同。



### 核心思想

Trie树的核心思想是空间换时间。

利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。



### Trie树的代码模板

```java
class TrieNode {
    private TrieNode[] links;
    private final int size = 26;
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode(size);
    }
    
    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}
```





## 并查集

### 基本操作

makeSet(s)：建立一个新的并查集，其中包含s个单元素集合。

unionSet(x, y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。

find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。



### 并查集代码模板

```java
class UnionFind {
    private int count = 0;
    private int[] parent;
    
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
            return ;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
```



## 二叉搜索树

### 基本特征

二叉搜索树，也称有序二叉树、排序二叉树，是指一棵空树或者具有以下性质的二叉树：

1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推，左右子树也分别为二叉查找树。

二叉搜索树的中序遍历就是升序遍历。



### AVL树

平衡因子（Balance Factor）：是它的左子树的高度减去它的右子树的高度的绝对值不大于1。

可以通过四种旋转操作来进行平衡：左旋、右旋、左右旋、右左旋。

AVL树是一棵严格保证平衡的树。它的每个结点存平衡因子，因此结点需要存储额外的信息、且调整次数频繁。



### 红黑树

红黑树是一种近似平衡的二叉搜索树，**它能够确保任何一个结点的左右子树的高度差小于两倍。**红黑树要满足以下条件：

- 每个结点要么是红色，要么是黑色；
- 根结点为黑色；
- 每个叶子结点(NIL结点，空结点)是黑色的；
- 不能有相邻接的两个红色结点；
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。



