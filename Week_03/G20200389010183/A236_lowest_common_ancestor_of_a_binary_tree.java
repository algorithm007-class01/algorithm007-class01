package com.szp.leetcode.q201_250;

import com.szp.leetcode.common.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A236_lowest_common_ancestor_of_a_binary_tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null)
                return null;
            if(p == q)
                return p;
            if(root == p || root == q)
                return root;
            List<TreeNode> pParents = new LinkedList<>();
            List<TreeNode> qParents = new LinkedList<>();

            findParents(root, p, pParents);
            findParents(root, q, qParents);
            Iterator<TreeNode> pIt = pParents.iterator();
            Iterator<TreeNode> qIt = qParents.iterator();
            TreeNode commonParent = null;
            while(pIt.hasNext() && qIt.hasNext()){
                TreeNode pParent = pIt.next();
                TreeNode qParent = qIt.next();
                if(pParent == qParent)
                    commonParent = pParent;
            }
            return commonParent;
        }
        private boolean findParents(TreeNode root, TreeNode node, List<TreeNode> parents){
            if(null == root)
                return false;
            if(root == node){
                parents.add(0, root);
                return true;
            }
            if(findParents(root.left, node, parents) || findParents(root.right, node, parents)){
                parents.add(0, root);
                return true;
            }
            return false;
        }
    }
}
