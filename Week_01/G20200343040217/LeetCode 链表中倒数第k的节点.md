[题目地址](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof//)



- :smile: 第一次练习 2020年3月13日 终于有一个题做一次就会了 :ox::beers:
- :shit: 第二次练习 



### 快慢指针

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
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var getKthFromEnd = function(head, k) {

    let slow = head;
    let fast = head;
    // 快慢指针
    for (let i = 0; i < k; i ++) {
        fast = fast.next;
    }
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
};
```



进阶代码，可以使用变量 `t` ，减少一次 `for` 循环

```javascript
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var getKthFromEnd = function(head, k) {

    let slow = head, fast = head, t = 0;
    while (fast != null) {
        if (t++ >= k) 
            slow = slow.next;
        fast = fast.next;
    }
    return slow;
};
```



### 易错点

- 进阶代码中，注意变量 `t`是 `>=` k
