https://leetcode-cn.com/problems/combinations/

## 1 题目内容

- 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

  示例:

  ```
  输入: n = 4, k = 2
  输出:
  [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
  ]
  ```



## 2 我的思考与实现



这道题，跟超哥视频说的，括号生成题目，以及子集题目很类似。所以，我是先照着超哥说的方法。

先写出泛型递归模板.

然后第一个目标先是，不管元素的顺序，先把可能都打出来。

### 第一步：先写出泛型递归模板

```java
package myself;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recur(0, k, new ArrayList<>());
        return res;
    }

    private void recur(int level, int maxLevel, List<Integer> tempres) {
        // terminator
        if (level == maxLevel) {
            res.add(new ArrayList<>(tempres));
            return;
        }
        // process current logic
        tempres.add(i);
        // drill down
        recur(level + 1, maxLevel, tempres);
        // restore current status
    }

    public static void main(String[] args) {
        System.out.println(new Solution01().combine(4, 2));
    }
}

```

打印一下会发现，其实，这样只是整个递归树的第一个最小分支而已。

如果我要每个节点都打印出4个（先按照题目的test case），我的递归的某一层应该要有一个循环，这样，我下探到下一层，返回来之后（回溯），我可以在这一层换一个分支继续，继续往下探寻。

### 调整：

```java
package myself;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recur(0, k, new ArrayList<>());
        return res;
    }

    private void recur(int level, int maxLevel, List<Integer> tempres) {
        // terminator
        if (level == maxLevel) {
            res.add(new ArrayList<>(tempres));
            return;
        }
        for (int i = 1; i <= 4; i++) {
            // process current logic
            tempres.add(i);
            // drill down
            recur(level + 1, maxLevel, tempres);
            // restore current status
            tempres.remove(tempres.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution01().combine(4, 2));
    }

}

```

打印出来的结果是这样：

```
[[1, 1], [1, 2], [1, 3], [1, 4], [2, 1], [2, 2], [2, 3], [2, 4], [3, 1], [3, 2], [3, 3], [3, 4], [4, 1], [4, 2], [4, 3], [4, 4]]
```

这样出来的结果，就会包含了重复的结果。但已经很接近想要的效果了。

我们想要的效果，就是后面递归层次加进去的数字要比前面的要大。那么就可以加条件做剪枝。

所以，后面整体调整后，代码如下：

### 最终

```java
package myself;

import java.util.ArrayList;
import java.util.List;

public class Solution01_Final {

    List<List<Integer>> res = new ArrayList<>();
    int range = 0;
    int maxLevel = 0;

    public List<List<Integer>> combine(int n, int k) {
        range = n;
        maxLevel = k;
        recur(0, 0, new ArrayList<>());
        return res;
    }

    /**
     * @param level 递归的层次
     * @param preLevelNum 上一级添加的数字，用来减去一些递归的分支
     * @param tempRes 中间结果
     */
    private void recur(int level, int preLevelNum, List<Integer> tempRes) {
        // terminator
        if (level == maxLevel) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        /**
         * i为preLevelNum + 1，是因为后面放进去的，要比前面的数要大
         */
        for (int i = preLevelNum + 1; i <= range; i++) {
            tempRes.add(i);
            recur(level + 1, i, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution01_Final().combine(4, 3));
    }

}

```

### 复杂度

- 时间复杂度 : $O(k C^k_n) $ 

> 因为最终是有$ C^k_n $ （递归树最底层的节点）个的输出，然后每个节点中会有一个复制长度为k的数组的操作（因为递归传递的list参数是传引用，如果不做复制，放入res中的结果会在递归的时候，会被修改的，所以要复制一份）。

- 空间复杂度 : $ O(k C^k_n) $




## 3 官方解答

https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode/

```java
class Solution {
  List<List<Integer>> output = new LinkedList();
  int n;
  int k;

  public void backtrack(int first, LinkedList<Integer> curr) {
    // if the combination is done
    if (curr.size() == k)
      output.add(new LinkedList(curr));

    for (int i = first; i < n + 1; ++i) {
      // add i into the current combination
      curr.add(i);
      // use next integers to complete the combination
      backtrack(i + 1, curr);
      // backtrack
      curr.removeLast();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    backtrack(1, new LinkedList<Integer>());
    return output;
  }
}
```

我的点评

> 官网的做法，跟我的差不多。
>
> 我是按照超哥的思路，逐步演化出来。递归方法的参数里面，有一个level作为递归终止的判断。官方的，递归终止，直接使用的中间结果数组的长度。
>
> 我感觉，官方的代码注释很好的在传递一个回溯算法的思想。
>
> 希望我自己后面通过多做题，回溯的思维训练熟悉起来，能够很快的直接写出简洁的代码。



### 复杂度分析

- 时间复杂度 : $ O (k C^k_n) $ , 其中是要构成的组合数。append / pop (add / removeLast) 操作使用常数时间，唯一耗费时间的是将长度为 $k$ 的组合添加到输出中。

- 空间复杂度 : $ O(C^k_n) $，用于保存全部组合数以输出。

