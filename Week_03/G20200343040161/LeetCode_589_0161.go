package G20200343040161

func preorder(root *Node) []int {
	if root == nil {
		return []int{}
	}
	res := make([]int, 0)
	stack := make([]*Node, 0)
	cur := root
	stack = append(stack, root)

	for len(stack) != 0 {
		cur = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		res = append(res, cur.Val)
		for i := len(cur.Children)-1; i >= 0; i-- {
			stack = append(stack, cur.Children[i])
		}
	}
	return res
}
