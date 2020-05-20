# 排序
## 1. 冒泡排序（稳定排序）
### 描述
冒泡排序的原理是，每一次遍历数组，都去不断地比较相邻的两个元素，如果它们的顺序不对，就交换这两个元素，比如把较大的换到后面。第一次遍历可以把最大的元素确定下来，放在最后的位置。第二次遍历可以确定第二大的元素，依次类推。这样遍历 N 次后，整个数组就变成递增有序。
### 代码

```
public class AlgoCasts {

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // Time: O(n^2), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    for (int end = n-1; end > 0; --end) {
      for (int i = 0; i < end; ++i) {
        if (arr[i] > arr[i+1]) {
          int tmp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = tmp;
        }
      }
    }
  }

  // Time: O(n^2), Space: O(1)
  public void sortShort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    for (int end = n-1; end > 0; --end)
      for (int i = 0; i < end; ++i)
        if (arr[i] > arr[i+1])
          swap(arr, i, i+1);
  }

  // Time: O(n^2), Space: O(1)
  public void sortEarlyReturn(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    boolean swapped;
    for (int end = n-1; end > 0; --end) {
      swapped = false;
      for (int i = 0; i < end; ++i) {
        if (arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
          swapped = true;
        }
      }
      if (!swapped) return;
    }
  }

  // Time: O(n^2), Space: O(1)
  public void sortSkip(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    int newEnd;
    for (int end = n-1; end > 0;) {
      newEnd = 0;
      for (int i = 0; i < end; ++i) {
        if (arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
          newEnd = i;
        }
      }
      end = newEnd;
    }
  }

}
```

## 2. 鸡尾酒排序排序（稳定排序）
### 描述
鸡尾酒排序是冒泡排序的一种变体，又叫做双向冒泡排序。顾名思义，它从两个方向对数组或序列进行冒泡排序。每一次从左向右进行冒泡排序后，紧接着一次从右向左的冒泡排序。这样从左向右，然后从右向左，来回反复地进行冒泡排序，就像在摇晃调制一杯鸡尾酒，因此得名鸡尾酒排序。
### 代码

```
public class AlgoCasts {

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // Time: O(n^2), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int left = 0, right = arr.length - 1;

    while (left < right) {
      for (int i = left; i < right; ++i)
        if (arr[i] > arr[i+1])
          swap(arr, i, i+1);
      --right;

      for (int i = right; i > left; --i)
        if (arr[i-1] > arr[i])
          swap(arr, i-1, i);
      ++left;
    }
  }

  // Time: O(n^2), Space: O(1)
  public void sortEarlyReturn(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int left = 0, right = arr.length - 1;
    boolean swapped;

    while (left < right) {
      swapped = false;

      for (int i = left; i < right; ++i) {
        if (arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
          swapped = true;
        }
      }
      --right;

      for (int i = right; i > left; --i) {
        if (arr[i-1] > arr[i]) {
          swap(arr, i-1, i);
          swapped = true;
        }
      }
      ++left;

      if (!swapped) return;
    }
  }

  // Time: O(n^2), Space: O(1)
  public void sortSkip(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int left = 0, right = arr.length - 1;
    int newLeft, newRight;

    while (left < right) {
      newRight = left;
      for (int i = left; i < right; ++i) {
        if (arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
          newRight = i;
        }
      }
      right = newRight;

      newLeft = right;
      for (int i = right; i > left; --i) {
        if (arr[i-1] > arr[i]) {
          swap(arr, i-1, i);
          newLeft = i;
        }
      }
      left = newLeft;
    }
  }
}
```

## 3. 选择排序（不稳定排序）
### 描述
选择排序是一种简单直观的排序算法。这个算法把数组分为有序区和无序区，每次都选择无序区中的最大值或最小值，放入有序区中，直到整个数组都有序。
### 代码

```
public class AlgoCasts {

  private void swap(int[] arr, int i, int j) {
    if (i == j) return;
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // Time: O(n^2), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      int minIdx = i;
      for (int j = i+1; j < n; ++j)
        if (arr[j] < arr[minIdx])
          minIdx = j;
      swap(arr, i, minIdx);
    }
  }

  // Time: O(n^2), Space: O(1)
  public void sortFromEnd(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    for (int i = n-1; i > 0; --i) {
      int maxIdx = i;
      for (int j = 0; j < i; ++j)
        if (arr[j] > arr[maxIdx])
          maxIdx = j;
      swap(arr, i, maxIdx);
    }
  }

}
```

