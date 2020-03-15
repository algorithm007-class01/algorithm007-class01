/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 */
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
// 1. 链表转化成数组进行操作
// const nodeToList = node => {
//   let li = node
//   let list = []
//   while (li) {
//     list.push(li.val)
//     li = li.next
//   }
//   return list
// }
// var mergeTwoLists = function(l1, l2) {
//   if (l1 || l2) {
//     let fullList = nodeToList(l1).concat(nodeToList(l2))
//     for (let i = 0; i < fullList.length - 1; i++) {
//       for (let j = 0; j < fullList.length - 1 - i; j++) {
//         if (fullList[j] > fullList[j + 1]) {
//           let temp = fullList[j]
//           fullList[j] = fullList[j + 1]
//           fullList[j + 1] = temp
//         }
//       }
//     }
//     let firstNode = new ListNode(fullList.shift())
//     fullList.reduce((prev, next) => {
//       let li = new ListNode(next)
//       prev.next = li
//       return li
//     }, firstNode)
//     return firstNode
//   } else {
//     return l1
//   }
// }

// 2. 递归
var mergeTwoLists = function(l1, l2) {
  if (!l1) {
    return l2
  }
  if (!l2) {
    return l1
  }
  if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2)
    return l1
  } else {
    l2.next = mergeTwoLists(l1, l2.next)
    return l2
  }
}
