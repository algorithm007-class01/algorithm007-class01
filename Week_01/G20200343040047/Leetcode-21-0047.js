/**
 * 21. 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 * 递归实现
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
// 递归处理 时间复杂度 O(n) 空间复杂度 O(1)
var mergeTwoLists_1 = function(l1, l2) {
  // 当l1为空时直接返回l2
  if (l1 == null) {
    return l2;
  }
  // 当l2为空时直接返回l1
  if (l2 == null) {
    return l1;
  }
  // 当前 l1 节点的值 与 l2 节点的值进行比较
  // 将其中链表中较小节点的 next 指向此较小节点的 next 与另一个列表中当前值的比较中返回的较小的节点
  if (l1.val <= l2.val) {
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  } else {
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
  }
};
// while 循环处理 时间复杂度 O(n) 空间复杂度 O(n)
var mergeTwoLists_2 = function(l1, l2) {
  // 创建新的链表
  var prevHead = new ListNode(-1);
  // 将新创建的链表进行复制，用来存储未排序的链表节点
  var prevNode = prevHead;
  // 直到 l1 或 l2 为空时停止循环
  while (l1 != null && l2 != null) {
    // 比较 l1 和 l2 中值较小的那一个移新创建的链表中
    if (l1.val <= l2.val) {
      prevNode.next = l1;
      l1 = l1.next;
    } else {
      prevNode.next = l2;
      l2 = l2.next;
    }
    //存储还未排序的节点
    prevNode = prevNode.next;
  }
  // 存储剩余为未进行比较已排序的链表节点
  prevNode.next = l1 ? l1 : l2;
  // 返回已经排序好的节点链表
  return prevHead.next;
};
