1. add first 或 add last 这套新的 API 改写 Deque 的代码

Deque<String> deque = new LinkedList<String>();
deque.addfFirst("a");
deque.addfFirst("b");
deque.addfFirst("c");
System.out.println(deque);
String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.removeFirst());
}
System.out.println(deque);

2.Queue Priority Queue源码分析
2.1.Java中Queue接口方法
六个：
a:add(E e):添加一个元素
b:remove():删除一个元素
c:offer(E e):添加一个元素
d:poll(E e):删除一个元素
f: element() ：查看最上一个元素
h:peek():查看最上一个元素

2.2 priorityQueue类比较简单，是借助于“二叉堆”来实现的，此类的所有操作基本就是一个“二叉堆”的相关操作的实现

3.HashMap总结
HashMap采用数组+链表的结构实现entry的存储。在1.8之后会根据一定的阈值将链表转化为红黑树，以提高效率
图片: https://uploader.shimo.im/f/At05w6l40iY6MHHN.png
haspmap的取值过程

get操作和put操作基本类似，只不过一个是取一个是存。在取值的过程中先判断hash数组table是否为空，不为空，则通过hash值计算索引判断要获取的是否是hash数组里的节点（就是头节点），如果是，则返回，如果不是则遍历链表（或者红黑树）直到找到该节点。

hashmap的删除过程

删除和存取十分类似，不再赘述。

hashmap的同步

hashmap不是同步的，不能直接用于多线程中。我们可以手动的在put、remove和replace等可能引起modCount改变的操作上加上synchronized来同步（或者采用加锁的方式）。

或者使用Collections.synchronizedMap(map)来获取一个同步的map。

哈希冲突的解决方法

1.开放定址法（线性探测再散列，二次探测再散列，伪随机探测再散列）

2.再哈希法

3.链地址法(比如hashmap)

4.建立一个公共溢出区
链接：https://blog.csdn.net/wxgxgp/article/details/79242390

