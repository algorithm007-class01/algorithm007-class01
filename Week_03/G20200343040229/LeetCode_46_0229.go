/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 func postorder(root *Node) []int {
    var f func(head *Node)
    ret := make([]int, 0)
    f = func(head *Node) {
         if head != nil {
            for _, e := range head.Children {
                  f(e)          
            }
            ret = append(ret, head.Val)
        }
    }
    f(root)
    return ret 
}