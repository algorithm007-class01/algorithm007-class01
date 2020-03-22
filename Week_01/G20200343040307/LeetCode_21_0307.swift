/*
 * @lc app=leetcode.cn id=21 lang=swift
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */
//  解法一： 非递归
class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        if l1 == nil {
            return l2
        }
        
        if l2 == nil {
            return l1
        }
        
        var first = l1
        var second = l2
        var res = ListNode.init(0)
        var prev = res
        while first != nil && second != nil {
            if first!.val < second!.val {        
                prev.next = first
                first = first?.next
            }else {
                prev.next = second
                second = second?.next
            }
            prev = prev.next!
        }
			// 循环的跳出条件是其中一个链表指向了尾节点，需要把另一个链表接上
        prev.next = first ?? second
        return res.next
    }
}

// 解法二： 递归
class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        if l1 == nil {
            return l2
        }
        
        if l2 == nil {
            return l1
        }
        
        if l1!.val < l2!.val {
            l1?.next = mergeTwoLists(l1?.next, l2)
            return l1
        }else{
            l2?.next = mergeTwoLists(l1, l2?.next)
            return l2
        }
    }
}
// @lc code=end

