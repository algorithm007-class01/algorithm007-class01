package G20200343040161

type TreeNode struct {
  Val int
  Left *TreeNode
  Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	res := make([]int, 0)
	stack := make([]*TreeNode, 0)
	var cur *TreeNode
	stack = append(stack, root)
	for len(stack) != 0 {
		cur = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if cur == nil {
			continue
		}
		res = append(res, cur.Val)
		stack = append(stack, cur.Right)
		stack = append(stack, cur.Left)
	}
	return res
}
