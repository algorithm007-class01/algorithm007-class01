/*
 * @lc app=leetcode.cn id=236 lang=swift
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
// 官方题解中的父指针
// 通过字典的形式存储 从root 到 p 或 q 的路径，（所有祖先节点）
// 然后将 p 或 q 的路径放入一个 set 中
// 依次向上获取另一个节点的父节点，看其是否在 set 中存在
extension TreeNode: Hashable, Equatable {
    public static func == (lhs: TreeNode, rhs: TreeNode) -> Bool {
        return ObjectIdentifier(lhs) == ObjectIdentifier(rhs)
    }
    public func hash(into hasher: inout Hasher) {
         hasher.combine(ObjectIdentifier(self).hashValue)
    }
}
class Solution {
    func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {

        if root == nil {
            return nil
        }

        var stack = [TreeNode?]()
        var dic = [TreeNode?: TreeNode]()

        stack.append(root)
        // 因为题目条件里说明树里必有 p 和 q，所以可以不判断stack为空
        while !dic.keys.contains(p) ||  !dic.keys.contains(q) && !stack.isEmpty {

            let parent = stack.removeFirst()

            if parent?.left != nil {
                dic[parent?.left] = parent!
                stack.append(parent?.left)
            }

            if parent?.right != nil {
                dic[parent?.right] = parent!
                stack.append(parent?.right)
            }
        }
        var node = p
        var array = [TreeNode?]()
        while dic.keys.contains(node){
            array.append(node)
            node = dic[node] 
        }

        var ans = q
        while !array.contains(ans) {
            ans = dic[ans]
            if ans == nil {
                break
            } 
        }

        return ans
    }
}

// @lc code=end

