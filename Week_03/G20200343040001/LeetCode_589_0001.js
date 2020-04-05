/**
 * 递归法
 */
var preorder1 = function(root) {
  const res = []
  helper(root, res)
  return res
};
function helper(node, res) {
  if (node) {
      res.push(node.val)
      node.children.forEach(i => helper(i, res))
  }
}

/**
 * 迭代法
 */
var preorder = function(root) {
  const res = []
  const stack = [root]
  while (stack.length) {
    const cur = stack.pop()
    if (!cur) continue
    res.push(cur.val)
    cur.children.reverse().forEach(i => stack.push(i))
  }
  return res
};