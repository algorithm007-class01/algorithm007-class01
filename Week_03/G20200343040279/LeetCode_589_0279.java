<?php
/**
 *N叉树的前序遍历
 */
Class Solution {

	List<Integer> list = new ArrayList<>();
	/**
	 * 递归方式
	 */
	public List<Integer> preOrderNaryTree(Node root) {
		if (root == null) return null;
		list.add(root.val);
		for (Node item:root.children) {
			preOrderNaryTree(item);
		}
		return list;
	}

	/**
	 * 迭代方式借助队列
	 */
	public List<Integer> preOrderNaryTreeIteration(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> output = new LinkedList<>();
		if (root == null) return output;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pollLast();
			output.add(node.val);
			Collections.reverse(node.children);
			for (Node item:node.children) {
				stack.add(item);
			}
		}
		return output;
	}
}
