题目地址



- :sob: 第一次练习 2020年3月10 太难了
- :joy: 第二次练习 2020年3月14 看了人家的题解，感觉懂了那么一点点意思，又感觉没懂。后面再接着练习几次吧。



:::warning

直接看题解，都不解释了。关键现在还没有看懂。:joy:

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
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
   
   /**
    * 这是一个大问题，需要借助小问题的解来分解答案。
    * 每次翻转 k 的元素，而后后面又是一条链表，这是一个天然的递归结构。
    * 递归的最小子问题就是，如果节点不是k的整数倍，那么剩余的节点就保持原来的顺序
    */

    if (head == null) {
        return null;
    }
    let l = head, r = head;

    // 循环判断是否满足k个节点
    for (let i = 0 ; i < k ; i ++) {
        // 表示剩余节点不足k的元素
        if (r == null) 
            return head;
        r = r.next;
    }
    
    // 翻转 a - b 之间的链表
    let newNode = reverse(l, r);
    l.next = reverseKGroup(r, k);
    return newNode;
};

/**
 * 翻转节点a 到节点 b的链表
 */
var reverse = function(a, b) {
    let prev = null, cur = a, next = a;
    while(cur != b) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
```

