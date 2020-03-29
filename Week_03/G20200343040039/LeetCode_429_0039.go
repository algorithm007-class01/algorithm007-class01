package G20200343040039



func levelOrder(root *Node) [][]int {
	if root == nil {
		 return nil
	}
	result := make([][]int, 0)

	levelOrder_rec(root, &result, 0)

	return result
}

func levelOrder_rec(node *Node, result *[][]int, level int) {
	if len(*result) <= level {
		levelArr := make([]int, 0)
		*result = append(*result, levelArr)
	}

	(*result)[level] = append((*result)[level], node.Val)

	for _, child := range node.Children {
		levelOrder_rec(child, result, level+1)
	}
}