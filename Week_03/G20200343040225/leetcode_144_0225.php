/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    private $res;
    public function __construct() {
        $this->res = [];
    }
    function preorderTraversal($root) {
        if($root === null) return [];
        array_push($this->res, $root->val);
        $this->preorderTraversal($root->left);
        $this->preorderTraversal($root->right);
        return $this->res;
    }
}
