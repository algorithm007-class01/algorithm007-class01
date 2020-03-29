package G20200343040039

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

type VisitRecord struct {
	node *TreeNode
	isVisit bool
}
//         4
//      /    \
//     2      6
// 	 /	\    / \
// 	1    3  5   7
// 6 2
// 4
// 6 3 1
// 4 2
// 4 2 1 3
// 4 2 1 3 6 5 7
func preorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	stack := make([]*VisitRecord, 0)
	stack = append(stack, &VisitRecord{
		node:root,
		isVisit:false,
	})

	for len(stack) != 0 {
		item := stack[len(stack)-1]
		stack = stack[0:len(stack)-1]

		if item.isVisit == false {
			if item.node.Right != nil {
				stack = append(stack, &VisitRecord{
					node: item.node.Right,
					isVisit: false,
				})
			}

			if item.node.Left != nil {
				stack = append(stack, &VisitRecord{
					node: item.node.Left,
					isVisit: false,
				})
			}

			stack = append(stack, &VisitRecord{
				node: item.node,
				isVisit: true,
			})
		} else {
			result = append(result, item.node.Val)
		}
	}

	return result
}



// func preorderTraversal(root *TreeNode) []int {
// 	result := make([]int, 0)
//
// 	preorderTraversal_rec(root, &result)
//
// 	return result
// }
//
// func preorderTraversal_rec(node *TreeNode, result *[]int) {
// 	if node == nil {
// 		return
// 	}
// 	*result = append(*result, node.Val)
// 	preorderTraversal_rec(node.Left, result)
// 	preorderTraversal_rec(node.Right, result)
// }

