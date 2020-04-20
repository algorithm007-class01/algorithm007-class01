/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func postorder(root *Node) []int {
    res := make([]int, 0)
    recur(root, &res)
    return res
}

func recur(root *Node, res *[]int) {
    if root == nil {
        return
    }
    for _, c := range root.Children {
        recur(c, res)
    }
    *res = append(*res, root.Val)
}
