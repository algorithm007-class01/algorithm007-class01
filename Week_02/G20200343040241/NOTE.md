##学习笔记
    stack 先入后出，添加删除皆是O(1)，查询为O(n)
    queue 先入先出，添加删除皆是O(1)，查询为O(n)
    deque 双端队列，添加删除皆是O(1)，查询为O(n)

    priority queue 按照优先级出队列，取出操作为O(logN)

###Deque改写

    public static void main(String[] args) {
            Deque<String> deque = new LinkedList<String>();
    
            deque.addLast("b");
            deque.addLast("c");
            deque.addLast("d");
            deque.addFirst("a");
    
            System.out.println(deque);
    
            String str = deque.getFirst();
            System.out.println(str);
            System.out.println(deque);
    
            while (deque.size() > 0){
                System.out.println(deque.removeFirst());
            }
            System.out.println(deque);
        }


###HashMap总结    

```HashMap的主干是一个Entry数组。```
```Entry是HashMap的基本组成单元，每一个Entry包含一个key-value键值对。（其实所谓Map其实就是保存了两个对象之间的映射关系的一种集合）HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,那么查找，添加等操作很快，仅需一次寻址即可；如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。```

```注意：JDK1.8中HashMap是由数组+链表+红黑树组成的，当链表长度大于8的时候就会转换成红黑树```


#####HashMap的put方法实现
     思路如下：
    
    1.table[]是否为空
    
    2.判断table[i]处是否插入过值
    
    3.判断链表长度是否大于8，如果大于就转换为红黑二叉树，并插入树中
    
    4.判断key是否和原有key相同，如果相同就覆盖原有key的value，并返回原有value
    
    5.如果key不相同，就插入一个key，记录结构变化一次
    
    
    
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
    //判断table是否为空，如果是空的就创建一个table，并获取他的长度
            Node<K,V>[] tab; Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
    //如果计算出来的索引位置之前没有放过数据，就直接放入
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
    //进入这里说明索引位置已经放入过数据了
                Node<K,V> e; K k;
    //判断put的数据和之前的数据是否重复
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))   //key的地址或key的equals()只要有一个相等就认为key重复了，就直接覆盖原来key的value
                    e = p;
    //判断是否是红黑树，如果是红黑树就直接插入树中
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
    //如果不是红黑树，就遍历每个节点，判断链表长度是否大于8，如果大于就转换为红黑树
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
    //判断索引每个元素的key是否可要插入的key相同，如果相同就直接覆盖
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
    //如果e不是null，说明没有迭代到最后就跳出了循环，说明链表中有相同的key，因此只需要将value覆盖，并将oldValue返回即可
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
    //说明没有key相同，因此要插入一个key-value，并记录内部结构变化次数
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }
    
#####HashMap的get方法实现
      实现思路：
     
     1.判断表或key是否是null，如果是直接返回null
     
     2.判断索引处第一个key与传入key是否相等，如果相等直接返回
     
     3.如果不相等，判断链表是否是红黑二叉树，如果是，直接从树中取值
     
     4.如果不是树，就遍历链表查找   
     
     
     final Node<K,V> getNode(int hash, Object key) {
             Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
     //如果表不是空的，并且要查找索引处有值，就判断位于第一个的key是否是要查找的key
             if ((tab = table) != null && (n = tab.length) > 0 &&
                 (first = tab[(n - 1) & hash]) != null) {
                 if (first.hash == hash && // always check first node
                     ((k = first.key) == key || (key != null && key.equals(k))))
     //如果是，就直接返回
                     return first;
     //如果不是就判断链表是否是红黑二叉树，如果是，就从树中取值
                 if ((e = first.next) != null) {
                     if (first instanceof TreeNode)
                         return ((TreeNode<K,V>)first).getTreeNode(hash, key);
     //如果不是树，就遍历链表
                     do {
                         if (e.hash == hash &&
                             ((k = e.key) == key || (key != null && key.equals(k))))
                             return e;
                     } while ((e = e.next) != null);
                 }
             }
             return null;
         } 
         
         



