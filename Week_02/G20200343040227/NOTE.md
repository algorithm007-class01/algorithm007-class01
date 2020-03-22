学习总结

### 1、用 add first 或 add last 这套新的 API 改写 Deque 的代码
```
package week2.homework;

import java.util.Deque;
import java.util.LinkedList;

public class Summary {
        public static void main(String[] args) {
            Deque<String> deque = new LinkedList<>();
            deque.addFirst("A"); // A
            deque.addFirst("B"); // B -> A
            deque.addLast("C"); // B -> A -> C
            System.out.println(deque.pollFirst()); // B, 剩下 A ->C
            System.out.println(deque.pollLast()); // C,剩下A
            System.out.println(deque.pollFirst()); // A
            System.out.println(deque.pollFirst()); // null
        }
}
```
###2、分析 Queue 和 Priority Queue 的源码
#### Queue源码分析（Java 8）
队列（Queue）是一种经常使用的集合。Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。
它和List的区别在于，List可以在任意位置添加和删除元素，而Queue只有两个操作：
把元素添加到队列末尾；
从队列头部取出元素。

在Java 8 的标准库中，队列接口Queue定义了以下几个方法：

int size()：获取队列长度；
boolean add(E)/boolean offer(E)：添加元素到队尾；add
E remove()/E poll()：获取队首元素并从队列中删除；
E element()/E peek()：获取队首元素但并不从队列中删除。
在添加、删除和获取队列元素总是有两个方法，这是因为在添加或获取元素失败时，这两个方法的行为是不同的。见下方源码备注：
 
####源码如下
     ```
     public interface Queue<E> extends Collection<E> {
         /**
          * 注：添加元素，如果空间不足，扔出异常
          * Inserts the specified element into this queue if it is possible to do so
          * immediately without violating capacity restrictions, returning
          * {@code true} upon success and throwing an {@code IllegalStateException}
          * if no space is currently available.
          *
          * @param e the element to add
          * @return {@code true} (as specified by {@link Collection#add})
          * @throws IllegalStateException if the element cannot be added at this
          *         time due to capacity restrictions
          * @throws ClassCastException if the class of the specified element
          *         prevents it from being added to this queue
          * @throws NullPointerException if the specified element is null and
          *         this queue does not permit null elements
          * @throws IllegalArgumentException if some property of this element
          *         prevents it from being added to this queue
          */
         boolean add(E e);
     
         /**
          * 注：添加元素，如果空间不足或者添加失败返回false或者null
          * Inserts the specified element into this queue if it is possible to do
          * so immediately without violating capacity restrictions.
          * When using a capacity-restricted queue, this method is generally
          * preferable to {@link #add}, which can fail to insert an element only
          * by throwing an exception.
          *
          * @param e the element to add
          * @return {@code true} if the element was added to this queue, else
          *         {@code false}
          * @throws ClassCastException if the class of the specified element
          *         prevents it from being added to this queue
          * @throws NullPointerException if the specified element is null and
          *         this queue does not permit null elements
          * @throws IllegalArgumentException if some property of this element
          *         prevents it from being added to this queue
          */
         boolean offer(E e);
     
         /**
          * 注：移除元素，队列为空扔出异常[throws an exception if this queue is empty.]
          * Retrieves and removes the head of this queue.  This method differs
          * from {@link #poll() poll()} only in that it throws an exception if
          * this queue is empty.
          *
          * @return the head of this queue
          * @throws NoSuchElementException if this queue is empty
          */
         E remove();
     
         /**
       * 注：移除元素，队列为空返回null

          * Retrieves and removes the head of this queue,
          * or returns {@code null} if this queue is empty.
          *
          * @return the head of this queue, or {@code null} if this queue is empty
          */
         E poll();
     
         /**
          * 注：取队首元素但不删除，如果队列为空则返回异常	
          * Retrieves, but does not remove, the head of this queue.  This method
          * differs from {@link #peek peek} only in that it throws an exception
          * if this queue is empty.
          *
          * @return the head of this queue
          * @throws NoSuchElementException if this queue is empty
          */
         E element();
     
         /**
          * 注：取队首元素但不删除，如果队列为空则返回null	
          * Retrieves, but does not remove, the head of this queue,
          * or returns {@code null} if this queue is empty.
          *
          * @return the head of this queue, or {@code null} if this queue is empty
          */
         E peek();
     ```
#### Priority Queue源码分析(java8)
PriorityQueue实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。 

PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。

要使用PriorityQueue，我们就必须给每个元素定义“优先级”。

PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）。
##### 分析:PriorityQueue 
  继承AbstractCollection extends AbstractCollection，同时实现Queue，利用抽象类，实现了一些基本的例如迭代，队列大小等基本操作
  ###### 初始化参数：
  // 默认容量 是11；
  private static final int DEFAULT_INITIAL_CAPACITY = 11;
  // 存储元素的地方，存储在数组中，默认使用数组实现优先级队列
  transient Object[] queue; // non-private to simplify nested class access
  // 元素个数
  private int size = 0;
  // 比较器，同时自带自然排序。另一种用户自定义比较器
  private final Comparator<? super E> comparator;
  // 修改次数 说明是fast-fail 
  transient int modCount = 0; // non-private to simplify nested class access
  
  ###### 初始化构造器：
     1、   //默认大小11，按照自然排序
     
            public PriorityQueue() {
               this(DEFAULT_INITIAL_CAPACITY, null);
           }
           
    2、  //按照传入大小初始化队列，按照自然排序
       public PriorityQueue(int initialCapacity) {
               this(initialCapacity, null);
           }
     3、  //初始化大小11，按照传入比较器排序
       public PriorityQueue(Comparator<? super E> comparator) {
               this(DEFAULT_INITIAL_CAPACITY, comparator);
           }
    4、  //按照传入大小初始化队列，按照传入比较器排序
        public PriorityQueue(int initialCapacity,  Comparator<? super E> comparator) {}
    5、  //按照传入collection 初始化
           public PriorityQueue(Collection<? extends E> c) {}
    6、  //按照传入PriorityQueue初始化
           public PriorityQueue(PriorityQueue<? extends E> c) {}
    7、  //SortedSet 初始化
           public PriorityQueue(SortedSet<? extends E> c) {}
###### 入队 
 入队add和offer方法相同，见下方代码add直接调用offer
 
    public boolean add(E e) {
        return offer(e);
    }
   offer 方法如下
   ```
   public boolean offer(E e) {
           //如果为空直接扔异常
           if (e == null)
               throw new NullPointerException();
           //修改次数加1    
           modCount++;
           int i = size;
           //确保容量足够，如果不够扩容
           if (i >= queue.length)
           //grow Double size if small; else grow by 50%
               grow(i + 1);
           //堆化，构造堆    
           siftUp(i, e);
           //完成后size+1
           size = i + 1;
           return true;
       }
     private void siftUp(int k, E x) {
     //判断是否有比较器，使用不同的方法
            if (comparator != null)
                siftUpUsingComparator(k, x, queue, comparator);
            else
                siftUpComparable(k, x, queue);
        }   
        //默认比较器
      private static <T> void siftUpComparable(int k, T x, Object[] es) {
              Comparable<? super T> key = (Comparable<? super T>) x;
              while (k > 0) {
              // 找到父节点的位置
               // 因为元素是从0开始的，所以减1之后再除以2
                  int parent = (k - 1) >>> 1;
                  //取到父节点的值
                  Object e = es[parent];
                  //自然比较，比父节点大，则跳出循环
                  if (key.compareTo((T) e) >= 0)
                      break;
                   //与父节点交换位置  
                  es[k] = e;
                  // 现在插入的元素位置移到了父节点的位置
                  // 继续与父节点再比较
                  k = parent;
              }
             // 最后找到插入的位置，放入元素
              es[k] = key;
          }  
```
          总结
          （1）入队不允许null元素；（是代码保证的）
          （2）如果数组不够用了，先扩容；
          （3）如果还没有元素，就插入下标0的位置；
          （4）如果有元素了，就插入到最后一个元素往后的一个位置
          （5）自下而上堆化，一直往上跟父节点比较；
          （6）如果比父节点小，就与父节点交换位置，直到出现比父节点大为止；
          （7）由此可见，PriorityQueue是一个小顶堆。 
          
          出队
          出队有两个方法，remove()和poll()，remove()也是调用的poll()，只是没有元素的时候抛出异常。具体实现
          public E remove() {
              // 调用poll弹出队首元素
              E x = poll();
              if (x != null)
                  // 有元素就返回弹出的元素
                  return x;
              else
                  // 没有元素就抛出异常
                  throw new NoSuchElementException();
          }
          
         public E poll() {
                final Object[] es;
                final E result;
        
                if ((result = (E) ((es = queue)[0])) != null) {
                    modCount++;
                    final int n;
                    final E x = (E) es[(n = --size)];
                    es[n] = null;
                    if (n > 0) {
                        final Comparator<? super E> cmp;
                        if ((cmp = comparator) == null)
                            siftDownComparable(0, x, es, n);
                        else
                            siftDownUsingComparator(0, x, es, n, cmp);
                    }
                }
                return result;
            }
            
            （1）将队列首元素弹出；
            （2）将队列末元素移到队列首；
            （3）自上而下堆化，一直往下与最小的子节点比较；
            （4）如果比最小的子节点大，就交换位置，再继续与最小的子节点比较；
            （5）如果比最小的子节点小，就不用交换位置了，堆化结束；
            （6）堆中的删除堆顶元素；
            
            总结
            （1）PriorityQueue是一个小顶堆；
            
            （2）PriorityQueue是非线程安全的；没有锁机制的保证
            
            （3）PriorityQueue不是有序的，只有堆顶存储着最小的元素；
            
            （4）入队就是堆的插入元素的实现；
            
            （5）出队就是堆的删除元素的实现；
          参考：https://juejin.im/post/5cbb2a996fb9a0689d6f9ca4