## 4. 冒泡排序（稳定排序
### 描述
冒泡排序的原理是，每一次遍历数组，都去不断地比较相邻的两个元素，如果它们的顺序不对，就交换这两个元素，比如把较大的换到后面。第一次遍历可以把最大的元素确定下来，放在最后的位置。第二次遍历可以确定第二大的元素，依次类推。这样遍历 N 次后，整个数组就变成递增有序。
### 代码

```
public class AlgoCasts {

  // Time: O(n^2), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    for (int i = 1; i < arr.length; ++i) {
      int cur = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > cur) {
        arr[j+1] = arr[j];
        --j;
      }
      arr[j+1] = cur;
    }
  }

}
```

## 5. 希尔排序（不稳定排序）
### 描述
希尔排序是由希尔提出的一种排序算法，它是插入排序的改进版本。希尔排序通过引入步长 gap，将数组分成多个子序列分别进行插入排序，这样可以让一个元素朝最终位置跳跃一大步。步长在每一轮排序后递减，最后减至 1，变成简单插入排序。这个时候，数组已经基本有序，只需要再做少量的对比和移动即可完成最后的排序。
### 代码

```
public class AlgoCasts {

  // Time: O(n^2), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    for (int gap = arr.length>>1; gap > 0; gap >>= 1) {
      for (int i = gap; i < arr.length; ++i) {
        int cur = arr[i];
        int j = i - gap;
        while (j >= 0 && arr[j] > cur) {
          arr[j+gap] = arr[j];
          j -= gap;
        }
        arr[j+gap] = cur;
      }
    }
  }

  // Time: O(n^2), Space: O(1)
  public void insertionSort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    for (int i = 1; i < arr.length; ++i) {
      int cur = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > cur) {
        arr[j + 1] = arr[j];
        j -= 1;
      }
      arr[j + 1] = cur;
    }
  }

}
```

## 6. 快速排序（不稳定排序）
### 描述
快速排序是由东尼·霍尔提出的一种高效的排序算法，简称快排。它的算法思想并不复杂，可以用 3 个步骤 6 个字来概括：选基、分割、递归。扩充成一句话就是：首先挑选基准值；然后分割数组，把小于基准值的元素放到基准值前面，大于基准值的元素放到基准值后面；最后递归地对小于基准值的子序列和大于基准值的子序列进行排序。
### 代码

```
public class AlgoCasts {

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private int lomutoPartition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; ++j) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        ++i;
      }
    }
    swap(arr, i, high);
    return i;
  }

  private void lomutoSort(int[] arr, int low, int high) {
    if (low < high) {
      int k = lomutoPartition(arr, low, high);
      lomutoSort(arr, low, k-1);
      lomutoSort(arr, k+1, high);
    }
  }

  // Time: O(n*log(n)), Space: O(n)
  public void lomutoSort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    lomutoSort(arr, 0, arr.length-1);
  }

  private int hoarePartition(int[] arr, int low, int high) {
    int pivot = arr[low + (high-low)/2];
    int i = low, j = high;
    while (true) {
      while (arr[i] < pivot) ++i;
      while (arr[j] > pivot) --j;
      if (i >= j) return j;
      swap(arr, i++, j--);
    }
  }

  private void hoareSort(int[] arr, int low, int high) {
    if (low < high) {
      int k = hoarePartition(arr, low, high);
      hoareSort(arr, low, k);
      hoareSort(arr, k+1, high);
    }
  }

  // Time: O(n*log(n)), Space: O(n)
  public void hoareSort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    hoareSort(arr, 0, arr.length-1);
  }

}
```

## 7. 归并排序（稳定排序）
### 描述
归并排序是由冯·诺伊曼提出的一种基于分治思想的高效排序算法。它的算法思想是，把当前序列平分成两个子序列，然后递归地对子序列进行排序，最后把排序好的子序列再合并成一个有序的序列。
### 代码

