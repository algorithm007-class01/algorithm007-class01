/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 type Stack struct {
    Val *Node
    Next *Stack
}

func preorder(root *Node) []int {
    ret := []int{}
    if root == nil {
        return ret
    }

    stack := &Stack{
        Val : root,
    }

    for v := stack; v != nil; v = v.Next {
        ret = append(ret, v.Val.Val)
        t := v.Next

        c := v
        for _, vv := range v.Val.Children {
            c.Next = &Stack{
                Val : vv,
            }
            c = c.Next
        }
        c.Next = t
    }

    return ret
}
