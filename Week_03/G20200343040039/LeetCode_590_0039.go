package G20200343040039

type Node struct {
	Val int
	Children []*Node
}

func postorder(root *Node) []int {
	result := make([]int, 0)

	postorder_rec(root, &result)

	return result
}

func postorder_rec(node *Node, result *[]int) {
	if node == nil {
		return
	}

	for _, child := range node.Children {
		postorder_rec(child, result)
	}

	*result = append(*result, node.Val)
}

