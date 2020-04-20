[题目地址](https://leetcode-cn.com/problems/linked-list-cycle/)



- 😣 第一次练习 2020年3月14 太粗心了，这个题，自己以前做个还记得是作对了的，结果各种小知识点错。
- :shit: 第二次练习 



### 迭代解法

解题代码

```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 自己能想到的思路，使用双指针
    /**
     * 定义两个指针分别指向两条链表的头节点，loop ，比较大小小的就放入新的链表中
     */

    let dummyHead = new ListNode(-1);
    let res = dummyHead;
    let l = l1, r = l2;
    while(l != null && r != null) {
        if (l.val >= r.val) {
            res.next = r;
            r = r.next;
        } else {
            res.next = l;
            l = l.next;
        }
        res = res.next;
    }
    if (l != null) {
        res.next = l;
    }
    if (r != null) {
        res.next = r;
    }
    return dummyHead.next;
};
```



### 递归解法

:::tip

链表具有天然的递归结构，这句话真的没有错，`leetcode` 上的所有题目，应该都可以通过递归求解。

:::

```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 递归解法
    if (l1 == null) {
        return l2;
    } else if (l2 == null) {
        return l1;
    } else if (l1.val > l2.val) {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    } else {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
    
};
```



### 易错点

- 在判断节点大小的时候，需要注意判断节点相等的情况。
- 注意**虚拟头结点**的应用，需要有一个节点来承接，不然到最后找不到头节点。
