/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
//  因为这道题 LeetCode 并不支持使用 Swift，所以我只使用几个比较典型的测试样例，可能并不完全正确

解法一： 迭代
class Solution {

    func postorderNodeTree(_ root: Node?) -> [Int] {
        var ans = [Int]()
        helper(root, &ans)
        return ans
    }
    
    func helper(_ root: Node? , _ ans: inout [Int]) {
        if root != nil {
            if let child = root?.children {
                for item in child {
                    helper(item, &ans)
                }
            }
            ans.append(root!.val!)
        }
    }
}


解法二： 循环
func postorderNodeTree(_ root: Node?) -> [Int] {
        var ans = [Int]()
        var stack = [Node]()
        var tree = root
        
        while  tree != nil || !stack.isEmpty {
            ans.append(tree!.val!)
            if let children = tree?.children {
                for item in children {
                    stack.append(item)
                }
            }
            tree = stack.popLast()
        }
        return ans.reversed()
    }



// @lc code=end