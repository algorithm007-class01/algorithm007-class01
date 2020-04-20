class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        preorderTraversal(res,root);
        return res;
    }
    private void preorderTraversal(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorderTraversal(res,root.left);
        preorderTraversal(res,root.right);
    }

    //首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，所以我们优先将头结点
    //加入Stack，然后打印。之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }

        }
        return res;
    }

}