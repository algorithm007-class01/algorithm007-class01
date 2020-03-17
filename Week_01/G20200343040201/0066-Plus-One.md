https://leetcode-cn.com/problems/plus-one/

## 1 题目内容

1. 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

   最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

   你可以假设除了整数 0 之外，这个整数不会以零开头。

   ```
   示例 1:
   
   输入: [1,2,3]
   输出: [1,2,4]
   解释: 输入数组表示数字 123。
   ```

   

   ```
   示例 2:
   
   输入: [4,3,2,1]
   输出: [4,3,2,2]
   解释: 输入数组表示数字 4321。
   ```

## 2 我的思考与实现

这道题，比较直白，直接再leetcode的编辑器编写，调试了。

### 方法1

```java
class Solution {
    public int[] plusOne(int[] digits) {
        //因为开篇就要对最后一个数做加1的操作作为触发，所以此处需要判空以及对数组长度做一个判断
        if (digits == null || digits.length == 0) return digits;
        
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            // 如果这个数等于10，说明需要向前一位进1
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            } else {
                break;
            }
        }
        
        if (digits[0] == 10) {
            /**
             * 如果最后，第一个数等于10，也就是需要进位了。
             * 这个需要新建一个长度加1的新数组作为结果了。
             */
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        } else {
            return digits;
        }
    }
}
```

#### 复杂度

- 时间复杂度: $O(n)$ 

- 空间复杂度: $ O(1) $ 或者 $  O(n)  $

  > 如果是最后不需要进位，就是O(1)，需要进位就要新建一个数组，就是O(n)



## 3 LeetCode其它人解答

https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/



```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```

#### 我的点评

> 这个是leetcode-cn上的一个精选解答。思想跟我的解法是一样的。
>
> 不过他判断是否要进1的方式是，模10求余。我是直接判断是否等于10。相比较下，说不出哪个优劣。其实都差不多。我感觉，我的可能更为直白一些吧。
>
> 而他的做法，我感觉，有点受加n想法的影响。就是，如果题目不再是加1，而是加n的时候。