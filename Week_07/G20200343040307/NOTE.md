## 排序

1. 比较类排序
   通过比较来决定元素间的相对次序，由于其时间复杂度不能突破 O(logn)，（在数学上证明了），因此也称为非线性时间比较类排序

2. 非比较类排序
   不通过比较来决定元素间的相对次序，他可以突破基于比较排序的时间下界，以线性时间运行，一次也称为线性时间非比较类排序

## 初级排序 O(n*n)

1. 选择排序
   每次找最小值，然后放到待排序的起始位置

2. 插入排序
   从前到后逐步构建有序序列，对于未排序的数据，在已排序序列中从后向前扫描，找到相应的位置插入

3. 冒泡排序
   嵌套循环，每次查看相邻的元素，如果逆序则交换

## 高级排序 O(nLogn)

1. 快速排序
   数组取标杆 pivot，将小元素放 pivot 左边，大元素放 pivot 右边，然后依次对左边和右边的子数组继续快排，已达到整个序列有序的目的

2. 归并排序 - 分治
   把长度为 n 的输入序列分成两个长度为 n/2 的子序列
   对这两个子序列分别采用归并排序
   将两个排好序的子序列合并成一个最终的排序序列

3. 堆排序 - 堆插入 O(logn)
    数组元素依次建立小顶堆
    依次取堆顶元素，并删除

## 特殊排序

1. 计数排序（Counting Sort）
   计数排序要求在输入的数据时有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中。然后依次把计数大于 1 的填充会原数组

2. 桶排序（Bucket Sort）
   桶排序的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）

3. 基数排序（Radix Sort）
   基数排序是按照低位先排序然后收集，再按照高位排序，然后再收集。依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序

![sorts](/images/Sort/Sorts-Compare.jpg)

面试重点在于在于三个时间复杂度为 O(NlogN) 的算法： 归并，快排，堆

