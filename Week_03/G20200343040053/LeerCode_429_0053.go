package leetcode_week03_G20200343040053

//【429. N叉树的层序遍历】

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func levelOrder(root *Node) [][]int {
	ret := make([][]int, 0)
	helper(root, 0, &ret)
	return ret
}

func helper(node *Node, depth int, ret *[][]int) {
	if node == nil {
		return
	}

	for _, child := range node.Children {
		helper(child, depth+1, ret)
	}

	for len(*ret) <= depth {
		*ret = append(*ret, []int{})
	}
	(*ret)[depth] = append((*ret)[depth], node.Val)
}

//leetcode submit region end(Prohibit modification and deletion)
