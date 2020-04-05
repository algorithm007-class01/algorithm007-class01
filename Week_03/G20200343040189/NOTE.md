学习笔记

### 最小的K个数

#### 利用大顶堆的特性来解题

首先，利用优先级队列来实现一个大小为k的大顶堆（默认是小根堆，需要重写比较器的规则）。对数组进行遍历，首先判断大顶堆中元素数目是否小于k，如果小于k则将当前元素放入堆中；如果不小于k则判断该元素与堆顶元素的大小：该元素若小于堆顶元素，则将堆顶元素poll掉，将该元素放入堆中。最后返回堆中元素，此时堆中元素为最小的k个数。

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr == null) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写比较器
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : arr) {
            // 如果堆的大小小于k，将当前数字放入堆中
            if (queue.size() < k) {
                queue.offer(i);
            } 
            // 如果当前数字小于大根堆堆顶，先poll掉堆顶，再将该数字放入堆中
            else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        // 返回堆中的元素
        int[] res = new int[queue.size()];
        int idx = 0;
        for (int num : queue) {
            res[idx++] = num;
        }
        return res;
    }
}
```

#### 

## 递归相关学习笔记

### 递归-循环

通过函数体来进行的循环



### 树的大部分面试题解法一般都是递归

- 节点的定义
- 重复性（自相似性）

```java
public void recur(int level, int param){
    // terminator 递归终结条件
    if (level > MAX_LEVEL) {
        // process result
        return ;
    }
    // process current logic 处理当前层逻辑
    process(level, param);
    // drill down 携带变量下探到下一层
    recur(level: level + 1, newParam);
    //restore current status 清理当前层的状态
}
```



### 写好递归要考虑的事项

1. 想明白递归的终止条件
2. 递归的当前层过程逻辑
3. 向下一层探索（函数不同层之间传递变量）：发生和携带变化
4. 回收状态 
5. 不要人肉递归
6. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
7. 数学归纳法思维

