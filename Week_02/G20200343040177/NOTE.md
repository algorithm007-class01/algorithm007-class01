学习笔记
stack源码

T push(T item ) when growing the stack,use the Vector routines in case more memory is needed
                            Note: spec indicates that this method  *always* returns obj passed in !

synchronized T pop() Pops an item from the stack an returns it. The item popped is removed from                          
                                     the stack

synchronized T Peek() Returns the top object on the stack without remove it

synchronized boolean empty() Tests if the stack is empty.

synchronized int search(Object o) Returns the position of an object on the stack,with the top most  
                                                          Object being at position 1, and each Object deeper in the stack at depth + 1 O(n)

PriorityQueue 源码

boolean add(E e) Inserts the specified  element into this priority queue
void clear() Removes all of the elements from this priority queue
Comparator<? super E> comparator() returns the comparator used to order the elements in 
this queue,or null if this queue is sorted according to the natural ordering of its elements
boolean  contains(Object o) returns true if this queue contains the specified element
Iterator<E> iterator() returns an iterator over the element in this queue
boolean offer(E e) inserts the specified element into this priority queue
boolean remove(Object o) Removes a single instance of the specified element from this queue,if it is present
Spliterator<E> spilterator() Creates a late-binding and fail-fast Spliterator over the elements in this queue

Object[] toArray() returns an array containing all of the elements in this queue
<T> T[] toArray(T[] a) returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array

Queue 源码

今天看Queue源码 有3个基本属性
1 int n   number of elements on queue
2 Node first    beginning of queue 
3 Node last end of queue 

method :
boolean isEmpty()   returns ture if this queue is empty
int length() returns the number of items in this queue
Item peek() returns the item least recently added to this queue
enqueue(Item item) add the item to the queue
Item dequeue() removes and returns the item on this queue that was  least recently






