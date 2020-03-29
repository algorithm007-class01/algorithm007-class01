# 本周总结：  

## 第一部分   
Queue和Priority Queue的源码分析，由于平时工作使用1.8版本就基于Java8来分析吧。  

### Queue
Queue在Java中是一个接口，主要有 add(e),remove(),element(),offer(e),poll(),peek()这三个方法，其中add remove element在执行中出错会抛出异常。

Queue的父接口为：Collection,Iterable  
Queue的子接口有：BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>  
Queue的实现类有：AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, 
LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue


* 插入方法add(),offer():
  1. Queue不能插入null，会抛出NullPointerException，
  2. Queue的add方法在队列没有空间的时候会抛出IllegalStateException异常，使用容量有限制的队列时offer方法优于add。

* 删除方法remove(),poll():  
  1. 返回并删除头部元素  
  2. 如果队列为空remove方法将会抛出NoSuchElementException，而poll则返回null。

* 查询方法element(),peek():
  1. 返回头部元素但不删除该元素  
  2. element方法在队列为空的时候会抛出NoSuchElementException异常，而peek返回null。

### PriorityQueue
PriorityQueue父类为AbstractQueue，是一个基于priority heap（优先级堆）实现的队列，队列中的元素可根据natural ordering（自然排序）进行排序也可使用
Comparator进行排序，具体使用哪种排序方式根据创建对象时使用的构造函数决定。PriorityQueue中不能存在null元素，由于优先队列会
根据natural ordering进行排序因此内部保存的元素必须是实现Comparable的类的实例否则会抛出ClassCastException异常。      
PriorityQueue的头部保存排序后最小的元素，如果最小元素相同则头元素是这几个相同元素中随机的一个。  
PriorityQueue是一个无界队列，内部由一个数组来存储队列中的元素，数组满了可自动扩容。  
PriorityQueue不是线程安全的，并发场景下可使用PriorityBlockingQueue。  
查询时间复杂度为O(log n)。

* 插入方法add(),offer():  
  如果插入的元素不能和现有元素进行比较，则抛出ClassCastException异常。在源码中add()方法实际调用的是offer()方法。
源码中：如果内部数组已满，则进行扩容。扩容时如果当前大小小于64则原数组大小加2否则原大小右移一位(根据注释增长50%)。并进行shiftUp操作。

* 删除方法remove(),poll():  
  1. remove(Object o)删除指定元素，源码中通过indexOf方法遍历内部数组找出该元素所在下标，将该下标对应的元素置为null，同时通过shiftDown和shiftUp来操作堆（具体原因需要学习堆相关知识）。
  2. poll返回队列头部元素，如果队列为空poll返回null。源码中当内部数组size不为0的时候进行了一次siftDown(0, x)操作。

* 查询方法element(),peek():
  1. 返回头部元素但不删除该元素  
  2. element方法在队列为空的时候会抛出NoSuchElementException异常，而peek返回null。

* 查询方法peek():  
  返回头部元素但不删除该元素。

* toArray()方法：   
  直接调用Arrays.copyOf(queue, size)复制一个新的数组对象，内容与当前内部数组一致，非当前内部数组queue的引用。  

* toArray(T[] a)方法：  
  将元素复制到入参数组a中。

### HashMap  
HashMap为Map接口的实现类，它是非线程安全的并且它的Key和Value均可以为null，存入其中的元素的顺序是不固定的。
* HashMap中的关键参数:  
  1. 负载因子 loadFactor
  2. 容量 threshold = capacity * loadFactor
  3. Node<K,V>数组 table Node<K,V>存放了hash值，key和value
  4. TreeNode （JDK1.8）  

HashMap默认容量为16,负载因子0.75。  
HashMap内部维护一个Node<K,V>数组table,Node实现了Map.Entry<K,V>接口Map中的元素均存储于该链表数组中。  
在构造函数中不会对table进行初始化，初始化操作在put方法中进行。  

* put()方法:   
  1. 1.8中实现方式：   
在put操作的时候如果根据这个公式的运算(nodeLength - 1) & hash得到的数组下标内的元素为空则将元素发在该下标位置。  
如果不为空则遍历该位置的链表将元素放入链表的尾部，如果此时链表元素大于等于8则转为使用红黑树来存储。  
如果map中元素数量大于实际容量则需要进行扩容，扩容比较耗时因此在定义HashMap对象的时候最好可以指定预期中Map需要的容量。

  2. 1.7中实现方式：  
在put操作的时候更具Hash值在table中选择元素存放的下标，如果该位置为空将元素发在此处，如果不为空则将该位置现有元素的next指向这个新的元素。

* get()方法：  
  1. 1.8中实现方式：   
在进行get操作时先根据Hash值和Key检查table下链表的第一个节点，如果没有匹配到则遍历链表寻找Key对应的Value,此时如果是TreeNode则调用getTreeNode方法寻找Key对应的Value。  
  2. 1.7中实现方式：  
在put操作的时候更具Hash值在table中选择元素存放的下标，如果该位置为空将元素发在此处，如果不为空则将该位置现有元素的next指向这个新的元素。

如果负载因子过小则会导致table的大小变小增加resize次数，如果负载因子过大则会导致table的大小变大如果map中存放元素不多的话会浪费内存空间。    
初始化HashMap容量是建议设置为 (实际存放数量/0.75)+1
### Natural Ordering （自然排序）
实现Comparable接口进行排序被称为类的自然排序，
实现了Comparable接口的类可以使用Collections.sort()或Arrays.sort()对内部元素进行排序,该接口的compareTo()方法被称为natural comparison method（自然比较方法）。  
对于一个类A的实例e1和e2 e1.compareTo(e2) == 0 和  e1.equals(e2)的比较结果相同。  
由于null不是一个类的实例因此compareTo(e)方法的入参不能为null否则会抛出NullPointerException异常。

### 改写 Deque 的代码
***
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
***
## 第二部分
### 学习笔记

#### 栈 
特征：先入后出 FILO  
#### 时间复杂度
添加 O(1)  
删除 O(1)  
查询 O(n)

#### 队列 
特征：先入先出 FIFO  
#### 时间复杂度
添加 O(1)  
删除 O(1)  
查询 O(n)

#### 双端队列 Deque (Double End Queue)  
特征：既可以在头部插入或删除数据 也可以在尾部插入或删除数据

#### 优先队列 PriorityQueue (接口)  
特征：根据元素的优先级存放，优先级高的在对头低的在队尾。  
底层实现的数据结构可以有多种:堆、红黑树、二叉搜索树、AVL、treap
#### 时间复杂度
添加 O(1)  
删除 O(1)  
查询 O(log n) 按照元素优先级取出  

#### 解题方法思路
找出逻辑的最近相关性 事物最前和最后都一样 类似洋葱结构 可使用栈来解决  
排队的思路用队列  
滑动窗口题目一般使用队列求解  
