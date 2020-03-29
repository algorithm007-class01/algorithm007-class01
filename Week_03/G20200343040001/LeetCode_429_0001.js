/**
 * 递归法
 */

var levelOrder_1 = function (root) {
  const res = []
  if (!root) return res
  helper(root, 0, res)
  return res
}
function helper(root, level, res) {
  if (!res[level]) {
    res[level] = [root.val]
  } else {
    res[level].push(root.val)
  }
  for (let v of root.children) {
    helper(v, level + 1, res)
  }
}


/**
 * 广度搜索
 */
var levelOrder_2 = function (root) {
   const res = []
   if (!root) return res
   const queue = [root]
   while (queue.length) {
    const level = []
    const len = queue.length
    for (let i = 0; i < len; i++) {
      const cur = queue.shift()
      level.push(cur.val)
      queue.push(...cur.children)
    }
    res.push(level)
   }
   return res
}
