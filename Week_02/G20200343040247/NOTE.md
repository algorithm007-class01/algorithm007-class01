学习笔记
用add first或add last这套新的API改写Deque的代码
分析Queue和Priority Queue的源码
写一个关于HashMap的小总结
说明：对于不熟悉Java语言的同学，此项作业可选做。
请大家将HashMap的小总结放在本周学习总结中一并提交

1.HashMap

Map 是 Key-Value 对映射的抽象接口，该映射不包括重复的键，即一个键对应一个值。HashMap 是 Java Collection Framework 的重要成员，也是Map族(如下图所示)中我们最为常用的一种。简单地说，HashMap 是基于哈希表的 Map 接口的实现，以 Key-Value 的形式存在，即存储的对象是 Entry (同时包含了 Key 和 Value) 。

利用 js Map  key唯一性   记录某一项出现的频次或者是否包含某个 item  是一个不错的选择。查询时间复杂度 O(1).效率高。

2.Stack和 Queue
   Stack：先入后出；添加、删除皆为 O(1) 
   Queue：先入先出；添加、删除皆为 O(1)
3.Deque
   .简单理解：两端可以进出的 Queue Deque - double ended queue 
   .插入和删除都是 O(1) 操作

