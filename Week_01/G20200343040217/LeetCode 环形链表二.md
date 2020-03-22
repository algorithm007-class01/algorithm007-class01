- 😭 第一次练习 2020年3月10日



### 双指针解法

:::tip

看了100年解释，还是没有看懂，不过代码还是比较简单。

:::

```javascript

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
  // 双指针
  let slow = head;
  let fast = head;

  while (true) {
    if (fast == null || fast.next == null) {
      return null;
    }

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
      break;
    }
  }

  fast = head;
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  return fast;
};
```

