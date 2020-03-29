/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func preorder(root *Node) []int {
    res := make([]int, 0)
    recur(root, &res)
    return res
}

func recur(root *Node, res *[]int) {
    if root == nil {
        return 
    }
    *res = append(*res, root.Val)
    for _, c := range root.Children {
        recur(c, res)
    }
}
