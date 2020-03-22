/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  if (!l1 || !l2) return l1 || l2; // 入参存在空链表的情况

  let start = null;
  if (l1.val < l2.val) { // 判断第一个节点值得大小，用于初始化结果链表头节点
    start = l1;
    l1 = l1.next;
  } else {
    start = l2;
    l2 = l2.next;
  }

  let end = start; // 定义结果链表尾节点
  while(l1 && l2) { // 遍历两个参数链表，直至其中一个被遍历完成
    if (l1.val < l2.val) { // 比较节点值，同时将小的节点挂到结果链表上
      end.next = l1;
      l1 = l1.next;
    } else {
      end.next = l2;
      l2 = l2.next;
    }
    end = end.next;
  }
  end.next = l1 || l2; // 将未遍历完的链表直接挂在后面
  
  return start; 
};
// @lc code=end

