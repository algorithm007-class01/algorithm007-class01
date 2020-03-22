[题目地址](https://leetcode.com/problems/reverse-linked-list/)



- 🤬 第一次练习 2020年3月10日
- :smiley: 第二次练习 2020年3月14日 第一次练习还是很懵的，参考了人家的[题解](https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/k%E4%B8%AA%E4%B8%80%E7%BB%84%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8.md)，加上反复练习，终于还是比较清晰了



### 双指针解法

::: warning

我居然看到自己以前通过过，但是现在一点理解不到。💀

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
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    /**
     * 定义三个变量  prev, cur, next
     * prev 执行已经翻转的链表部分
     * cur, next 指向即将要翻转链表部分的头节点
     * loop next = cur.next; cur.next = prev; // 翻转链表之后
     * 更新指针, prev, cur 都向前移动
     * prev = cur;
     * cur = next;
     **/

     let prev = null, cur = head, next = head;
     while(cur != null) {
         next = cur.next;
         cur.next = prev;
         prev = cur;
         cur = next;
     }

     return prev;
};
```



### 递归写法

```javascript
/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  // 递归写法
  if (head == null || head.next == null) {
    return head;
  }

  let curr = reverseList(head.next);

  head.next.next = head;
  head.next = null;

  return curr;
};
// @lc code=end

```



### 利用 ES6 的另类写法，不过内存占用较高:ox:

```javascript
/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  let [prev, curr] = [null, head];

  while (curr) {
    [curr.next, prev, curr] = [prev, curr, curr.next];
  }

  return prev;
};
// @lc code=end

```

