var preorderTraversal = function(root) {
  const result = [];

  while (root) {
    if (root.left === null) {
      result.push(root.val);
      root = root.right;
    } else {
      let predecessor = root.left;
      while (predecessor.right !== null && predecessor.right !== root) {
        predecessor = predecessor.right;
      }

      if (predecessor.right === null) {
        predecessor.right = root;
        result.push(root.val);
        root = root.left;
      } else {
        predecessor.right = null;
        root = root.right;
      }
    }
  }
  return result;
};