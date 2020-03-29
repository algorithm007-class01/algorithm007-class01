/**
 * 递归解法
 */
var lowestCommonAncestor = function(root, p, q) {
  if (root === null || root === q || root === p) {
      return root
  }
  const left = lowestCommonAncestor(root.left, p, q)
  const right = lowestCommonAncestor(root.right, p, q)
  if (right && left) {
      return root
  } else if (left) {
      return left
  } else if (right) {
      return right
  }
  return null
};
