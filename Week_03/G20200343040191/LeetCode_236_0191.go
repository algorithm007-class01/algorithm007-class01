/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    if root == nil {
        return nil
    } 
    if root == p || root == q {
        return root
    }

    // Recursive
    l := lowestCommonAncestor(root.Left, p, q)
    r := lowestCommonAncestor(root.Right, p, q)

    if l == nil {
        return r
    } else if r == nil {
        return l
    } else {
        return root
    }
    
    return nil
}
