# 位运算
## 转换
- 如何从十进制转换为二进制 https://zh.wikihow.com/从十进制转换为二进制


## 运算
- 或 |
- 与 &
- 取反 ~
- 异或 ^ 相同为0 不同为1
- 左移
- 右移

##  指定位置的位运算

1. 将 x 最右边的 n 位清零:x & (~0 << n)
2. 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1
3. 获取 x 的第 n 位的幂值:x & (1 << (n -1))
4. 仅将第 n 位置为 1:x | (1 << n)
5. 仅将第 n 位置为 0:x & (~ (1 << n))
6. 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1)
7. 将第 n 位至第 0 位(含)清零:x & (~ ((1 << (n + 1)) - 1))

##  实战位运算要点

### 判断奇偶:
- x % 2 == 1 —> (x & 1) == 1 
- x % 2 == 0 —> (x & 1) == 0
- x >> 1 —> x / 2
  - 即: x = x / 2; —> x = x >> 1;
  - mid = (left + right) / 2; —> mid = (left + right) >> 1;
- X = X & (X-1) 清零最低位的 1
- X & -X => 得到最低位的 1
- X & ~X => 0

## 习题
- https://leetcode-cn.com/problems/number-of-1-bits/
  - 从0到32 循环 是否是1  移动32次
  - %2 相当于每次右移动1位 移动32次
  - &1 相当于每次右移动1位 移动32次
  - n = n & (n-1) 移动1的次数
- https://leetcode-cn.com/problems/power-of-two/
   - 仅有一个二进制位是1
   - n = n & (n-1); 
- https://leetcode-cn.com/problems/reverse-bits/
  - int -> string reverse -> int
  - 直接通过位运算
- https://leetcode-cn.com/problems/n-queens/description/
- https://leetcode-cn.com/problems/n-queens-ii/description/
  - 用位运算求解
  - n=4 去手工理解
- https://leetcode-cn.com/problems/counting-bits/description/
  - 位运算+dp
  - 北美互联网出的比较多

# 布隆过滤器
- 检索元素是否存在
- 由很长的二进制向量和一系列随机函数构成
- 空间和查询效率很高
- 有误识别率 很难删除
- 实现原理 https://www.cnblogs.com/cpselvis/p/6265825.html
- 现实应用
  - https://blog.csdn.net/tianyaleixiaowu/article/details/74721877
  - 缓存击穿
  - 垃圾邮件识别
  - 集合判重
- java实现 
  - https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java
  - https://github.com/Baqend/Orestes-Bloomfilter

# LRU cache
- 最近最少使用
- hash table + 头插 double linked list
- 查询o（1） 更新o（1）
- 替换算法纵览 https://en.wikipedia.org/wiki/Cache_replacement_policies
- java 中 LinkedHashMap

```python
class LRUCache(object): 

	def __init__(self, capacity): 
		self.dic = collections.OrderedDict() 
		self.remain = capacity

	def get(self, key): 
		if key not in self.dic: 
			return -1 
		v = self.dic.pop(key) 
		self.dic[key] = v   # key as the newest one 
		return v 

	def put(self, key, value): 
		if key in self.dic: 
			self.dic.pop(key) 
		else: 
			if self.remain > 0: 
				self.remain -= 1 
			else:   # self.dic is full
				self.dic.popitem(last=False) 
		self.dic[key] = value
```
```java
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


```

