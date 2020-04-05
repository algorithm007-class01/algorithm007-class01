// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 (l-21)
// 示例：
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

// 1. 直接添加即可(迭代), 时间复杂度为: O(m+n). 空间复杂度为: O(1).

var mergeTwoLists = function(l1, l2) {
  if (l1 === null) return l2; // 下面有过判断, 所以这两行可以不要.
  if (l2 === null) return l1;
  const merge = {};
  if (l1.val < l2.val) {
    merge.val = l1.val;
    l1 = l1.next;
  } else {
    merge.val = l2.val;
    l2 = l2.next;
  }
  let pointer = merge;
  while (l1 !== null && l2 !== null) {
    pointer.next = {};
    if (l1.val < l2.val) {
      pointer.next.val = l1.val;
      l1 = l1.next;
    } else {
      pointer.next.val = l2.val;
      l2 = l2.next;
    }
    pointer = pointer.next;
  }
  if (l1 === null) { // 以下可以合并成两行.
    pointer.next = l2;
    return merge;
  }
  if (l2 === null) {
    pointer.next = l1;
    return merge;
  }
};

// const l1 = {
//   val: 1,
//   next: {
//     val: 2,
//     next: {
//       val: 4,
//       next: null
//     }
//   }
// };

// const l2 = {
//   val: 1,
//   next: {
//     val: 3,
//     next: {
//       val: 4,
//       next: null
//     }
//   }
// }

// console.log(mergeTwoLists(l1, l2));

// 2. 递归. 时间复杂度为: O(m + n). 空间复杂度为: O(m + n).

var mergeTwoLists = function(l1, l2) {
  if (l1 === null) return l2;
  if (l2 === null) return l1;

  if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  } else {
    l2.next = mergeTwoLists(l2.next, l1);
    return l2;
  }
}