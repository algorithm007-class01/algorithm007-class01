https://leetcode-cn.com/problems/rotate-array/

## 1 题目内容

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```

示例 2:

```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```


说明:

- 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。

- 要求使用空间复杂度为 O(1) 的 原地 算法。



## 2 我的思考与实现

想到的方法：

1. 每次向右移动一步，移动k次
2. 新建一个数组，计算好移动k位后元素的位置，直接放到新数组



### 方法1-每次向右移动一步，移动k次

```java
public class Solution01 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        /**
         * 移动nums.length步，跟原数组是一样的。所以取模.
         */
        k = k % nums.length;
        while (k-- > 0) {
            //每次移动一步
            moveOneStep(nums);
        }
    }

    public void moveOneStep(int[] nums) {
        int endEl = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = endEl;
    }
}
```

#### 复杂度

- 时间复杂度: $ O(n^2) $ 

  > 每移动一步，需要执行n次。最坏的情况，取模后的k为n-1。n*(n-1)。所以时间复杂度是$O(n^2)$

- 空间复杂度: $ O(1) $




### 方法2-新建一个数组，计算好移动k位后元素的位置，直接放到新数组

```java
public class Solution02 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int[] newArr = new int[nums.length];
        k = k % nums.length;
        
        int targetIdx = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newArr[targetIdx++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newArr[targetIdx++] = nums[i];
        }
        
        //将结果放回nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }
}
```

#### 复杂度

- 时间复杂度: $ O(n) $ 

  > 前两个循环加起来才n次，第三个循环n次。所以，最后还是线性时间复杂度。

- 空间复杂度: $ O(n) $



## 3 官方解答

https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/

### 方法 1：暴力

```java
public class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

```

#### 复杂度分析

- 时间复杂度：O(n∗k) 。每个元素都被移动 1 步（O(n)） k次（O(k)） 。
- 空间复杂度：O(1) 。没有额外空间被使用。



#### 我的点评

> 和我的方法1，思想一样。
>
> 不过它没有对k取模，这会导致，k超过数组长度之后，多了很多不必要的执行。



### 方法 2：使用额外的数组

```java
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
```

#### 我的点评

> 和我的方法2，思想大致是一样的。
>
> 但它的精髓在于a[(i + k) % nums.length] = nums[i]; 这句。这句让代码比我的简洁了很多。



### 方法 3：使用环状替换

```java
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
```

#### 复杂度分析

- 时间复杂度：O(n) 。只遍历了每个元素一次。
- 空间复杂度：O(1)。使用了常数个额外空间。



#### 我的点评

> 这个方法是我没有想到的。
>
> 我本来也在想有没有原地算法，可以做到线性时间内 完成。但是想到一个元素，移到它的最终位置的时候，它就会有一种触发了开关的感觉。比如它要填的位置原本的元素该放哪里，如果这个放好了。那本来的位置的元素呢。好像联动起来了。感觉有点难以掌控。
>
> ------------
>
> 但是看了官方的分析，发现，其实移动k位。比如，某一个元素，它的k位后的元素，以及后面再一个k位后的元素，一直下去。如果把数组当一个环，其实会回到这个元素的位置。
>
> 这样的话，就有了可以操作的空间了。因为，你可以做到，每次移动，一个元素以及它后面的k位，2k位等等，跟它形成环的这批元素。而其它的元素就能不受影响。 然后下一次，去移动另一批成环的元素。
>
> ------
>
> 这确实是一个很漂亮的解法。很值得细品。我觉得这也应该是一维数据结构的一个很有意思的特性。
>
> 以后多回来看看，品品。



### 方法 4：使用反转

```java
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```



#### 我的点评

> 这个方法，我没有想到。
>
> 但我觉得这方法，感觉怪怪。参考，借鉴的意义嘛... 我只是个渣渣，不好评说。
>
> 我不会去细品。只能说，有事没事的时候，会去看一下，熟悉一下数组的特性和各种花式操作。