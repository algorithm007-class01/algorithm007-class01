## 查找半有序数组中间无序的地方
如 A=[4, 5, 6, 7, 0, 1, 2]
### 思路
#### 1.找到mid
#### 2.如果 A[mid] > A[0], 说明这个无序点在mid右边。
#### 3.如果 A[mid] < A[0]，说明这个无需点在mid左边。
#### 4. 当mid满足如下条件时：
- A[mid] > A[mid+1]，A[mid+1]是最小。
- A[mid] < A[mid-1], A[mid]是最小。

```
 public int findChange(int[] A) {
    int low = 0, high = A.length - 1;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (A[mid] > A[mid + 1]) {
        return A[mid + 1];
      }
      if (A[mid - 1] > A[mid]) {
        return A[mid];
      }
      if (A[mid] > A[0]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
```