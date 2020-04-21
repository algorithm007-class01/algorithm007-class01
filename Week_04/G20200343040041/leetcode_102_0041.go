package G20200343040041

import "container/list"

func levelOrder(root *TreeNode) [][]int {
	var res [][]int
	queue := list.New()
	queue.PushBack(root)
	for queue.Len() > 0 {
		nodes, childQueue := make([]int, 0, queue.Len()), list.New()
		for q := queue.Front(); q != nil; q = q.Next() {
			node := q.Value.(*TreeNode)
			nodes = append(nodes, node.Val)
			childQueue.PushBack(node.Left)
			childQueue.PushBack(node.Right)
		}
		res = append(res, nodes)
		queue = childQueue
	}
	return res
}