```
/*
    * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
    * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    */
   
   package java.util;
   
   import java.util.function.Consumer;
   import java.util.function.Predicate;
   import jdk.internal.misc.SharedSecrets;
   
   /**
    * An unbounded priority {@linkplain Queue queue} based on a priority heap.
    * The elements of the priority queue are ordered according to their
    * {@linkplain Comparable natural ordering}, or by a {@link Comparator}
    * provided at queue construction time, depending on which constructor is
    * used.  A priority queue does not permit {@code null} elements.
    * A priority queue relying on natural ordering also does not permit
    * insertion of non-comparable objects (doing so may result in
    * {@code ClassCastException}).
    *
    * <p>The <em>head</em> of this queue is the <em>least</em> element
    * with respect to the specified ordering.  If multiple elements are
    * tied for least value, the head is one of those elements -- ties are
    * broken arbitrarily.  The queue retrieval operations {@code poll},
    * {@code remove}, {@code peek}, and {@code element} access the
    * element at the head of the queue.
    *
    * <p>A priority queue is unbounded, but has an internal
    * <i>capacity</i> governing the size of an array used to store the
    * elements on the queue.  It is always at least as large as the queue
    * size.  As elements are added to a priority queue, its capacity
    * grows automatically.  The details of the growth policy are not
    * specified.
    *
    * <p>This class and its iterator implement all of the
    * <em>optional</em> methods of the {@link Collection} and {@link
    * Iterator} interfaces.  The Iterator provided in method {@link
    * #iterator()} and the Spliterator provided in method {@link #spliterator()}
    * are <em>not</em> guaranteed to traverse the elements of
    * the priority queue in any particular order. If you need ordered
    * traversal, consider using {@code Arrays.sort(pq.toArray())}.
    *
    * <p><strong>Note that this implementation is not synchronized.</strong>
    * Multiple threads should not access a {@code PriorityQueue}
    * instance concurrently if any of the threads modifies the queue.
    * Instead, use the thread-safe {@link
    * java.util.concurrent.PriorityBlockingQueue} class.
    *
    * <p>Implementation note: this implementation provides
    * O(log(n)) time for the enqueuing and dequeuing methods
    * ({@code offer}, {@code poll}, {@code remove()} and {@code add});
    * linear time for the {@code remove(Object)} and {@code contains(Object)}
    * methods; and constant time for the retrieval methods
    * ({@code peek}, {@code element}, and {@code size}).
    *
    * <p>This class is a member of the
    * <a href="{@docRoot}/java.base/java/util/package-summary.html#CollectionsFramework">
    * Java Collections Framework</a>.
    *
    * @since 1.5
    * @author Josh Bloch, Doug Lea
    * @param <E> the type of elements held in this queue
    */
   @SuppressWarnings("unchecked")
   public class PriorityQueue<E> extends AbstractQueue<E>
       implements java.io.Serializable {
   
       private static final long serialVersionUID = -7720805057305804111L;
   
       private static final int DEFAULT_INITIAL_CAPACITY = 11;
   
       /**
        * Priority queue represented as a balanced binary heap: the two
        * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
        * priority queue is ordered by comparator, or by the elements'
        * natural ordering, if comparator is null: For each node n in the
        * heap and each descendant d of n, n <= d.  The element with the
        * lowest value is in queue[0], assuming the queue is nonempty.
        */
       transient Object[] queue; // non-private to simplify nested class access
   
       /**
        * The number of elements in the priority queue.
        */
       int size;
   
       /**
        * The comparator, or null if priority queue uses elements'
        * natural ordering.
        */
       private final Comparator<? super E> comparator;
   
       /**
        * The number of times this priority queue has been
        * <i>structurally modified</i>.  See AbstractList for gory details.
        */
       transient int modCount;     // non-private to simplify nested class access
   
       /**
        * Creates a {@code PriorityQueue} with the default initial
        * capacity (11) that orders its elements according to their
        * {@linkplain Comparable natural ordering}.
        */
       public PriorityQueue() {
           this(DEFAULT_INITIAL_CAPACITY, null);
       }
   
       /**
        * Creates a {@code PriorityQueue} with the specified initial
        * capacity that orders its elements according to their
        * {@linkplain Comparable natural ordering}.
        *
        * @param initialCapacity the initial capacity for this priority queue
        * @throws IllegalArgumentException if {@code initialCapacity} is less
        *         than 1
        */
       public PriorityQueue(int initialCapacity) {
           this(initialCapacity, null);
       }
   
       /**
        * Creates a {@code PriorityQueue} with the default initial capacity and
        * whose elements are ordered according to the specified comparator.
        *
        * @param  comparator the comparator that will be used to order this
        *         priority queue.  If {@code null}, the {@linkplain Comparable
        *         natural ordering} of the elements will be used.
        * @since 1.8
        */
       public PriorityQueue(Comparator<? super E> comparator) {
           this(DEFAULT_INITIAL_CAPACITY, comparator);
       }
   
       /**
        * Creates a {@code PriorityQueue} with the specified initial capacity
        * that orders its elements according to the specified comparator.
        *
        * @param  initialCapacity the initial capacity for this priority queue
        * @param  comparator the comparator that will be used to order this
        *         priority queue.  If {@code null}, the {@linkplain Comparable
        *         natural ordering} of the elements will be used.
        * @throws IllegalArgumentException if {@code initialCapacity} is
        *         less than 1
        */
       public PriorityQueue(int initialCapacity,
                            Comparator<? super E> comparator) {
           // Note: This restriction of at least one is not actually needed,
           // but continues for 1.5 compatibility
           if (initialCapacity < 1)
               throw new IllegalArgumentException();
           this.queue = new Object[initialCapacity];
           this.comparator = comparator;
       }
   
       /**
        * Creates a {@code PriorityQueue} containing the elements in the
        * specified collection.  If the specified collection is an instance of
        * a {@link SortedSet} or is another {@code PriorityQueue}, this
        * priority queue will be ordered according to the same ordering.
        * Otherwise, this priority queue will be ordered according to the
        * {@linkplain Comparable natural ordering} of its elements.
        *
        * @param  c the collection whose elements are to be placed
        *         into this priority queue
        * @throws ClassCastException if elements of the specified collection
        *         cannot be compared to one another according to the priority
        *         queue's ordering
        * @throws NullPointerException if the specified collection or any
        *         of its elements are null
        */
       public PriorityQueue(Collection<? extends E> c) {
           if (c instanceof SortedSet<?>) {
               SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
               this.comparator = (Comparator<? super E>) ss.comparator();
               initElementsFromCollection(ss);
           }
           else if (c instanceof PriorityQueue<?>) {
               PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
               this.comparator = (Comparator<? super E>) pq.comparator();
               initFromPriorityQueue(pq);
           }
           else {
               this.comparator = null;
               initFromCollection(c);
           }
       }
   
       /**
        * Creates a {@code PriorityQueue} containing the elements in the
        * specified priority queue.  This priority queue will be
        * ordered according to the same ordering as the given priority
        * queue.
        *
        * @param  c the priority queue whose elements are to be placed
        *         into this priority queue
        * @throws ClassCastException if elements of {@code c} cannot be
        *         compared to one another according to {@code c}'s
        *         ordering
        * @throws NullPointerException if the specified priority queue or any
        *         of its elements are null
        */
       public PriorityQueue(PriorityQueue<? extends E> c) {
           this.comparator = (Comparator<? super E>) c.comparator();
           initFromPriorityQueue(c);
       }
   
       /**
        * Creates a {@code PriorityQueue} containing the elements in the
        * specified sorted set.   This priority queue will be ordered
        * according to the same ordering as the given sorted set.
        *
        * @param  c the sorted set whose elements are to be placed
        *         into this priority queue
        * @throws ClassCastException if elements of the specified sorted
        *         set cannot be compared to one another according to the
        *         sorted set's ordering
        * @throws NullPointerException if the specified sorted set or any
        *         of its elements are null
        */
       public PriorityQueue(SortedSet<? extends E> c) {
           this.comparator = (Comparator<? super E>) c.comparator();
           initElementsFromCollection(c);
       }
   
       /** Ensures that queue[0] exists, helping peek() and poll(). */
       private static Object[] ensureNonEmpty(Object[] es) {
           return (es.length > 0) ? es : new Object[1];
       }
   
       private void initFromPriorityQueue(PriorityQueue<? extends E> c) {
           if (c.getClass() == PriorityQueue.class) {
               this.queue = ensureNonEmpty(c.toArray());
               this.size = c.size();
           } else {
               initFromCollection(c);
           }
       }
   
       private void initElementsFromCollection(Collection<? extends E> c) {
           Object[] es = c.toArray();
           int len = es.length;
           // If c.toArray incorrectly doesn't return Object[], copy it.
           if (es.getClass() != Object[].class)
               es = Arrays.copyOf(es, len, Object[].class);
           if (len == 1 || this.comparator != null)
               for (Object e : es)
                   if (e == null)
                       throw new NullPointerException();
           this.queue = ensureNonEmpty(es);
           this.size = len;
       }
   
       /**
        * Initializes queue array with elements from the given Collection.
        *
        * @param c the collection
        */
       private void initFromCollection(Collection<? extends E> c) {
           initElementsFromCollection(c);
           heapify();
       }
   
       /**
        * The maximum size of array to allocate.
        * Some VMs reserve some header words in an array.
        * Attempts to allocate larger arrays may result in
        * OutOfMemoryError: Requested array size exceeds VM limit
        */
       private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
   
       /**
        * Increases the capacity of the array.
        *
        * @param minCapacity the desired minimum capacity
        */
       private void grow(int minCapacity) {
           int oldCapacity = queue.length;
           // Double size if small; else grow by 50%
           int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                            (oldCapacity + 2) :
                                            (oldCapacity >> 1));
           // overflow-conscious code
           if (newCapacity - MAX_ARRAY_SIZE > 0)
               newCapacity = hugeCapacity(minCapacity);
           queue = Arrays.copyOf(queue, newCapacity);
       }
   
       private static int hugeCapacity(int minCapacity) {
           if (minCapacity < 0) // overflow
               throw new OutOfMemoryError();
           return (minCapacity > MAX_ARRAY_SIZE) ?
               Integer.MAX_VALUE :
               MAX_ARRAY_SIZE;
       }
   
       /**
        * Inserts the specified element into this priority queue.
        *
        * @return {@code true} (as specified by {@link Collection#add})
        * @throws ClassCastException if the specified element cannot be
        *         compared with elements currently in this priority queue
        *         according to the priority queue's ordering
        * @throws NullPointerException if the specified element is null
        */
       public boolean add(E e) {
           return offer(e);
       }
   
       /**
        * Inserts the specified element into this priority queue.
        *
        * @return {@code true} (as specified by {@link Queue#offer})
        * @throws ClassCastException if the specified element cannot be
        *         compared with elements currently in this priority queue
        *         according to the priority queue's ordering
        * @throws NullPointerException if the specified element is null
        */
       public boolean offer(E e) {
           if (e == null)
               throw new NullPointerException();
           modCount++;
           int i = size;
           if (i >= queue.length)
               grow(i + 1);
           siftUp(i, e);
           size = i + 1;
           return true;
       }
   
       public E peek() {
           return (E) queue[0];
       }
   
       private int indexOf(Object o) {
           if (o != null) {
               final Object[] es = queue;
               for (int i = 0, n = size; i < n; i++)
                   if (o.equals(es[i]))
                       return i;
           }
           return -1;
       }
   
       /**
        * Removes a single instance of the specified element from this queue,
        * if it is present.  More formally, removes an element {@code e} such
        * that {@code o.equals(e)}, if this queue contains one or more such
        * elements.  Returns {@code true} if and only if this queue contained
        * the specified element (or equivalently, if this queue changed as a
        * result of the call).
        *
        * @param o element to be removed from this queue, if present
        * @return {@code true} if this queue changed as a result of the call
        */
       public boolean remove(Object o) {
           int i = indexOf(o);
           if (i == -1)
               return false;
           else {
               removeAt(i);
               return true;
           }
       }
   
       /**
        * Identity-based version for use in Itr.remove.
        *
        * @param o element to be removed from this queue, if present
        */
       void removeEq(Object o) {
           final Object[] es = queue;
           for (int i = 0, n = size; i < n; i++) {
               if (o == es[i]) {
                   removeAt(i);
                   break;
               }
           }
       }
   
       /**
        * Returns {@code true} if this queue contains the specified element.
        * More formally, returns {@code true} if and only if this queue contains
        * at least one element {@code e} such that {@code o.equals(e)}.
        *
        * @param o object to be checked for containment in this queue
        * @return {@code true} if this queue contains the specified element
        */
       public boolean contains(Object o) {
           return indexOf(o) >= 0;
       }
   
       /**
        * Returns an array containing all of the elements in this queue.
        * The elements are in no particular order.
        *
        * <p>The returned array will be "safe" in that no references to it are
        * maintained by this queue.  (In other words, this method must allocate
        * a new array).  The caller is thus free to modify the returned array.
        *
        * <p>This method acts as bridge between array-based and collection-based
        * APIs.
        *
        * @return an array containing all of the elements in this queue
        */
       public Object[] toArray() {
           return Arrays.copyOf(queue, size);
       }
   
       /**
        * Returns an array containing all of the elements in this queue; the
        * runtime type of the returned array is that of the specified array.
        * The returned array elements are in no particular order.
        * If the queue fits in the specified array, it is returned therein.
        * Otherwise, a new array is allocated with the runtime type of the
        * specified array and the size of this queue.
        *
        * <p>If the queue fits in the specified array with room to spare
        * (i.e., the array has more elements than the queue), the element in
        * the array immediately following the end of the collection is set to
        * {@code null}.
        *
        * <p>Like the {@link #toArray()} method, this method acts as bridge between
        * array-based and collection-based APIs.  Further, this method allows
        * precise control over the runtime type of the output array, and may,
        * under certain circumstances, be used to save allocation costs.
        *
        * <p>Suppose {@code x} is a queue known to contain only strings.
        * The following code can be used to dump the queue into a newly
        * allocated array of {@code String}:
        *
        * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
        *
        * Note that {@code toArray(new Object[0])} is identical in function to
        * {@code toArray()}.
        *
        * @param a the array into which the elements of the queue are to
        *          be stored, if it is big enough; otherwise, a new array of the
        *          same runtime type is allocated for this purpose.
        * @return an array containing all of the elements in this queue
        * @throws ArrayStoreException if the runtime type of the specified array
        *         is not a supertype of the runtime type of every element in
        *         this queue
        * @throws NullPointerException if the specified array is null
        */
       public <T> T[] toArray(T[] a) {
           final int size = this.size;
           if (a.length < size)
               // Make a new array of a's runtime type, but my contents:
               return (T[]) Arrays.copyOf(queue, size, a.getClass());
           System.arraycopy(queue, 0, a, 0, size);
           if (a.length > size)
               a[size] = null;
           return a;
       }
   
       /**
        * Returns an iterator over the elements in this queue. The iterator
        * does not return the elements in any particular order.
        *
        * @return an iterator over the elements in this queue
        */
       public Iterator<E> iterator() {
           return new Itr();
       }
   
       private final class Itr implements Iterator<E> {
           /**
            * Index (into queue array) of element to be returned by
            * subsequent call to next.
            */
           private int cursor;
   
           /**
            * Index of element returned by most recent call to next,
            * unless that element came from the forgetMeNot list.
            * Set to -1 if element is deleted by a call to remove.
            */
           private int lastRet = -1;
   
           /**
            * A queue of elements that were moved from the unvisited portion of
            * the heap into the visited portion as a result of "unlucky" element
            * removals during the iteration.  (Unlucky element removals are those
            * that require a siftup instead of a siftdown.)  We must visit all of
            * the elements in this list to complete the iteration.  We do this
            * after we've completed the "normal" iteration.
            *
            * We expect that most iterations, even those involving removals,
            * will not need to store elements in this field.
            */
           private ArrayDeque<E> forgetMeNot;
   
           /**
            * Element returned by the most recent call to next iff that
            * element was drawn from the forgetMeNot list.
            */
           private E lastRetElt;
   
           /**
            * The modCount value that the iterator believes that the backing
            * Queue should have.  If this expectation is violated, the iterator
            * has detected concurrent modification.
            */
           private int expectedModCount = modCount;
   
           Itr() {}                        // prevent access constructor creation
   
           public boolean hasNext() {
               return cursor < size ||
                   (forgetMeNot != null && !forgetMeNot.isEmpty());
           }
   
           public E next() {
               if (expectedModCount != modCount)
                   throw new ConcurrentModificationException();
               if (cursor < size)
                   return (E) queue[lastRet = cursor++];
               if (forgetMeNot != null) {
                   lastRet = -1;
                   lastRetElt = forgetMeNot.poll();
                   if (lastRetElt != null)
                       return lastRetElt;
               }
               throw new NoSuchElementException();
           }
   
           public void remove() {
               if (expectedModCount != modCount)
                   throw new ConcurrentModificationException();
               if (lastRet != -1) {
                   E moved = PriorityQueue.this.removeAt(lastRet);
                   lastRet = -1;
                   if (moved == null)
                       cursor--;
                   else {
                       if (forgetMeNot == null)
                           forgetMeNot = new ArrayDeque<>();
                       forgetMeNot.add(moved);
                   }
               } else if (lastRetElt != null) {
                   PriorityQueue.this.removeEq(lastRetElt);
                   lastRetElt = null;
               } else {
                   throw new IllegalStateException();
               }
               expectedModCount = modCount;
           }
       }
   
       public int size() {
           return size;
       }
   
       /**
        * Removes all of the elements from this priority queue.
        * The queue will be empty after this call returns.
        */
       public void clear() {
           modCount++;
           final Object[] es = queue;
           for (int i = 0, n = size; i < n; i++)
               es[i] = null;
           size = 0;
       }
   
       public E poll() {
           final Object[] es;
           final E result;
   
           if ((result = (E) ((es = queue)[0])) != null) {
               modCount++;
               final int n;
               final E x = (E) es[(n = --size)];
               es[n] = null;
               if (n > 0) {
                   final Comparator<? super E> cmp;
                   if ((cmp = comparator) == null)
                       siftDownComparable(0, x, es, n);
                   else
                       siftDownUsingComparator(0, x, es, n, cmp);
               }
           }
           return result;
       }
   
       /**
        * Removes the ith element from queue.
        *
        * Normally this method leaves the elements at up to i-1,
        * inclusive, untouched.  Under these circumstances, it returns
        * null.  Occasionally, in order to maintain the heap invariant,
        * it must swap a later element of the list with one earlier than
        * i.  Under these circumstances, this method returns the element
        * that was previously at the end of the list and is now at some
        * position before i. This fact is used by iterator.remove so as to
        * avoid missing traversing elements.
        */
       E removeAt(int i) {
           // assert i >= 0 && i < size;
           final Object[] es = queue;
           modCount++;
           int s = --size;
           if (s == i) // removed last element
               es[i] = null;
           else {
               E moved = (E) es[s];
               es[s] = null;
               siftDown(i, moved);
               if (es[i] == moved) {
                   siftUp(i, moved);
                   if (es[i] != moved)
                       return moved;
               }
           }
           return null;
       }
   
       /**
        * Inserts item x at position k, maintaining heap invariant by
        * promoting x up the tree until it is greater than or equal to
        * its parent, or is the root.
        *
        * To simplify and speed up coercions and comparisons, the
        * Comparable and Comparator versions are separated into different
        * methods that are otherwise identical. (Similarly for siftDown.)
        *
        * @param k the position to fill
        * @param x the item to insert
        */
       private void siftUp(int k, E x) {
           if (comparator != null)
               siftUpUsingComparator(k, x, queue, comparator);
           else
               siftUpComparable(k, x, queue);
       }
   
       private static <T> void siftUpComparable(int k, T x, Object[] es) {
           Comparable<? super T> key = (Comparable<? super T>) x;
           while (k > 0) {
               int parent = (k - 1) >>> 1;
               Object e = es[parent];
               if (key.compareTo((T) e) >= 0)
                   break;
               es[k] = e;
               k = parent;
           }
           es[k] = key;
       }
   
       private static <T> void siftUpUsingComparator(
           int k, T x, Object[] es, Comparator<? super T> cmp) {
           while (k > 0) {
               int parent = (k - 1) >>> 1;
               Object e = es[parent];
               if (cmp.compare(x, (T) e) >= 0)
                   break;
               es[k] = e;
               k = parent;
           }
           es[k] = x;
       }
   
       /**
        * Inserts item x at position k, maintaining heap invariant by
        * demoting x down the tree repeatedly until it is less than or
        * equal to its children or is a leaf.
        *
        * @param k the position to fill
        * @param x the item to insert
        */
       private void siftDown(int k, E x) {
           if (comparator != null)
               siftDownUsingComparator(k, x, queue, size, comparator);
           else
               siftDownComparable(k, x, queue, size);
       }
   
       private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
           // assert n > 0;
           Comparable<? super T> key = (Comparable<? super T>)x;
           int half = n >>> 1;           // loop while a non-leaf
           while (k < half) {
               int child = (k << 1) + 1; // assume left child is least
               Object c = es[child];
               int right = child + 1;
               if (right < n &&
                   ((Comparable<? super T>) c).compareTo((T) es[right]) > 0)
                   c = es[child = right];
               if (key.compareTo((T) c) <= 0)
                   break;
               es[k] = c;
               k = child;
           }
           es[k] = key;
       }
   
       private static <T> void siftDownUsingComparator(
           int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
           // assert n > 0;
           int half = n >>> 1;
           while (k < half) {
               int child = (k << 1) + 1;
               Object c = es[child];
               int right = child + 1;
               if (right < n && cmp.compare((T) c, (T) es[right]) > 0)
                   c = es[child = right];
               if (cmp.compare(x, (T) c) <= 0)
                   break;
               es[k] = c;
               k = child;
           }
           es[k] = x;
       }
   
       /**
        * Establishes the heap invariant (described above) in the entire tree,
        * assuming nothing about the order of the elements prior to the call.
        * This classic algorithm due to Floyd (1964) is known to be O(size).
        */
       private void heapify() {
           final Object[] es = queue;
           int n = size, i = (n >>> 1) - 1;
           final Comparator<? super E> cmp;
           if ((cmp = comparator) == null)
               for (; i >= 0; i--)
                   siftDownComparable(i, (E) es[i], es, n);
           else
               for (; i >= 0; i--)
                   siftDownUsingComparator(i, (E) es[i], es, n, cmp);
       }
   
       /**
        * Returns the comparator used to order the elements in this
        * queue, or {@code null} if this queue is sorted according to
        * the {@linkplain Comparable natural ordering} of its elements.
        *
        * @return the comparator used to order this queue, or
        *         {@code null} if this queue is sorted according to the
        *         natural ordering of its elements
        */
       public Comparator<? super E> comparator() {
           return comparator;
       }
   
       /**
        * Saves this queue to a stream (that is, serializes it).
        *
        * @param s the stream
        * @throws java.io.IOException if an I/O error occurs
        * @serialData The length of the array backing the instance is
        *             emitted (int), followed by all of its elements
        *             (each an {@code Object}) in the proper order.
        */
       private void writeObject(java.io.ObjectOutputStream s)
           throws java.io.IOException {
           // Write out element count, and any hidden stuff
           s.defaultWriteObject();
   
           // Write out array length, for compatibility with 1.5 version
           s.writeInt(Math.max(2, size + 1));
   
           // Write out all elements in the "proper order".
           final Object[] es = queue;
           for (int i = 0, n = size; i < n; i++)
               s.writeObject(es[i]);
       }
   
       /**
        * Reconstitutes the {@code PriorityQueue} instance from a stream
        * (that is, deserializes it).
        *
        * @param s the stream
        * @throws ClassNotFoundException if the class of a serialized object
        *         could not be found
        * @throws java.io.IOException if an I/O error occurs
        */
       private void readObject(java.io.ObjectInputStream s)
           throws java.io.IOException, ClassNotFoundException {
           // Read in size, and any hidden stuff
           s.defaultReadObject();
   
           // Read in (and discard) array length
           s.readInt();
   
           SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s, Object[].class, size);
           final Object[] es = queue = new Object[Math.max(size, 1)];
   
           // Read in all elements.
           for (int i = 0, n = size; i < n; i++)
               es[i] = s.readObject();
   
           // Elements are guaranteed to be in "proper order", but the
           // spec has never explained what that might be.
           heapify();
       }
   
       /**
        * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
        * and <em>fail-fast</em> {@link Spliterator} over the elements in this
        * queue. The spliterator does not traverse elements in any particular order
        * (the {@link Spliterator#ORDERED ORDERED} characteristic is not reported).
        *
        * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
        * {@link Spliterator#SUBSIZED}, and {@link Spliterator#NONNULL}.
        * Overriding implementations should document the reporting of additional
        * characteristic values.
        *
        * @return a {@code Spliterator} over the elements in this queue
        * @since 1.8
        */
       public final Spliterator<E> spliterator() {
           return new PriorityQueueSpliterator(0, -1, 0);
       }
   
       final class PriorityQueueSpliterator implements Spliterator<E> {
           private int index;            // current index, modified on advance/split
           private int fence;            // -1 until first use
           private int expectedModCount; // initialized when fence set
   
           /** Creates new spliterator covering the given range. */
           PriorityQueueSpliterator(int origin, int fence, int expectedModCount) {
               this.index = origin;
               this.fence = fence;
               this.expectedModCount = expectedModCount;
           }
   
           private int getFence() { // initialize fence to size on first use
               int hi;
               if ((hi = fence) < 0) {
                   expectedModCount = modCount;
                   hi = fence = size;
               }
               return hi;
           }
   
           public PriorityQueueSpliterator trySplit() {
               int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
               return (lo >= mid) ? null :
                   new PriorityQueueSpliterator(lo, index = mid, expectedModCount);
           }
   
           public void forEachRemaining(Consumer<? super E> action) {
               if (action == null)
                   throw new NullPointerException();
               if (fence < 0) { fence = size; expectedModCount = modCount; }
               final Object[] es = queue;
               int i, hi; E e;
               for (i = index, index = hi = fence; i < hi; i++) {
                   if ((e = (E) es[i]) == null)
                       break;      // must be CME
                   action.accept(e);
               }
               if (modCount != expectedModCount)
                   throw new ConcurrentModificationException();
           }
   
           public boolean tryAdvance(Consumer<? super E> action) {
               if (action == null)
                   throw new NullPointerException();
               if (fence < 0) { fence = size; expectedModCount = modCount; }
               int i;
               if ((i = index) < fence) {
                   index = i + 1;
                   E e;
                   if ((e = (E) queue[i]) == null
                       || modCount != expectedModCount)
                       throw new ConcurrentModificationException();
                   action.accept(e);
                   return true;
               }
               return false;
           }
   
           public long estimateSize() {
               return getFence() - index;
           }
   
           public int characteristics() {
               return Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.NONNULL;
           }
       }
   
       /**
        * @throws NullPointerException {@inheritDoc}
        */
       public boolean removeIf(Predicate<? super E> filter) {
           Objects.requireNonNull(filter);
           return bulkRemove(filter);
       }
   
       /**
        * @throws NullPointerException {@inheritDoc}
        */
       public boolean removeAll(Collection<?> c) {
           Objects.requireNonNull(c);
           return bulkRemove(e -> c.contains(e));
       }
   
       /**
        * @throws NullPointerException {@inheritDoc}
        */
       public boolean retainAll(Collection<?> c) {
           Objects.requireNonNull(c);
           return bulkRemove(e -> !c.contains(e));
       }
   
       // A tiny bit set implementation
   
       private static long[] nBits(int n) {
           return new long[((n - 1) >> 6) + 1];
       }
       private static void setBit(long[] bits, int i) {
           bits[i >> 6] |= 1L << i;
       }
       private static boolean isClear(long[] bits, int i) {
           return (bits[i >> 6] & (1L << i)) == 0;
       }
   
       /** Implementation of bulk remove methods. */
       private boolean bulkRemove(Predicate<? super E> filter) {
           final int expectedModCount = ++modCount;
           final Object[] es = queue;
           final int end = size;
           int i;
           // Optimize for initial run of survivors
           for (i = 0; i < end && !filter.test((E) es[i]); i++)
               ;
           if (i >= end) {
               if (modCount != expectedModCount)
                   throw new ConcurrentModificationException();
               return false;
           }
           // Tolerate predicates that reentrantly access the collection for
           // read (but writers still get CME), so traverse once to find
           // elements to delete, a second pass to physically expunge.
           final int beg = i;
           final long[] deathRow = nBits(end - beg);
           deathRow[0] = 1L;   // set bit 0
           for (i = beg + 1; i < end; i++)
               if (filter.test((E) es[i]))
                   setBit(deathRow, i - beg);
           if (modCount != expectedModCount)
               throw new ConcurrentModificationException();
           int w = beg;
           for (i = beg; i < end; i++)
               if (isClear(deathRow, i - beg))
                   es[w++] = es[i];
           for (i = size = w; i < end; i++)
               es[i] = null;
           heapify();
           return true;
       }
   
       /**
        * @throws NullPointerException {@inheritDoc}
        */
       public void forEach(Consumer<? super E> action) {
           Objects.requireNonNull(action);
           final int expectedModCount = modCount;
           final Object[] es = queue;
           for (int i = 0, n = size; i < n; i++)
               action.accept((E) es[i]);
           if (expectedModCount != modCount)
               throw new ConcurrentModificationException();
       }
   }

```