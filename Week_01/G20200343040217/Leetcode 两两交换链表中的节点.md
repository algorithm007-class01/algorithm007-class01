[题目地址](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)



- 😭 第一次刷题 2020年3月10日 



### 递归写法📓

:::warning

**时间复杂度：**O（N）,其中 N 指的是链表的节点数量

**空间复杂度：**O（N），递归过程使用的堆栈空间

**有点深奥**，在思考的时候，可以考虑**两个节点**的情况👨🏻‍💻

:::

```javascript
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  // 递归写法
  if (head == null || head.next == null) {
    return head;
  }

  let firstNode = head;
  let secondNode = head.next;

  firstNode.next = swapPairs(secondNode.next);
  secondNode.next = firstNode;

  return secondNode;
};
```



### 迭代写法 😎

:::warning

以前用 Java 做出来，但是现在又忘记了，还需要反复练习才行😬

:::

```javascript
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  // 迭代写法
  let dummyHead = new ListNode(-1);
  dummyHead.next = head;

  let cur = dummyHead;
  while (cur.next != null && cur.next.next != null) {
    let first = cur.next;
    let end = cur.next.next;

    cur.next = end;
    first.next = end.next;
    end.next = first;

    cur = first;
  }
  return dummyHead.next;
};
```

