https://leetcode-cn.com/problems/merge-two-sorted-lists/

## 1 题目内容

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```



## 2 我的思考与实现

这道题，想到的也就是双指针。做起来，不算难，直接开干。

### 方法1

```java
public class Solution01 {

    /**
     * Definition for singly-linked list.
     * public class essential.ListNode {
     * int val;
     * essential.ListNode next;
     * essential.ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 建立一个头节点，以便用来持有 结果链表的指针。
         * 这是一些链表题目的常规操作了。
         */
        ListNode resHead = new ListNode(-1);
        ListNode point = resHead;	//哨兵
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
                point = point.next;
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        /**
         * 如果其中一个链表遍历完了，另一个链表直接接到结果链表后面
         */
        point.next = (l1 == null) ? l2 : l1;
        return resHead.next;
    }

}

```

#### 复杂度

- 时间复杂度: $O(m+n)$ 

  > 因为两个链表的节点最多都只遍历一次。

- 空间复杂度: $O(1)$

  > 只新建了两个指针。





## 3 官方解答

https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/

### 方法 1：递归

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
```

#### 复杂度分析

- 时间复杂度：O(n + m)。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。

- 空间复杂度：O(n + m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + m个栈帧会消耗 O(n + m) 的空间。

#### 我的点评

> 这个递归想法，我是真没想到，确实有点妙。
>
> 不过递归会消耗方法调用所需的栈空间。最坏情况下，可能需要n+m层调用，才到达递归终止条件，然后再return回来。



### 方法 2：迭代

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
```

#### 复杂度分析

- 时间复杂度 : $O(n+m)$
- 空间复杂度 : $ O(1) $

#### 我的点评

> 官方这个方法，跟我的方法是一样的。
>
> 头节点，哨兵指针，是关键利器。
>
> 不过官方，将两个元素相等的情况合并到小于等于<=，而我元素相等时，直接将相等两个元素连接起来。最还是官方的，更为简洁。
>
> 也不是说，我不知道合并起来。只不过思考过程中，会无意间将相等作为另一种情况，所以相应的代码就写了出来了。其实，很多题目（不单是链表），相等的情况，其实是可以合并<=或者>=的。
>
> 这个以后留个心眼，方便写出更简洁的代码。


