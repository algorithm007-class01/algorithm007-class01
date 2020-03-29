package G20200343040043

// 429. N叉树的层序遍历
// 题目：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
// 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

// 解法
// 前序遍历：输出父节点再遍历叶子节点，递归, 同时记录层高

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

type Node struct {
	Val      int
	Children []*Node
}

func levelOrder(root *Node) [][]int {
	var res [][]int
	traversal(root, &res, 0)
	return res

}

func traversal(node *Node, res *[][]int, level int) {
	if node == nil {
		return
	}
	if len(*res)-1 < level {
		*res = append(*res, []int{node.Val})
	} else {
		(*res)[level] = append((*res)[level], node.Val)
	}

	for _, c := range node.Children {
		traversal(c, res, level+1)
	}

}

// times: 1
