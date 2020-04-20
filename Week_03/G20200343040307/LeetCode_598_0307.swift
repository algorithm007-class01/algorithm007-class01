/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [590] N叉树的前序遍历
 */

// @lc code=start
//  因为这道题 LeetCode 并不支持使用 Swift，所以我只使用几个比较典型的测试样例，可能并不完全正确

解法一： 迭代
class Solution {

  func postorderNodeTree(_ root: Node?) -> [Int] {
        var ans = [Int]()
        var stack = [Node]()
        var tree = root
        
        while  tree != nil || !stack.isEmpty {
            ans.append(tree!.val!)
            if let children = tree?.children {
                for item in children.reversed() {
                    stack.append(item)
                }
            }
            tree = stack.popLast()
        }
        return ans
    }
}


// @lc code=end