# 学习笔记
## 1. 位运算
- 位运算
    - 左移
    - 右移
    - 按位与
    - 按位或
    - 按位取反
    - 按位异或
- 算数移位与逻辑移位
- 位运算的应用
## 2. 布隆过滤器
- 一种可以用来检查值是"可能在集合中"还是“绝对不在集合中”的数据结构
- 原理
    - 使用多个哈希函数计算元素，将二进制位集合中相应位置1来判断相应元素是否存在
- 优点
    - 空间效率和查询时间都远远超过一般的算法
- 缺点
    - 有一定的误识别率和删除困难
``` python
from bitarray import bitarray
import mmh3

class BloomFilter:
    # hash_num 代表一个元素会被分到几个二进制位
    def __init__(self, size, hash_num):
        self.size = size
        self.hash_num = hash_num
        self.bit_array = bitarray(size)
        self.bit_array.setall(0)

    def add(self, s):
        for seed in range(self.hash_num):
            result = mmh3.hash(s, seed) % self.size
            self.bit_array[result] = 1
    
    def lookup(self, s):
        for seed in range(self.hash_num):
            result = mmh3.hash(s, seed) % self.size
            if self.bit_array[result] == 0:
                return "Nope"
            return "Probably"

# 示例
bf = BloomFilter(500000, 7)
bf.add("dantezhao")
print(bf.lookup("dantezhao"))
print(bf.lookup("yyj"))
```
## 3. LRUCache
- Cache 
    - 解决速度不匹配问题，提高数据读取性能的技术
    - CPU缓存、数据库缓存、浏览器缓存
- LRU缓存
    - 大小
    - 替换策略
        - 当缓存被用满时，哪些灵气应该被清理出去，哪些数据应该被保留
        - LRU
            - 把最近最少使用的替换出去
    - 查询、修改、更新复杂度
        - O(1)
## 4. 排序
### 4.1 比较类排序
- 通过比较来决定元素间的相对次序，最优O(nlogn)
- 交换排序
    - 冒泡排序
        - 嵌套循环，每次查看相邻的元素如果逆序，则交换
        - O(n^2), O(n^2), O(n), O(1), 稳定
    - 快速排序
        - 数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的子数组继续快排，以达到整个序列有序
        - O(nlog2n), O(n^2), O(nlog2n), O(nlog2n), 不稳定
- 插入排序
    - 简单插入排序
        - 从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
        - O(n^2), O(n^2), O(n), O(1), 稳定
    - 希尔排序
        - O(n^1.3), O(n^2), O(n), O(1), 不稳定
- 选择排序
    - 简单选择排序
        - 每次找到最小值，然后放到待排序数组的起始位置
        - O(n^2), O(n^2), O(n^2), O(1), 不稳定
    - 堆排序
        - O(nlog2n), O(nlog2n), O(nlog2n), O(1), 不稳定
- 归并排序
    - 思路
        - 把长度为n的输入序列分成两个长度为n/2的子序列
        - 对这两个子序列分别采用归并排序
        - 将两个排序好的子序列合并成一个最终的排序序列
    - 二路归并排序
        - O(nlog2n), O(nlog2n), O(nlog2n), O(n), 稳定
    - 多路归并排序
### 4.2 非比较类排序
- 不通过比较来决定元素间的相对次序,以线性时间运行
- 计数排序
    - O(n+k), O(n+k), O(n+k), O(n+k), 稳定
- 桶排序
    - O(n+k), O(n^2), O(n), O(n+k), 稳定
- 基数排序
    - O(n*k), O(n*k), O(n*k), O(n+k), 稳定
