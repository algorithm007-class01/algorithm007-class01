/**
 * 递归解法
 */

var postorder1 = function(root) {
  const res = []
  helper(root, res)
  return res
};
function helper(node, res) {
  if (node) {
      node.children.forEach(i => helper(i, res))
      res.push(node.val)
  }
}

/**
 * 迭代法
 */
var postorder2 = function(root) {
  const res = []
  const stack = [root]
  while (stack.length) {
    const cur = stack.pop()
    if (!cur) continue
    res.push(cur.val)
    cur.children.forEach((i) => stack.push(i))
  }
  return res.reverse()
};
