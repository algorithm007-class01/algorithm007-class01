void inorder(struct TreeNode* root,int* returnSize,int *a)/*前序遍历二叉树*/
{
   if(!root) return;
   a[(*returnSize)++]=root->val;
   inorder(root->left,returnSize,a);
   inorder(root->right,returnSize,a);
}
int size(struct TreeNode* root)/*求二叉树数据个数*/
{
   if(!root) return 0;
   return 1+size(root->left)+size(root->right);
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
int treesize=size(root);
     int *a=(int*)malloc(treesize*sizeof(int));
     memset(a,0,treesize);
     *returnSize=0;
     inorder(root,returnSize,a);
     return a;
}