```
public class AlgoCasts {

  private void merge(int[] arr, int low, int mid, int high, int[] tmp) {
    int i = low, j = mid + 1, k = 0;
    while (i <= mid && j <= high) {
      if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
      else tmp[k++] = arr[j++];
    }
    while (i <= mid) tmp[k++] = arr[i++];
    while (j <= high) tmp[k++] = arr[j++];
    System.arraycopy(tmp, 0, arr, low, k);
  }

  private void mergeSort(int[] arr, int low, int high, int[] tmp) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(arr, low, mid, tmp);
      mergeSort(arr, mid + 1, high, tmp);
      merge(arr, low, mid, high, tmp);
    }
  }

  // Time: O(n*log(n)), Space: O(n)
  public void sortRecursive(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int[] tmp = new int[arr.length];
    mergeSort(arr, 0, arr.length - 1, tmp);
  }

  // Time: O(n*log(n)), Space: O(n)
  public void sortIterative(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length;
    int[] tmp = new int[n];
    for (int len = 1; len < n; len = 2*len) {
      for (int low = 0; low < n; low += 2*len) {
        int mid = Math.min(low+len-1, n-1);
        int high = Math.min(low+2*len-1, n-1);
        merge(arr, low, mid, high, tmp);
      }
    }
  }

}
```

## 8. 堆排序（不稳定排序）
### 描述
堆排序是一种基于比较的排序算法。它的算法思想和选择排序相似，都是把数组分为有序区和无序区，每次都从无序区中取最大值或最小值，放入有序区，直到整个数组有序。和选择排序的区别是，堆排序使用了一个二叉堆来组织无序区中的数据，以此减少从无序区中查找最值的时间。

二叉堆逻辑上是一棵完全二叉树，但实际上存储在一维数组中即可。根据堆是最大堆还是最小堆的不同，具有不同的性质。在最大堆中，树上任意节点的值都大于等于它的子节点。而在最小堆中，树上任意节点的值都小于等于它的子节点。
### 代码

```
public class AlgoCasts {
  
  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // Time: O(log(n))
  private void siftDown(int[] arr, int i, int end) {
    int parent = i, child = 2 * parent + 1;
    while (child <= end) {
      if (child+1 <= end && arr[child+1] > arr[child]) ++child;
      if (arr[parent] >= arr[child]) break;
      swap(arr, parent, child);
      parent = child;
      child = 2 * parent + 1;
    }
  }

  private void buildMaxHeap(int[] arr, int end) {
    for (int i = end/2; i >= 0; --i) {
      siftDown(arr, i, end);
    }
  }

  // Time: O(n*log(n)), Space: O(1)
  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) return;
    buildMaxHeap(arr, arr.length - 1);
    for (int end = arr.length - 1; end > 0; --end) {
      swap(arr, 0, end);
      siftDown(arr, 0, end - 1);
    }
  }

}
```

## 9. 计数排序（稳定排序）
### 描述
计数排序是一种稳定的排序算法。它不是基于比较的排序算法，因此可以突破 O(n*log(n)) 的下界，在线性时间内完成排序。

计数排序适用于序列的键值是较小范围的整数，或是可以映射到较小范围整数的情况。它的算法思想是统计相同键值的元素个数，然后以键值为下标，把统计结果存储到一个较小的数组中。根据元素的出现个数，再计算出每个元素在排序数组中所在下标，根据这些下标，把元素放到正确的位置上即可。
### 代码

```
public class AlgoCasts {

  public class CountingSortFixedK {

    private int k;

    // 对于数组中元素 x，有 0 <= x <= k, k 是一个较小的数字。
    public CountingSortFixedK(int k) {
      this.k = k;
    }

    // Time: O(n+k), Space: O(n+k)
    public void sortLeft2Right(int[] arr) {
      if (arr == null || arr.length == 0) return;
      int[] indexes = new int[k+1];
      for (int num: arr) ++indexes[num];

      int start = 0;
      for (int i = 0; i <= k; ++i) {
        int count = indexes[i];
        indexes[i] = start;
        start += count;
      }

      int[] tmp = new int[arr.length];
      for (int num: arr) {
        int idx = indexes[num];
        tmp[idx] = num;
        ++indexes[num];
      }
      System.arraycopy(tmp, 0, arr, 0, arr.length);
    }

    // Time: O(n+k), Space: O(n+k)
    public void sortRight2Left(int[] arr) {
      if (arr == null || arr.length == 0) return;
      int[] indexes = new int[k+1];
      for (int num: arr) ++indexes[num];

      --indexes[0];
      for (int i = 1; i <= k; ++i)
        indexes[i] = indexes[i] + indexes[i-1];

      int[] tmp = new int[arr.length];
      for (int i = arr.length-1; i >= 0; --i) {
        int idx = indexes[arr[i]];
        tmp[idx] = arr[i];
        --indexes[arr[i]];
      }
      System.arraycopy(tmp, 0, arr, 0, arr.length);
    }

  }

}
```

