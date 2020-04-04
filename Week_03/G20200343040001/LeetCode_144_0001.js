/**
 * 递归法
 */
var preorderTraversal_1 = function(root) {
  const res = []
  helper(root, res)
  return res
};
function helper(node, res) {
  if (node) {
      res.push(node.val)
      if (node.left) {
          helper(node.left, res)
      }
      if (node.right) {
          helper(node.right, res)
      }
  }
}

/**
 * 迭代法
 */
var preorderTraversal_2 = function (root) {
  const res = []
  const stack = [root]
  while (stack.length) {
    const cur = stack.pop()
    if (!cur) continue
    res.push(cur.val)
    if (cur.right) {
      stack.push(cur.right)
    }
    if (cur.left) {
      stack.push(cur.left)
    }
  }
  return res
}

/**
 * 颜色标记法
 */
var preorderTraversal_3 = function (root) {
  const [WHITE, GRAY] = [0, 1] // 0 未访问； 1 访问过
  const res = []
  const stack = [[WHITE, root]]
  let color, node
  while (stack.length) {
    [color, node] = stack.pop()
    if (!node) continue
    if (color === WHITE) {
      res.push(node.val)
      stack.push([WHITE, node.right])
      stack.push([GRAY, node])
      stack.push([WHITE, node.left])
    }

  }
  return res
}
