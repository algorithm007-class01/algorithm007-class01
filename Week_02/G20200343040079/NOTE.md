学习笔记

## Java源码解读: Stack、Queue、PriorityQueue
### 1. Stack类
Stack类继承自Vector, 底层是用数组实现伸缩
提供的接口方法有:  
    push(), pop(), peek(), empty(), search()等
底层使用的基类方法有:  
    addElement(), removeElementAt(), elementAt(), lastIndexOf()等
    
感受: 类之间的继承关系, 使层次非常清晰, 代码复用性很强, Java源码实现清晰易懂。

### 2. Queue interface
Queue在Java里面被定义为抽象接口, 继承自Collection
定义的接口主要有: add(), offer(), remove(), pool(), element(), peek()等

### 3. PriorityQueue类
继承自抽象队列类AbstractQueue, 而AbstractQueue又实现了Queue的接口
通过用数据表示的小顶堆实现优先级队列
无边界的优先级队列, 线程不安全
添加的对象必需可比较
重点函数和方法有: grow(), add(), offer(), indexOf(), remove(), removeEq(), contains(), removeAt()等
其他重要函数有: siftUp(), siftDown()

