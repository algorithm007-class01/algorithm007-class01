var lowestCommonAncestor = function (root, p, q) {
    if (!root) return root;

    if (root == p || root == q) {
        return root;
    }

    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);

    if (left && right) {
        return root;
    } else {
        return left || right || null;
    }
};