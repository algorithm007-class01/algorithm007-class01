package G20200343040039

func preorder(root *Node) []int {
	result := make([]int, 0)

	preorder_rec(root, &result)

	return result
}

func preorder_rec(node *Node, result *[]int) {
	if node == nil {
		return
	}

	*result = append(*result, node.Val)

	for _, child := range node.Children {
		preorder_rec(child, result)
	}
}

// func preorder(root *Node) []int {
//
// 	if root == nil {
// 		return nil
// 	}
//
// 	result := make([]int, 0)
//
// 	stack := make([]*Node, 0)
// 	stack = append(stack, root)
//
// 	for len(stack) != 0 {
// 		current := stack[len(stack)-1]
// 		stack = stack[:len(stack) - 1]
// 		result = append(result, current.Val)
//
// 		for i := len(current.Children)-1; i >= 0; i-- {
// 			if current.Children[i] != nil {
// 				stack = append(stack, current.Children[i])
// 			}
// 		}
// 	}
//
// 	return result
// }