[题目地址](https://leetcode-cn.com/problems/linked-list-cycle/)



- 😣 第一次练习 2020年3月9日
- :shit: 第二次练习 2020年3月11日 也不是很难，不过为啥就是做错了呢？还是要多加练习才行。
- 🙄 第三次练习 2020年3月12日 边界，错误判断还是需要的，不然很容易出错



### 快慢指针

::: tip

以前做过这个题，思路还是记得住, 不过有点不会写了 😏

:::

2020年3月9日17:52:41

```javascript
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    // 快慢指针
    if (head == null || head.next == null) 
        return false;
    
    let slow = head, fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) 
            return false;
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
};
```



利用 **JSON.stringify()** 不能字符串化循环引用的特性，不过速度比较慢

2020年3月9日17:59:00

```javascript
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    // 利用 JSON.stringfiy()
    try {
        JSON.stringify(head);
        return false;
    } catch(err) {
        return true;
    }
};
```



### 易错点

- 以是否相等 `slow !=  fast` 作为结束条件，而不是以是否还有下一个元素作为结束条件 `fast.next != null && fast.next.next != null`
- 需要判断链表为空或者链表只有一个元素的情况。需要特殊处理一下

