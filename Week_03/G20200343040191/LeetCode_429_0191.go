/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func levelOrder(root *Node) [][]int {
    res := make([][]int, 0)
    if root == nil {
        return res
    }
    que := []*Node{root}
    for len(que) != 0 {
        next := []*Node{}
        line := []int{}
        for _, r := range que {
            line = append(line, r.Val)
            for _, c := range r.Children {
                next = append(next, c)
            }
        }
        res = append(res, line)
        que = next
    }
    return res
}
