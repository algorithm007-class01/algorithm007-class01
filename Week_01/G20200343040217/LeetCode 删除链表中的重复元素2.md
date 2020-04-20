[题目地址](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)

- 💃🏻 第一次练习 2020年3月13日 看题解，只希望自己能坚持下去，坚持下去就是胜利

  


###  迭代解法

链表的题，是真的难。可能还是练习太少了

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
var deleteDuplicates = function(head) {
    if (head == null || head.next == null) {
        return head;
    }

    /**
     * 1. set dummyHead, dummyHead.next = head; cur -> dummyHead.next;
     * 2. loop cur, cur!= null, val -> cur.val, if cur.next.val == val
     * 3.temp = cur.next.next, loop temp != null && temp.val = val; temp = temp.next
     */

    let dummyHead = new ListNode(-1);
    dummyHead.next = head;

    let cur = dummyHead;

    while (dummyHead.next != null) {
        let v = dummyHead.next.val;
        if (dummyHead.next.next != null && v == dummyHead.next.next.val) {
            let temp = dummyHead.next.next;
            while(temp != null && temp.val == v) {
                temp = temp.next;
            }
            dummyHead.next = temp;
        }else {
            dummyHead = dummyHead.next;
        }
    }

    return cur.next;

};
```



### 双指针解法

:warning: 看了人家的代码，还是没有理解到。等到后面的时候再回过头来看吧

```javascript
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    // double pointer
    let dummyHead = new ListNode(-1);
    dummyHead.next = head;

    let slow = dummyHead;
    let fast = head;

    while(fast != null && fast.next != null) {
        if (fast.val != fast.next.val) {
            if (slow.next == fast) {
                slow = fast;
            } else {
                slow.next = fast.next;
            }
        }
        fast = fast.next;
    }
    if (slow.next != fast) {
        slow.next = fast.next;
    }
    return dummyHead.next;

};
```



### 递归解法

递归写法，我惊了:ox::beers:

```javascript
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (head == null) {
        return head;
    }
    if (head.next != null && head.val == head.next.val) {
        while(head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    } else {
        head.next = deleteDuplicates(head.next);
    }
    return head;
};
```



### 易错点