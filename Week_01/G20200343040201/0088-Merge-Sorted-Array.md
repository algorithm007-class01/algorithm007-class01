https://leetcode-cn.com/problems/merge-sorted-array/



## 1 题目内容

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

 说明:

- 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
- 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


示例:

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

```



## 2 我的思考与实现

这道题，按照超哥的说法。先不急于动手，先不用理会时间复杂度和空间复杂度，列出所有可能的方法。哪怕是最笨拙的办法。

所以，先列出所有想到的方法，如下：

1. **先合并两个数组，然后排序。**
2. **两个数组各用一个移动的下标（也就是两个指针），一个表示nums1要插入的位置下标。一个表示nums2插入的数据的下标。通过操纵两个指针，一次遍历来完成合并。**

3. **新建一个数组，作为结果数组。也是用两个数组各一个指针，挑选小的值放进结果数组。最后达到合并效果。**

### 方法1-合并后排序

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    //将nums2并到nums1
    for (int i = m, j = 0; j < n; i++, j++) {
        nums1[i] = nums2[j];
    }
    //然后只对m+n个数组元素排序（因为nums1的长度可能大于m+n）
    Arrays.sort(nums1, 0, m + n);
}
```

#### 复杂度

- 时间复杂度: $O((m+n)log(m+n))$ ,

> 因为基于比较的排序算法时间复杂度是$O(nlogn)$

- 空间复杂度: $O(1)$



### 方法2-双指针(不新建数组，原地算法)

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    /**
         * np1为数组nums1的移动指针
         * np2为数组nums2的移动指针
         * 
         * 因为nums2的数组长度小，所以以nums2为基准进行遍历
         */
    for (int np2 = 0, np1 = 0; np2 < n; ) {
        /**
          * 这里的m，被我用作了，代表nums1包含了有效元素的数组长度
          * 
          * 如果np1==m,代表nums1的有效元素已经遍历完.
          * 那么后续要做的事情就是，将nums2的元素直接都搬到nums1后面，不用在做比较了
          */
        if (np1 == m) {
            m++;
            nums1[np1++] = nums2[np2++];
            continue;
        }
        /**
          * 如果nums2[np2] < nums1[np1]，那么就把nums2的元素插入到数组nums1的np1位置
          * 插入后，np2和np1指针同时往后面移动一位，继续后面元素大小的判断
         */
        if (nums2[np2] < nums1[np1]) {
            insert(nums2[np2++], np1++, nums1);
            m++;
        } else {
            np1++;
        }
    }
}

/**
* 往数组中的target位置插入数据data
*/
public void insert(int data, int target, int[] nums) {
    //数组nums的target位置后的数据都网后挪以为
    for (int i = nums.length - 1; i > target; i--) {
        nums[i] = nums[i - 1];
    }
    //target位置填入数据data
    nums[target] = data;
}
```



#### 复杂度

- 时间复杂度 : $O(n*m)$。

  > 因为nums2放一个元素进nums1，数组nums1都要挪动一组元素。
  >
  > 最坏的情况是，nums2的元素都比nums1小，整体插入nums1的头部。nums1有效元素整体挪动n次。
  >
  > 所以，最坏的时间复杂度是 $O(n*m)$

- 空间复杂度 : $O(1)$。



### 方法3-双指针(新建了一个数组)

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 新建一个数组，作为最后的返回结果
    int[] resArr = new int[m + n];
    int np1 = 0, np2 = 0, idx = 0;
    // nums1和2，各一个指针，选出小的放入结果数组resArr中
    while (np2 < n && np1 < m) {
        if (nums2[np2] < nums1[np1]) {
            resArr[idx++] = nums2[np2++];
        } else {
            resArr[idx++] = nums1[np1++];
        }
    }
    // 如果nums1的有效元素先遍历完，结果数组后续的元素，用nums2的填上
    if (np1 == m) {
        while (np2 < n) resArr[idx++] = nums2[np2++];
    }
    // 如果nums2的有效元素先遍历完，结果数组后续的元素，用nums1的填上
    if (np2 == n) {
        while (np1 < m) resArr[idx++] = nums1[np1++];
    }
    
    // 因为最后的结果是nums，所以，将结果数组resArr拷贝到nums1
    while (--idx >= 0) {
        nums1[idx] = resArr[idx];
    }
}
```



## 3 官方解答

https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/

### 方法一 : 合并后排序

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }
}
```

#### 复杂度

- 时间复杂度 : $O((n + m)log(n + m))$。
- 空间复杂度 : $O(1)$。

#### 我的点评

> 官方这个方法与我的解法1，思想是一样的。但它合并两个数组用的是jdk里面的System.arraycopy方法。
>
> 实话实说，我用java也有些年头了,这个方法之前少见。我翻查了一下，这个方法jdk1.2就有了（jdk1.0或者1.1时候有没有，我不确定，因为我手上最早的源码之后1.2）。这个方法是jdk的native方法，也就是它调用的C/C++写的本地方法。效率应该是会比我用循环合并 高一点。



### 方法二 : 双指针 / 从前往后

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Make a copy of nums1.
    int [] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);

    // Two get pointers for nums1_copy and nums2.
    int p1 = 0;
    int p2 = 0;

    // Set pointer for nums1
    int p = 0;

    // Compare elements from nums1_copy and nums2
    // and add the smallest one into nums1.
    while ((p1 < m) && (p2 < n))
      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

    // if there are still elements to add
    if (p1 < m)
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    if (p2 < n)
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
  }
}
```

#### 复杂度分析

- 时间复杂度 : $O(n + m)$
- 空间复杂度 : $O(m)$

#### 我的点评

> 官方这个方法思路与我的解法3是一样的。都是新建一个数组。但是它的解法是copy一个nums1，最后做到直接就用nums1最后结果。而我是新建一个长度为m+n的数组，空间多了点。最后还回填数据给nums1.
>
> 所以，官方的解法确实比我的更加的简洁完美。





### 方法三 : 双指针 / 从后往前

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // two get pointers for nums1 and nums2
    int p1 = m - 1;
    int p2 = n - 1;
    // set pointer for nums1
    int p = m + n - 1;

    // while there are still elements to compare
    while ((p1 >= 0) && (p2 >= 0))
      // compare two elements from nums1 and nums2 
      // and add the largest one in nums1 
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
  }
}
```

#### 复杂度分析

- 时间复杂度 : $O(n + m)$
- 空间复杂度 : $O(1)$

#### 我的点评

> 我的方法2也是原地算法，但是从前往后插入，时间复杂度很高。
>
> 官方的这个从后往前，时间复杂度低。很好的思路！

