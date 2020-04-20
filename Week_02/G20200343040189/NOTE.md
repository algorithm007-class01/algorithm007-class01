学习笔记

## 关于HashMap的一些总结

### HashMap的实现原理

HashMap的主干是一个Entry数组。Entry是HashMap的基本组成单元，没一个Entry包含一个key-value键值对，Map其实就是保存了两个对象之间的映射关系的一种集合。HashMap由数组+链表组成，数组是HashMap的主体，链表是为了解决哈希冲突而存在的，如果定位到数组位置不含链表，那么查找、添加等操作很快，仅需要一次寻址即可。如果定位到的数组包含链表，对于添加操作其时间复杂度为O(n)，因为要先遍历链表，存在则覆盖，否则新增；对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，从性能考虑HashMap中的链表越少，性能才会越好。

### Hash Table的复杂度分析（平均情况）

| 插入 | 查询 | 删除 |
| ---- | ---- | ---- |
| O(1) | O(1) | O(1) |

### HashMap的put()与get()

put之前，先计算key的hashCode，hashCode是个int类型的值，计算出来的hashCode就是数据在这个数组中的索引。所以，在get的时候，也是先计算key的hashCode，然后通过hashCode直接从数组中取出值即可。如果存在不同key的hashCode相同，那么这些hashCode相同的值就被存放在一个链表上，查找的时候就遍历这个链表，这就会造成性能下降，所以需要设计一个好的散列函数。



## 有关于双端队列(Deque)

deque与queue中的等效方法

| Queue方法 | 等效Deque方法 |
| --------- | ------------- |
| add(e)    | addLast()     |
| offer(e)  | offerLast()   |
| remove()  | removeFirst() |
| poll()    | pollFirst()   |
| element() | getFirst()    |
| peek()    | peekFirst()   |

deque与stack中的等效方法

| Stack方法 | 等效Deque方法 |
| --------- | ------------- |
| push(e)   | addFirst(e)   |
| pop()     | removeFirst() |
| peek()    | peekFirst()   |

```java
boolean add(E e){
    //添加元素到此双端队列的末尾，如果失败则抛异常
}
void addFirst(E e){
    //将元素插入到双端队列的前面，如果失败则抛异常
}
void addLast(E e){
    //将元素插入到双端队列的末尾，如果失败则抛异常
}
boolean contains(Object o){
    //此双端队列是否包含指定的元素
}
Iterator<E> descendingIterator(){
    //以相反的顺序返回此双端队列中的元素的迭代器
}
E element(){
    //检索但不删除此双端队列代表的队列的头
}
E getFirst(){
    //检索但不删除双端队列中的第一个元素
}
E getLast(){
    //检索但不删除双端队列中的最后一个元素
}
boolean offer(E e){
    //不违反容量限制的情况下立即将指定元素插入到双端队列中
}
boolean offerFirst(E e){
    //将指定元素插入到双端队列的前面
}
boolean offerLast(E e){
    //将指定元素插入到双端队列的后面
}
E peek(){
    //检索但不删除此双端队列的头部
}
E peekFirst(){
    //检索但不删除此双端队列的第一个元素，如果队列为空则返回null
}
E peekLast(){
    //检索但不删除此双端队列的最后一个元素，如果队列为空则返回null
}
E poll(){
    //检索并删除此双端队列的头部
}
E pollFirst(){
    //检索并删除双端队列的第一个元素
}
E pollLast(){
    //检索并删除双端队列的最后一个元素
}
E pop(){
    //从此双端队列表示的堆栈中弹出一个元素
}
void push(E e){
    //将一个元素推入此双端队列表示的堆栈上
}
E remove(){
    //检索并删除此双端队列的头部
}
boolean remove(Object o){
    //检索并删除指定元素的第一次出现
}
boolean removeFirstOccurrence(Object o){
    //检索并删除指定元素的第一次出现
}
boolean removeLastOccurrence(Object o){
    //检索并删除指定元素的最后一次出现
}
E removeFirst(){
    //检索并删除此双端队列中第一个元素
}
E removeLast(){
    //检索并删除此双端队列中最后一个元素
}
int size(){
    //返回此双端队列中的元素数目
}
```



## 有关于栈(Stack)

Stack是后进先出的堆栈

```java
boolean empty(){
    //判断栈是否为空
}
E peek(){
    //在不将栈顶元素从栈中移除的情况下，查看该栈顶元素
}
E pop(){
    //删除此栈顶元素，并将该元素作为返回值对象
}
E posh(E item){
    //将item推入栈的顶部
}
int search(Object o){
    //返回元素在栈中的下标
}
```



## 有关于队列(Queue)

|      | 引发异常  | 返回特殊值 |
| ---- | --------- | ---------- |
| 插入 | add(e)    | offer(e)   |
| 去掉 | remove()  | poll()     |
| 检查 | element() | peek()     |

队列通常但不一定以FIFO的方式对元素进行排序，例外情况如优先级队列和LIFO队列（堆栈）。队列的开头都可以通过调用remove()或poll()来删除该元素。

```java
boolean add(E e){
    //可以在不违反容量限制的情况下将指定元素插入此队列，成功则返回true
}
boolean offer(E e){
    //跟add方法类似,遇到满队列不会抛异常
}
E remove(){
    //检索并删除此队列的头，与poll()不同处在于如果此队列为空，则引发异常
}
E poll(){
    //与remove类似，如果此队列为空则返回null
}
E element(){
    //检索但不删除此队列的头，如果此队列为空，则引发异常
}
E peek(){
    //检索但不删除此队列的头，如果此队列为空则返回null
}
```



## 有关于优先级队列(PriorityQueue)

### 构造器

```java
PriorityQueue(){
    //创建一个优先级队列，初始容量为11，根据其自然顺序对元素进行排序
}
PriorityQueue(Collection<? extends E> c){
    //创建一个包含指定集合类型的优先级队列
}
PriorityQueue(int initialCapacity){
    //创建一个具有初始容量根据元素的自然顺序进行排序的优先级队列
}
PriorityQueue(int initialCapacity, Comparator<? extends E> comparator){
    //创建一个具有初始容量、根据指定比较器规则排序的优先级队列
}
```



### 方法

```java
boolean add(E e){
    //将指定元素插入优先级队列
}
void clear(){
    //将优先级队列中的所有元素删除
}
Comparator<? super E> comparator(){
    //返回队列中的比较器，根据自然顺序排序则返回null
}
boolean contains(Object o){
    //队列中是否存在指定的元素
}
Iterator<E> iterator(){
    //返回对队列中的元素进行迭代的迭代器
}
boolean offer(E e){
    //将指定元素插入到队列中
}
E peek(){
    //检索但不删除此队列的头
}
E poll(){
    //检索并删除次队列的头
}
boolean remove(Object o){
    //从队列中删除指定元素
}
int size(){
    //返回队列中的元素数目
}
```

