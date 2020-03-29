package G20200343040161

type Node struct {
	Val      int
	Children []*Node
}

var res []int
func postorder(root *Node) []int {
	res = make([]int, 0)
	stack := make([]*Node, 0)
	var cur *Node
	stack = append(stack, root)
	for len(stack) != 0 {
		cur = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if cur == nil {
			continue
		}
		res = append(res, cur.Val)
		for i := 0; i <= len(cur.Children)-1; i++ {
			stack = append(stack, cur.Children[i])
		}
	}
	x := func(s []int) {
		start, end := 0, len(s)-1
		for start < end {
			s[start], s[end] = s[end], s[start]
			start++
			end--
		}
	}
	x(res)
	return res
}