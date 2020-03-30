package G20200343040039


func buildTree(preorder []int, inorder []int) *TreeNode {
	inOrderCache := make(map[int]int, 0)

	for index, value := range inorder {
		inOrderCache[value] = index
	}

	result := buildTree_rec(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1, inOrderCache)
	return result
}
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
func buildTree_rec(preorder []int, preStart, preEnd int, inorder []int, inStart, inEnd int, inOrderCache map[int]int) *TreeNode {
	if preStart > preEnd || inStart > inEnd {
		return nil
	}

	nextParentNode := inOrderCache[preorder[preStart]]
	numsLeft := nextParentNode - inStart

	root := &TreeNode{Val:preorder[preStart]}

	root.Left = buildTree_rec(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, nextParentNode-1, inOrderCache)
	root.Right = buildTree_rec(preorder, preStart + numsLeft + 1, preEnd, inorder, nextParentNode + 1, inEnd, inOrderCache)

	return root
}