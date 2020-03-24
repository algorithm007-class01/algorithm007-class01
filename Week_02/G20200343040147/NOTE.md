学习笔记

# deque

+ deque的push相当于stack的压栈操作，LinkedList的push操作，使用的addFirst(e)
+ addLast 方法相当于队列的add操作，追加

#### 1、pollFirst 和 poll 的是底层实现是一样的，都是取出第一个

```
poll()
final Node<E> f = first;
return (f == null) ? null : unlinkFirst(f);
```

```
pollFirst()
final Node<E> f = first;
return (f == null) ? null : unlinkFirst(f);
```

#### 2、pop和poll对于deque一致，都是从头部拿出第一个元素，因此实现方式相同

```
pop()
final Node<E> f = first;
if (f == null)
    throw new NoSuchElementException();
return unlinkFirst(f);
```

# hashmap

+ 底层是个数组的接口，在java的hashmap中底层是Node数组，初始大小16
+ Node是实现了Map.Entry<K,V>接口，元素中包含k和v
+ hashmap默认的装载因子是0.75，即使用空间超过75%需要扩容
+ 用链表法解决hash冲突，Node中有next指针指向下一个元素
+ hashmap的Entry维护了双向链表，TreeNode继承LinkedHashMap.Entry，继承HashMap.Node，实现implements Map.Entry接口
+ 重新扩容后数组元素需要移动位置
+ hash函数使用了key的hashcode，equals比较元素是否相同，如果equals相等hashcode不等的话在hashmap的结构中就无法找到对应的元素

