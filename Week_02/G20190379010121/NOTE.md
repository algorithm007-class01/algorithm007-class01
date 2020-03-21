# 栈

## 实现
```java

// 基于数组实现的顺序栈
public class ArrayStack {
  private String[] items;  // 数组
  private int count;       // 栈中元素个数
  private int n;           //栈的大小

  // 初始化数组，申请一个大小为n的数组空间
  public ArrayStack(int n) {
    this.items = new String[n];
    this.n = n;
    this.count = 0;
  }

  // 入栈操作
  public boolean push(String item) {
    // 数组空间不够了，直接返回false，入栈失败。
    if (count == n) return false;
    // 将item放到下标为count的位置，并且count加一
    items[count] = item;
    ++count;
    return true;
  }
  
  // 出栈操作
  public String pop() {
    // 栈为空，则直接返回null
    if (count == 0) return null;
    // 返回下标为count-1的数组元素，并且栈中元素个数count减一
    String tmp = items[count-1];
    --count;
    return tmp;
  }
}
```
## 应用

- 最小相关性适合用栈来实现
- 用两个队列可以实现栈


### 双端队列 deque



### priority queue
- 插入 o(1)
- 获取 o(logn) 获取优先级最高的元素 用堆实现
- 分析queue 和 priority queue源码实现


#### queue分析

Queue 是队列接口,继承集合这个接口,提供了队列的基本操作 offer,add,remove,poll,peek等

#### priority queue分析
- 基于数组实现堆,完全二叉树实现的小顶堆

```
leftNo = parentNo*2+1
rightNo = parentNo*2+2
parentNo = (nodeNo-1)/2
```
通过上述三个公式，可以轻易计算出某个节点的父节点以及子节点的下标。这也就是为什么可以直接用数组来存储堆的原因。
### 函数调用

### 表达式求值
其中一个保存操作数的栈，另一个是保存运算符的栈。我们从左向右遍历表达式，当遇到数字，我们就直接压入操作数栈；当遇到运算符，就与运算符栈的栈顶元素进行比较。如果比运算符栈顶元素的优先级高，就将当前运算符压入栈；如果比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取 2 个操作数，然后进行计算，再把计算完的结果压入操作数栈，继续比较

### 括号匹配
我们用栈来保存未匹配的左括号，从左到右依次扫描字符串。当扫描到左括号时，则将其压入栈中；当扫描到右括号时，从栈顶取出一个左括号。如果能够匹配，比如“(”跟“)”匹配，“[”跟“]”匹配，“{”跟“}”匹配，则继续扫描剩下的字符串。如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则说明为非法格式。当所有的括号都扫描完成之后，如果栈为空，则说明字符串为合法格式；否则，说明有未匹配的左括号，为非法格式

# 队列

## 实现

### 基于数组
```java

// 用数组实现的队列
public class ArrayQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队

   // 入队操作，将item放入队尾
  public boolean enqueue(String item) {
    // tail == n表示队列末尾没有空间了
    if (tail == n) {
      // tail ==n && head==0，表示整个队列都占满了
      if (head == 0) return false;
      // 数据搬移
      for (int i = head; i < tail; ++i) {
        items[i-head] = items[i];
      }
      // 搬移完之后重新更新head和tail
      tail -= head;
      head = 0;
    }
    
    items[tail] = item;
    ++tail;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
    String ret = items[head];
    ++head;
    return ret;
  }
}
```
入队 o(1)
出队 o(1)

### 基于链表

```java
package queue;

/**
 * 基于链表实现的队列
 *
 * Author: Zheng
 */
public class QueueBasedOnLinkedList {

  // 队列的队首和队尾
  private Node head = null;
  private Node tail = null;

  // 入队
  public void enqueue(String value) {
    if (tail == null) {
      Node newNode = new Node(value, null);
      head = newNode;
      tail = newNode;
    } else {
      tail.next = new Node(value, null);
      tail = tail.next;
    }
  }

  // 出队
  public String dequeue() {
    if (head == null) return null;

    String value = head.data;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    return value;
  }

  public void printAll() {
    Node p = head;
    while (p != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
    System.out.println();
  }

  private static class Node {
    private String data;
    private Node next;

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }

    public String getData() {
      return data;
    }
  }

}
```

### 循环链表
```java

public class CircularQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列满了
    if ((tail + 1) % n == head) return false;
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    String ret = items[head];
    head = (head + 1) % n;
    return ret;
  }
}
```

### 阻塞队列

### 并发队列

# 散列表

## hashmap 总结

- 实现结构

链地址法:hash算法 + node数组+链表

- 初始化
  - loadFactor 默认0.75
  - size 默认16
  - threshold = loadFactor * arr.size
  - 初始化时指定容量 : 预定容量/loadFactor


- put优化  
**hash()** 方法尽量让hashcode的低16位参加hash运算
```
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

**(n-1)&hash** 哈希表习惯将长度设置为 2 的 n 次方,这样恰好可以保证 (n - 1) & hash 的计算得到的索引值总是位于 table 数组的索引之内
```
  if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //通过putVal方法中的(n - 1) & hash决定该Node的存储位置
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

```
**hash冲突**   
1.7头插法 最近插入的都是热点数据,在扩容时会改变链表中元素原本的顺序，以至于在并发场景下导致链表成环的问题  
1.8尾插法 为了避免出现逆序且链表死循环的问题）。



- get优化
  - 链表长度>8 转为**红黑树** 查询复杂度从O(n)到O(log(n)),有效防止hash碰撞攻击
  - 为什么是8,官方泊松分布实验发现，假设hashmap长度length为16，假设放入12（0.75*16）个数据到hashmap中，链表中存放8个节点的概率仅为0.00000006
- resize 优化
  - 数组复制
  - 1.7重新hash
  - 1.8 e.hash & oldCap 为0 : 索引不变 非0: 原索引+ oldCap = 新索引







