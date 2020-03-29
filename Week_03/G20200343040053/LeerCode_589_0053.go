package leetcode_week03_G20200343040053

//【589. N叉树的前序遍历】

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
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

func preorder(root *Node) []int {
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
		for i := len(root.Children) - 1; i >= 0; i-- {
			stack = append(stack, root.Children[i])
		}
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)

func preorderSolution2(root *Node) []int {
	ret := make([]int, 0)
	dfsNTreePre(root, &ret)
	return ret
}

func dfsNTreePre(node *Node, ret *[]int) {
	if node != nil {
		*ret = append(*ret, node.Val)
		for _, child := range node.Children {
			dfsNTreePre(child, ret)
		}
	}
}
