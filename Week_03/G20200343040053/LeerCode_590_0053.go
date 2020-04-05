package leetcode_week03_G20200343040053

//【590. N叉树的后序遍历】

//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */
func postorder(root *Node) []int {
	ret := make([]int, 0)
	if root == nil {
		return ret
	}
	stack := make([]*Node, 0)
	stack = append(stack, root)

	for len(stack) > 0 {
		root = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		ret = append(ret, root.Val)
		for _, child := range root.Children {
			stack = append(stack, child)
		}
	}
	reverse(ret)
	return ret
}

func reverse(slice []int) {
	for i, j := 0, len(slice)-1; i < j; i, j = i+1, j-1 {
		slice[i], slice[j] = slice[j], slice[i]
	}
}

//leetcode submit region end(Prohibit modification and deletion)

func postorderSolution2(root *Node) []int {
	ret := make([]int, 0)
	dfs3(root, &ret)
	return ret
}

func dfs3(node *Node, ret *[]int) {
	if node == nil {
		return
	}
	for _, child := range node.Children {
		dfs3(child, ret)
	}
	*ret = append(*ret, node.Val)
}