参考资料
[小专栏 - 五分钟学算法](https://xiaozhuanlan.com/topic/4297536018)
[一像素博客](https://www.cnblogs.com/onepixel/p/7674659.html)

## 代码模板

### 冒泡

```s
func sort(arr: inout [Int]) {
    let size = arr.count
    for j in 0..<size {
        for i in 1..<size-j {
            if arr[i] < arr[i-1] {
                let tmp = arr[i]
                arr[i] = arr[i-1]
                arr[i-1] = tmp
            }
        }
    }
}

# improve
#  因为冒泡中无论是否有序都会进行交换操作，所以可以做一个判断提前退出

func sort(arr: inout [Int]) {
    let size = arr.count
    for j in 0..<size {
       var isSorted = true
        for i in 1..<size-j {
            if arr[i] < arr[i-1] {
                let tmp = arr[i]
                arr[i] = arr[i-1]
                arr[i-1] = tmp
                isSorted = false
            }
        }
        if isSorted {
           break
        }
    }
}

```

### 选择排序

```s
func sort(arr: inout [Int]) {
    for i in 0..<arr.count {
        var tmp = i
        for j in i..<arr.count {
            if arr[tmp] > arr[j] {
                tmp = j
            }
        }
        arr.swapAt(i, tmp)
    }
}
```

### 插入排序

```s
func sort(arr: inout [Int]) {
    for i in 1..<arr.count {
        var tmp = i
        let tmpValue = arr[i]
        while tmp > 0 && arr[tmp-1] > tmpValue {
            arr[tmp] = arr[tmp-1]
            tmp -= 1
        }
        arr[tmp] = tmpValue
    }
}

# 相对简洁的写法，但是不标准，因为是交换，每次比较多了一次赋值操作
func sort(arr: inout [Int]) {
    for i in 1..<arr.count {
        var tmp = i
        while tmp > 0 && arr[tmp-1] > arr[tmp]  {
            arr.swapAt(tmp, tmp-1)
            tmp -= 1
        }
    }
}
```

### 希尔排序

希尔排序是简单插入排序的进阶版本，gap 一般取数组大小的 1/2 到 1/3

```s
func sort(arr: inout [Int]) {
    var gap = arr.count/2
    while gap > 0 {
        for i in gap..<arr.count {
            var j = i
            let tmp = arr[i]
            while j-gap >= 0 && arr[j-gap] > tmp {
                arr[j] = arr[j-gap]
                j -= gap
            }
            arr[j] = tmp
        }
        gap /= 2
    }
}
```

### 归并排序

```s
# 1. 如果方法中传入的参数不可修改，则需要再多开辟出一个数组
# 2. 另一种方法是在 merge 方法中每次创建新的数组代替 arr ，然后返回。
#     sort 方法和 split 方法就合并为一个方法
func sort(arr: inout [Int]) {
    var tmp = arr
    split(&arr, &tmp, 0, arr.count-1)
}

func split(_ arr: inout [Int], _ tmp: inout [Int], _ left: Int, _ right: Int) {
    if left >= right {
        return
    }

    let middle = left+(right-left)/2
    split(&arr, &tmp, left, middle)
    split(&arr, &tmp, middle+1, right)
    merge(&arr, &tmp, left, middle, right)
}

func merge(_ arr: inout [Int], _ tmp: inout [Int], _ left: Int, _ middle: Int, _ right: Int) {
  
    for i in left...right {
        tmp[i] = arr[i]
    }
    var fir = left
    var sec = middle+1
    for j in left...right {
        if fir > middle {
            arr[j] = tmp[sec]
            sec += 1
        }else if sec > right {
            arr[j] = tmp[fir]
            fir += 1
        }else if tmp[fir] < tmp[sec] {
            arr[j] = tmp[fir]
            fir += 1
        }else {
            arr[j] = tmp[sec]
            sec += 1
        }
    }
}

```

### 快速排序

```s
# 单向遍历
class Solution {
    func sortArray(_ nums: [Int]) -> [Int] {
        var tmp = nums
        split(&tmp, 0, nums.count-1)
        return tmp
    }

    func split(_ tmp: inout [Int], _ left: Int, _ right: Int) {
        if left >= right {
            return
        }
        let pa = merge(&tmp, left, right)
        split(&tmp, left, pa-1)
        split(&tmp, pa+1, right)
    }

    func merge(_ tmp: inout [Int], _ left: Int,_ right: Int) -> Int {
        var mark = left
        let prov = tmp[left]
        for i in (left+1)...right {
            if tmp[i] < prov {
                mark += 1
                tmp.swapAt(i, mark)
            }
        }
        tmp.swapAt(left, mark)
        return mark
    }
}

# 双向遍历？

```

### 堆排序

其实就是堆实现中的 shiftDown 方法（初始化方法）

```s

func sorted(arr: [Int]) {
   var nums = arr
   heapSort(arr: &nums)
   var count = arr.count
   for i in 0..<count {
      nums.swapAt(0, i)
      count -= 1
      shiftDown(from: 0, until: count, arr: &arr)
   }
}

func heapSort(arr: innout [Int]) {
   for i in stride(from: (arr.count/2-1), through: 0, by: -1) {
      shiftDown(from: 0, until: i, arr: &arr)
   }
}

func shiftDown(from index: Int, until endIndex: Int, arr: inout [Int]) {
  let leftChildIndex = index*2+1
  let rightChildIndex = leftChildIndex + 1
  var first = index
  if leftChildIndex < endIndex && arr[leftChildIndex] < arr[first] {
      first = leftChildIndex
  }
  if rightChildIndex < endIndex && arr[rightChildIndex] < arr[first] {
    first = rightChildIndex
  }
  if first == index { return }
  arr.swapAt(index, first)
  shiftDown(from: first, until: endIndex, arr: &arr)
}
```

### 计数排序

计数排序的局限在于只能处理整数类型，而且如果需要排序的范围过大会有很大的浪费
当范围不是很大，序列比较集中的序列，计数排序是很有效的算法

```s
func sort(arr: [Int]) -> [Int]{
    var count = 0
    for num in arr {
        count = max(count, num)
    }
    var tmp = [Int](repeating: 0, count: count+1)
    var ans = [Int]()
    for num in arr {
        tmp[num] += 1
    }
    for res in 0..<tmp.count {
        var cc = tmp[res]
        while cc > 0 {
            ans.append(res)
            cc -= 1
        }
    }
    return ans
}
```

### 桶排序

计数排序的进阶版。需要注意的点是这么确定桶的个数，以及桶内的数据如何排序

```s
func sort(arr: [Int]) -> [Int]{
    var maxbucket = 0
    var minbucket = 0
    for tmp in arr {
        if tmp > maxbucket {
            maxbucket = tmp
        }else if tmp < minbucket {
            minbucket = tmp
        }
    }
    let diff = maxbucket - minbucket
    // bucketCount 可通过外部参数获取
    let bucketCount = 5
    let count = diff/bucketCount+1
    var ans = [[Int]](repeating: [], count: count)
    for tmp in arr {
        ans[(tmp-minbucket)/count].append(tmp)
    }
    var res = [Int]()
    for array in ans {
        // 对桶内元素排序
        for num in array {
            res.append(num)
        }
    }
    return res
}
```

### 基数排序

基数排序可以看成桶排序的扩展，也是用桶来辅助排序。因为是根据每一位上的数字排序，所以只需要十个桶，代表从 0-9.
引申出来，元素可以根据优先级排序。

```s
func sort(arr: [Int]) -> [Int]{
    var mod = 10
    var dev = 1
    var digit = true
    var buckets = [[Int]](repeating:[] , count: 10)
    var nums = arr
    while digit {
        digit = false
        while nums.count > 0 {
            let num  = nums.removeFirst()
            buckets[num%mod/dev].append(num)
            if num > mod {
                digit = true
            }
        }
        for i in 0..<buckets.count {
            while buckets[i].count > 0 {
                nums.append(buckets[i].removeFirst())
            }
        }
        mod *= 10
        dev *= 10
    }
    return nums
}
```

## 实战题目

- 52.N 皇后
- 191.位 1 的个数
- 231.2 的幂
- 338.比特位计数
- 190.颠倒二进制位
