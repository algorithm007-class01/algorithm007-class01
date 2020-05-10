学习笔记

## 位运算

### 为什么需要位运算？

机器里的数字表示方式和存储格式就是二进制。



### 位运算符

| 含义     | 运算符 | 实例                 |
| -------- | ------ | -------------------- |
| 左移     | <<     | 0011 -> 0110         |
| 右移     | >>     | 0110 -> 0011         |
| 按位或   | \|     | 0011 \| 1011 -> 1011 |
| 按位与   | &      | 0011 & 1011 -> 0011  |
| 按位取反 | ~      | 0011 -> 1100         |
| 按位异或 | ^      | 0011 ^ 1011 -> 1000  |



### 指定位置的位运算

1. 将x最右边的n位清零：x & (~ 0 << n)
2. 获取x的第n位值（0或者1）：(x >> n) & 1
3. 获取x的第n位的幂值：x & (1 << (n - 1))
4. 仅将第n位置为1：x | (1 << n)
5. 仅将第n位置为0：x & (~(1 << n))
6. 将x最高位至第n位（含第n位）清零：x & ((1 << n) - 1)
7. 将第n位至第0位（含第0位）清零：x & (~((1 << (n + 1)) - 1))



### 实战位运算要点

- 判断奇偶

  ```java
  x % 2 等价于 x & 1
  ```

  

- x >> 1 等价于 x / 2

- x = x & (x - 1)  将最低位的1清零

- x & -x 得到最低位的1

- x & ~x 得到0



## 布隆过滤器的实现及应用

### 基本概念

Bloom Filter是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

**优点是空间效率和查询时间都远远高于一般的算法**。

**缺点是有一定的误识别率和删除困难**。



## LRU Cache

### Cache缓存应用

1. 人脑记忆
2. 钱包-储物柜
3. 代码模块



### LRU Cache基本特征

- 两个要素：大小、替换策略
- Hash Table + Double LinkedList
- O(1)查询、修改、更新



### LRU Cache实现代码模板

```java
class LRUCache {
    private Map<Integer, Integer> map; 
     
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}
```



```java
class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity;
    public LRUCache(int capacity) {
       super(capacity,0.75F,true);
       this.capacity=capacity;
    }
    
    public int get(int key) {
       return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }

     @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}
```







## 排序

### 初级排序 O(n^2)

1. 冒泡排序

   嵌套循环，每次查看相邻元素，如果逆序，则交换。

2. 选择排序

   每次找最小值，然后放到待排序数组的起始位置。

3. 插入排序

   从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

#### 冒泡排序

```java
private static void bubbleSort(int[] array) {
    int len = array.length;
    
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len - 1; j++) {
            if (array[j] > array[j+1]) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}
```

#### 选择排序

```java
private static void selectSort(int[] array, int n) {
    for (int i = 0; i < n - 1; i++) {
        int index = i;
        int j;
        // 找出最小值的下标
        for (j = i + 1; j < n; j++) {
            if (array[j] < array[index]) {
                index = j;
            }
        }
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
}
```

#### 插入排序

```java
private static void insertSort(int[] array) {
    int temp;
    int len = array.length;
    for (int i = 1; i < len; i++) {
        // 待排元素小于有序序列的最后一个元素时
        // 在最后一个元素之前插入
        if (array[i] < array[i-1]) {
            temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j-1] > temp) {
                    array[j] = array[j-1];
                } else {
                    array[j] = temp;
                    break;
                }
            }
        }
    }
}
```



### 高级排序 O(nlogn)

#### 快速排序

数组取标杆pivot，将小于pivot的元素放在左边，大于的元素放在右边，然后依次对左右两边进行快排，最终达到整个数组有序。

```java
public static void quickSort(int[] arr, int begin, int end) {
    if (end <= begin) {
        return;
    }
    int pivot = partition(arr, begin, end);
    quickSort(arr, begin, pivot - 1);
    quickSort(arr, pivot + 1, end);
}

private static int partition(int[] arr, int begin, int end) {
    // pivot是标杆位置，counter记录小于pivot的元素个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (arr[i] < arr[pivot]) {
            int temp = arr[counter];
            arr[counter] = arr[i];
            arr[i] = temp;
            counter++;
        }
    }
    int temp = arr[pivot];
    arr[pivot] = arr[counter];
    arr[counter] = temp;
    return counter;
}
```

#### 归并排序

1. 把长度为n的输入序列分成两个长度为n/2的子序列；
2. 对这两个子序列分别采用归并排序；
3. 将两个有序的子序列合并成一个序列。

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (right <= left) {
        return;
    }
    int mid = (left + right) >> 1;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right-left+1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
        temp[k++] = arr[i++];
    }
    while (j <= right) {
        temp[k++] = arr[j++];
    }
    for (int p = 0; p < temp.length; p++) {
        arr[left+p] = temp[p];
    }
}
```

#### 堆排序 O(nlogn)

插入数据O(logn)，取最大/小值O(1)。

1. 数组元素依次建立大/小顶堆
2. 依次取出堆顶元素，并删除

```java
// 以大顶堆为例
private static void heapify(int[] arr, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2;
    int largest = i;
    if (left < length && arr[left] > arr[largest]) {
        largest = left;
    }
    if (right < length && arr[right] > arr[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, length, largest);
    }
}

public static void heapSort(int[] arr) {
    int len = arr.length;
    if (len == 0) {
        return;
    }
    for (int i = len / 2 - 1; i >= 0; i--) {
        heapify(arr, length, i);
    }
    for (int i = len - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}
```



### 特殊排序 O(n)

#### 计数排序

#### 基数排序

#### 桶排序