## 10. 桶排序（稳定排序）
### 描述
桶排序是一种稳定的排序算法。它的工作原理是将序列中的元素分布到一定数量的桶内，然后分别对每个桶内的元素进行排序，最后再将各个桶内的有序子序列放回原始序列中。对于单个桶内的元素排序，我们可以使用别的排序算法，也可以递归使用桶排序。一般来说，对于单个桶内的元素，使用插入排序算法对它们进行排序。

桶排序适用于数据是均匀分布的情况，这样可以让分布到各个桶内的元素数量相当。而不是被集中分配到其中一个桶或几个桶。
### 代码

```
public class AlgoCasts {

  public class BucketSort {
    
    private void insertionSort(List<Integer> arr) {
      if (arr == null || arr.size() == 0) return;
      for (int i = 1; i < arr.size(); ++i) {
        int cur = arr.get(i);
        int j = i - 1;
        while (j >= 0 && arr.get(j) > cur) {
          arr.set(j+1, arr.get(j));
          --j;
        }
        arr.set(j+1, cur);
      }
    }

    private int bucketSize;

    public BucketSort(int bucketSize) {
      this.bucketSize = bucketSize;
    }

    // Time(avg): O(n+k), Time(worst): O(n^2), Space: O(n)
    public void sort(int[] arr) {
      if (arr == null || arr.length == 0) return;
      int max = arr[0], min = arr[0];
      for (int num: arr) {
        if (num > max) max = num;
        if (num < min) min = num;
      }

      int bucketCount = arr.length / bucketSize;
      List<List<Integer>> buckets = new ArrayList<>(bucketCount);
      for (int i = 0; i < bucketCount; ++i)
        buckets.add(new ArrayList<>());

      for (int num: arr) {
        int idx = (int)((num - min) / (max - min + 1.0) * bucketCount);
        buckets.get(idx).add(num);
      }

      int idx = 0;
      for (List<Integer> bucket: buckets) {
        insertionSort(bucket);
        for (int num: bucket)
          arr[idx++] = num;
      }
    }

  }

}```

## 11。基数排序（稳定排序）
### 描述
基数排序是一种稳定的排序算法。它不是基于比较的算法，因此可以突破 O(n*log(n)) 的下界。基数排序的工作原理是，根据选取的基数，把整数键值分割成几个部分。依次以这几个部分所对应的整数作为键值，对原始序列进行多次计数排序或桶排序。

基数排序不仅可以用来排序整数键值，对于较短的字符串键值排序，基数排序也是一种非常好的选择。比如车牌号排序。
### 代码

```
public class AlgoCasts {

  // Time: O(32/b * n), Space: O(n + 2^b)
  private void sort(int[] arr, int bits, int mask) {
    if (arr == null || arr.length == 0) return;
    int n = arr.length, cnt = 32/bits;
    int[] tmp = new int[n];
    int[] indexes = new int[1<<bits];
    for (int d = 0; d < cnt; ++d) {
      for (int num: arr) {
        int idx = (num >> (bits*d)) & mask;
        ++indexes[idx];
      }

      --indexes[0];
      for (int i = 1; i < indexes.length; ++i)
        indexes[i] = indexes[i] + indexes[i-1];

      for (int i = n-1; i >= 0; --i) {
        int idx = (arr[i] >> (bits*d)) & mask;
        tmp[indexes[idx]] = arr[i];
        --indexes[idx];
      }

      Arrays.fill(indexes, 0);
      int[] t = arr;
      arr = tmp;
      tmp = t;
    }
    // handle the negative number
    // get the length of positive part
    int len = 0;
    for (; len < n; ++len)
      if (arr[len] < 0) break;

    System.arraycopy(arr, len, tmp, 0, n-len); // copy negative part to tmp
    System.arraycopy(arr, 0, tmp, n-len, len); // copy positive part to tmp
    System.arraycopy(tmp, 0, arr, 0, n); // copy back to arr
  }

  // 基数为 256，每次取 8 个二进制位作为一个部分进行处理，32 位整数需要处理 4 次。
  // 每次取出的 8 个二进制位会作为计数排序的键值，去排序原始数据。
  // 每次处理 8 个二进制位，是时间/空间上比较折衷的方法。
  // 如果一次处理 16 个二进制位，速度会稍微快一些。但需要额外的空间是 2^16 = 65536，远大于每次处理 8 个二进制位所需空间。
  // 如果一次只处理 4 个二进制位，速度则会慢很多。
  public void sort4pass(int[] arr) {
    sort(arr, 8, 0xff);
  }

  public void sort8pass(int[] arr) {
    sort(arr, 4, 0x0f);
  }
}
```



