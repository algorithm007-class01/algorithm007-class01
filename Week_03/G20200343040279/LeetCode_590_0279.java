/**
 *后序遍历N叉树
 */
class Solution{

	List<Integer> list = new ArrayList<>();
	public List<Integer> postOrderNaryTree(Node root) {
		if (root == null) return null;

		for (Node node : root.children)
			postOrderNaryTree(node);
		list.add(root.val);
		return list;
	}

	public List<Integer> postOrderNaryTreeIteration(Node root) {
		LinkedList<Integer> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root == null) return null;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.poolLast();
			output.addFirst(node.val);
			for (Node item:node.children)
				if (item != null)
					stack.add(item);
		}
		return output;
	}
}