package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class LeetCode_144_0333 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null==root) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>(); 
        //preorderTraversal(root,stack,list);
        preorderTraversalMls(root,list);
        return list;
    }

    /**
     * 普通迭代
     * @param root
     * @param stack
     * @param list
     */
    private void preorderTraversal(TreeNode root, Stack<TreeNode> stack,List<Integer> list) {
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(null!=node.right) stack.push(node.right);
            if(null!=node.left) stack.push(node.left);
        }
    }

    private void preorderTraversalMls(TreeNode root, List<Integer> list) {
        TreeNode curNode=root;
        
        while(curNode!=null){
            list.add(curNode.val);
            if(curNode.left==null){
                
                curNode=curNode.right;
            }else{
                TreeNode pre=curNode.left;
                while(null!=pre.right&&pre!=curNode){
                    pre=pre.right;
                }
                pre.right=curNode.right;
                TreeNode temp=curNode;
                curNode=curNode.left;
                temp.left=null;
            }
            
            
        }
    }
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
}