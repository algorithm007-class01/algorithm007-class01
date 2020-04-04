package G20200343040161

func levelOrder(root *Node) [][]int {
	if root == nil {
		return [][]int{}
	}
	res := make([][]int, 0)
	queue := make([]*Node, 0)
	queue = append(queue, root)
	for len(queue) != 0 {
		d := make([]int, 0)
		n := len(queue)
		for i := 0; i < n; i++ {
			x := queue[0]
			queue = queue[1:]
			d = append(d, x.Val)
			queue = append(queue, x.Children...)
		}
		res = append(res, d)
	}
	return res
}
