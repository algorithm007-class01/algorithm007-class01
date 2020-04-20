https://leetcode-cn.com/problems/move-zeroes/

## 1 题目内容

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```


说明:

1. 必须在原数组上操作，不能拷贝额外的数组。

2. 尽量减少操作次数。

   

## 2 我的思考与实现

这道题，我想到的方法：

1. **新建一个数组放结果，遍历nums，将非零的元素先放新数组，后面填0。**
2. **双指针，慢指针指向填充的非零元素的位置，快指针遍历整个数组。剩下的元素填0.**
3. **也是双指针，一遍遍历，这样就不用回来再填0了**



> PS：其实，在预习做题的时候，我想到的也只是方法1。
>
> 然后，看完视频，知道双指针这个套路，做作业的时候，就有后面两种方法。特别是方法3，有点妙。不像1，2那么直白。没看视频前，没那么容易想到。



### 方法1-新建一个数组

```java
public class Solution01 {
    public void moveZeroes(int[] nums) {
        //新建一个数组
        int[] newArr = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            //提取出非0元素放到新数组
            if (nums[i] != 0) {
                newArr[j++] = nums[i];
            }
        }
        // 将结果放回到nums
        int i = nums.length;
        while (i-- > 0) {
            nums[i] = newArr[i];
        }
    }
}
```

#### 复杂度

- 时间复杂度: $O(n)$ 

- 空间复杂度: $ O(n) $

  > 新建了一个长度为n的数组



### 方法2-双指针，快指针遍历完后，回来填0

```java
public class Solution02 {
    public void moveZeroes(int[] nums) {
        int target = 0; //填写非0元素的下标
        for (int i = 0; i < nums.length; i++) {
            // 快指针如果找到非零元素，填到target所指的位置
            if (nums[i] != 0) {
                nums[target++] = nums[i];
            }
        }
        //剩余的位置填0
        while (target < nums.length) {
            nums[target++] = 0;
        }
    }
}
```

#### 复杂度

- 时间复杂度: $O(n)$ 

> 第一个遍历，执行n次。第二个遍历执行，最坏是n次。就算两个循环是2n次。O(2n)也是O(n)。这是O这个符号的数学定义决定的。

- 空间复杂度: $ O(1) $




### 方法3-双指针,一次遍历

```java
public class Solution03 {
    public void moveZeroes(int[] nums) {
        for (int i = 0, target = 0; i < nums.length; i++) {
            // 如果快指针找到非零元素，如果是0，就越过去
            if (nums[i] != 0) {
                /**
                 * 如果快慢指针不相等，说明快指针之前已经跨过了0元素 
                 * 并且此时target指向的是0，这个时候把快指针所指的元素值给慢指针所指的位置
                 * 快指针所指元素赋0（相当交换值）
                 */
                if (target != i) {
                    nums[target] = nums[i];
                    nums[i] = 0;
                }
                // 慢指针所指位置填了一个非零值，加1，继续往后面推进
                target++;
            }
        }
    }
}
```

#### 复杂度

- 时间复杂度: $O(n)$ 

- 空间复杂度: $ O(1) $



## 3 官方解答

https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/



官方的三种解法，我也去看了。其实，跟我上面写的三种写法思想是一样的。

就不再粘贴出来，点评了。