/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    res := make([]int, 0)
    recur(root, &res)
    return res
}

func recur(root *TreeNode, res *[]int) {
    if root == nil {
        return 
    }
    *res = append(*res, root.Val)
    recur(root.Left, res)
    recur(root.Right, res)
}
