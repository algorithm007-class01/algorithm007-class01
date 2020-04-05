

// MARK: LeetCode 144. 二叉树的前序遍历
/*
    给定一个二叉树，返回它的 前序 遍历。

    示例:
    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,2,3]
*/

class Solution {
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        var result = [Int]()
        guard let node = root else { return []}
        result.append(node.val)
        result += preorderTraversal(node.left)
        result += preorderTraversal(node.right)
        return result
    }
}

public class TreeNode {
         public var val: Int
         public var left: TreeNode?
         public var right: TreeNode?
         public init(_ val: Int) {
             self.val = val
             self.left = nil
             self.right = nil
         }
}