```java
import java.util.Hashtable;
public class LRUCache {

  class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
  }

  private void addNode(DLinkedNode node) {
    /**
     * Always add the new node right after head.
     */
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(DLinkedNode node){
    /**
     * Remove an existing node from the linked list.
     */
    DLinkedNode prev = node.prev;
    DLinkedNode next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DLinkedNode node){
    /**
     * Move certain node in between to the head.
     */
    removeNode(node);
    addNode(node);
  }

  private DLinkedNode popTail() {
    /**
     * Pop the current tail.
     */
    DLinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }

  private Hashtable<Integer, DLinkedNode> cache =
          new Hashtable<Integer, DLinkedNode>();
  private int size;
  private int capacity;
  private DLinkedNode head, tail;

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    // head.prev = null;

    tail = new DLinkedNode();
    // tail.next = null;

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) return -1;

    // move the accessed node to the head;
    moveToHead(node);

    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);

    if(node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      addNode(newNode);

      ++size;

      if(size > capacity) {
        // pop the tail
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      // update the value.
      node.value = value;
      moveToHead(node);
    }
  }
}

/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 //自己实现
 class LRUCache {
    private HashMap<Integer,Node> cache = new HashMap<>();
    private int cap,size;
    private Node head,tail;

    class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
    }

    private void moveToHead(Node node){
        removeNode(node);
        insertNode(node);
    }
    private void removeNode(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void insertNode(Node node){
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }

    private Node popTail(){
        Node tail = this.tail.pre;
        removeNode(tail);
        return tail;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            node = new Node();
            node.key = key;
            node.value = value;

            cache.put(key,node);
            insertNode(node);
            size ++;

            if(size > cap){
                Node tail = popTail();
                cache.remove(tail.key);
                size --;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
## 习题
https://leetcode-cn.com/problems/lru-cache/#/


# 排序
- 十大排序 https://www.cnblogs.com/onepixel/p/7674659.html


## 比较类排序
- 通过比较确定顺序，时间复杂度不能突破nlogn
- 重点看nlogn的排序 堆排序、快速排序、归并排序

### 初级排序 n^2

- 选择排序
  - 每次找最小值放入排序数组的起始位置
  
- 插入排序
  - 每次从无序的数组中取出一个元素放入前半部分有序数组中应该在的位置

- 冒泡排序
  - 通过两层循环，相邻位置逆序就交换，这样每一次内层循环都会选出最大的元素放在最后，可以看成选择排序的逆过程

### 高级排序 n*logn
- 快速排序
  - 数组取标杆pivot，将小元素放在pivot左边，大元素放在另一边，依次对左右侧数组进行快速排序，以达到整个数组有序
```java 
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    // pivot 直接选最后的元素，省去开辟新空间
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```
- 归并排序 分治
  - 将长度为n的序列分成两个长度为n/2的子序列
  - 对这两个子序列分别进行归并排序
  - 将两个排序好的子序列合并成一个最终的有序序列
  - 有点类似于快排的逆过程
```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        //合并两个有序数组 用三个while 
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```
- 堆排序
  - 插入删除 logn  取值o（1）
  - 大顶堆
  - 小顶堆
```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;

    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0) return;

    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);

    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

## 非比较类排序

# 特殊排序 了解
- 排序动画 https://www.bilibili.com/video/av25136272

## 计数排序
- 找出待排序的数组中最大和最小的元素；
- 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
- 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
- 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

## 桶排序
- 设置一个定量的数组当作空桶；
- 遍历输入数据，并且把数据一个一个放到对应的桶里去；
- 对每个不是空的桶进行排序；
- 从不是空的桶里把排好序的数据拼接起来。 

## 基数排序
- 取得数组中的最大数，并取得位数；
- arr为原始数组，从最低位开始取每个位组成radix数组；
- 对radix进行计数排序（利用计数排序适用于小范围数的特点）；

## 习题
 - https://leetcode-cn.com/problems/relative-sort-array/
   - 通过排序以后再比较
 - https://leetcode-cn.com/problems/valid-anagram/
   - 高频 合并区间+一次扫描
 - https://leetcode-cn.com/problems/design-a-leaderboard/
 - https://leetcode-cn.com/problems/merge-intervals/
 - https://leetcode-cn.com/problems/reverse-pairs/
   - 归并排序中统计符合要求的逆序对
    ```
    public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        // 两个子数组分别统计逆序对
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        // 统计两个子数组之间的逆序对
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        //调用系统的合并排序函数，局部时间负载度从o（n）变为o（logn），但数据很少，无伤大雅
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
    }
    
    //严格意义上的归并排序，时间复杂度也是严格的o（nlogn）
    public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int[] cache = new int[r - l + 1];
        int i = l, t = l, c = 0;
        //合并的同时进行统计
        for (int j = mid + 1; j <= r; j++, c++) {
            //统计不符合条件的逆序对
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            //合并
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            //减去不符合条件的逆序对就是符合条件的逆序对
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }
    }
    ```
    