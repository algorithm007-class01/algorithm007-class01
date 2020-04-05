https://leetcode-cn.com/problems/two-sum/

## 1 题目内容

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```



## 2 我的思考与实现

想到的方法：

1. **使用哈希表，一次遍历**
2. **暴力法(枚举)**
3. **也是使用哈希表，两次遍历**



>有一说一，因为2 sum问题很经典，而且是leetcode第一题。很久前就做过这题了，知道了哈希表是关键。
>
>所以，在做这题的时候，第一次想到和直接写出的解法，是"哈希表+一次遍历"。
>
>反倒是，在写这个文档的时候，才特地写了后面两种解法。



### 方法1-哈希表，一次遍历

```java
import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                // 这里放进去hashmap的是"与target的差值"，是一个小的关键点
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}

```

#### 复杂度

- 时间复杂度: $ O(n) $ 

  > 数组的一次遍历是n次操作，哈希表查询和插入的平均时间复杂度是O(1)。

- 空间复杂度: $ O(n)  $

  > 最坏的情况下，哈希表的有效size是n-1。但实际上，哈希表占用的空间肯定是比n大不少。大多少，这个看哈希表的定义的初始容量和负载因子。



### 方法2-暴力法(枚举)

```java
public class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        // 这是两层循环枚举的模板代码了
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```

#### 复杂度

- 时间复杂度: $ O(n^2) $ 
- 空间复杂度: $ O(1)  $




### 方法3-哈希表，两次遍历

```java
public class Solution03 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                int idx = map.get(need);
                // 注意不能用同一个元素
                if (i != idx) {
                    return new int[]{i, idx};
                }
            }
        }
        return null;
    }

}
```

#### 复杂度

- 时间复杂度: $ O(n) $ 

  > 两次遍历的效率肯定是比方法1低的。但根据大O的定义，它的复杂度依然是O(n)

- 空间复杂度: $ O(n) $





## 3 官方解答

https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/



### 方法一：暴力法

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

我的点评

> 和我的方法2一样。不过最后没有return语句，用抛出异常来做处理。
>
> 这种写法，在写工程代码时候，一般很少这样处理，当然也可能是我见识少。但我不习惯这样处理，以避免一些不必要的麻烦。因为，找不到是一种结果，不应该是一种异常。作为异常抛出，需要写额外的try-catch代码处理。如果不注意处理，还异常还可能触发事务相关的内容。而返回null，是一种"预期结果"，是可控的，这样代码语义更明确。



### 方法二：两遍哈希表

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

```

#### 我的点评

> 和我的方法3，解法一样



### 方法三：一遍哈希表

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

#### 我的点评

> 和我的方法1，解法一样