#### XOR-异或
异或：相同为0，不同为1

异或操作特点
x ^ 0 = x
x ^ 1s = ~x //1s = ~0(全1)
x ^ (~x) = 1s
x ^ x = 0

#### 指定位置的位运算
1. 将 x 最右边的 n 位清零：x & (~0 << n)
2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
3. 获取 x 的第 n 位的幂值：x & (1 << (n -1))
4. 仅将第 n 位置为 1：x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)
7. 将第 n 位至第 0 位（含）清零：x & (~ ((1 << (n + 1)) - 1))

#### 实战位运算要点
* 判断奇偶：  
x % 2 == 1 —> (x & 1) == 1  
x % 2 == 0 —> (x & 1) == 0
* x >> 1 —> x / 2  
即： x = x / 2; —> x = x >> 1;  
mid = (left + right) / 2; —> mid = (left + right) >> 1;
* X = X & (X-1) 清零最低位的 1
* X & -X => 得到最低位的 1
* X & ~X => 0

[如何从十进制转换为二进制](https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6)

#### Bloom Filter vs Hash Table
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

**优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。**

#### LRU Cache
* 两个要素： 大小 、替换策略
* Hash Table + Double LinkedList
* O(1) 查询
* O(1) 修改、更新

[布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)  
[使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)  
[布隆过滤器 Java 实现示例 1](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)  
[布隆过滤器 Java 实现示例 2](https://github.com/Baqend/Orestes-Bloomfilter)  
[Understanding the Meltdown exploit](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)  
[替换算法总揽](https://en.wikipedia.org/wiki/Cache_replacement_policies)  

#### 排序算法
1. 比较类排序：
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破
O(nlogn)，因此也称为非线性时间比较类排序。
2. 非比较类排序：
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时
间下界，以线性时间运行，因此也称为线性时间非比较类排序。

**重点掌握nlogn复杂度的算法**
* 堆排序
* 快速排序
* 归并排序

[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)  
[快速排序代码示例](https://shimo.im/docs/98KjvGwwGpTpYGKy/read)  
[归并排序代码示例](https://shimo.im/docs/YqgG6vtdKwkXJkWx/read)  
[堆排序代码示例](https://shimo.im/docs/6kRVHRphpgjHgCtx/read)  
[9 种经典排序算法可视化动画](https://www.bilibili.com/video/av25136272)  
[6 分钟看完 15 种排序算法动画展示](https://www.bilibili.com/video/av63851336)  