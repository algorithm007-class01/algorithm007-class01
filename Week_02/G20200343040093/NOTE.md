##学习笔记
### Stack & Queue关键点
* Stack：先入后出；添加、删除皆为O(1)
* Queue：先入先出；添加、删除皆为O(1)
* 查询都为O(n)

### Deque
1. 两端可以进出的Queue
Deque-double ended queue
2. 插入和删除O(1)
3. 查询O(n)

### Priority Queue
1. 插入：O(1)
2. 取出操作：O(logN)-按照元素的优先级取出
3. 底层具体实现的数据结构较为多样和复杂:heap、bst、treap


### 相关文档
[Stack(Java8)](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)  
[Queue(Java8)](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)  
[Deque(Java8)](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)  
[PriorityQueue(Java8)](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)  

### 源码分析
[Java的Stack源码](http://developer.classpath.org/doc/java/util/Stack-source.html)  
[Java的Queue源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)  
[Java的PriorityQueue源码](http://developer.classpath.org/doc/java/util/PriorityQueue-source.html)  


### 总结
* add first
```
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("c");
    deque.addFirst("b");
    deque.addFirst("a");
    System.out.println(deque);

    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
        System.out.println(deque.pollLast());
    }
    System.out.println(deque);
```
* add last
```
    Deque<String> deque = new LinkedList<>();
    deque.addLast("a");
    deque.addLast("b");
    deque.addLast("c");
    System.out.println(deque);

    String str = deque.peekLast();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
        System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
```
* Queue与Stack不同，是接口，具体实现要看对应的实现类，看了LinkedList，基于Node<E>实现
* PriorityQueue基于Object[] queue实现

#### LinkedList源码
```
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    
    public boolean offer(E e) {
        return add(e);
    }
    
    public E remove() {
        return removeFirst();
    }
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
    /**
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
```
#### PriorityQueue源码
```
    public boolean add(E e) {
        return offer(e);
    }
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
    
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
    
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }
```

### 只用栈来做队列，或只用队列来做栈，套路用两个栈或者两个队列

#### 相关题目

[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)  
[最小栈](https://leetcode-cn.com/problems/min-stack/)  
[柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)  
[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)  

### Hash table
哈希表(Hash table)，也叫散列表，是根据关键码值(Key value)而直接进行访问的数据结构。  
它通过把关键码值映射到表中的一个位置来访问记录，以加快查找的速度。  
这个映射函数叫做散列函数(Hash function)，存放记录的数组叫做哈希表(或散列表)。  

### 工程实践
* 电话号码簿
* 用户信息表
* 缓存(LRU Cache)
* 键值对存储(Redis)

### 课后作业
#### HashMap总结
##### put
针对key做了hash计算
```
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```
然后将计算出来的hash值、key、value存储起来，里面有很多写法，暂时没想明白为什么这么写，以及精妙之处，感觉还得多看
```
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
##### 网友总结put函数的实现
1. 对key的hashCode()做hash，然后再计算index;
2. 如果没碰撞直接放到bucket里；
3. 如果碰撞了，以链表的形式存在buckets后；
4. 如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
5. 如果节点已经存在就替换old value(保证key的唯一性)
6. 如果bucket满了(超过load factor*current capacity)，就要resize。

##### get

根据key和key计算得到的hash值取
```
    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
```
根据hash值和key去取主要是为了预防hash碰撞，这里始终要check first node
```
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```
##### 网友总结get函数的实现

1. bucket里的第一个节点，直接命中；
2. 如果有冲突，则通过key.equals(k)去查找对应的entry  
若为树，则在树中通过key.equals(k)查找，O(logn)；  
若为链表，则在链表中通过key.equals(k)查找，O(n)。

### 实战题目
#### 四件套
1. 把题目过一遍，确认题目的意思
2. 所有可能的解法=>找出最优解法(实践&空间复杂度最优)
3. 写代码
4. 测试用例

[有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)  
[字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)  
[两数之和](https://leetcode-cn.com/problems/two-sum/description/)  

### [养成收藏精选代码的习惯](https://shimo.im/docs/R6g9WJV89QkHrDhr/read)