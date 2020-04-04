
int size(struct Node* root)/*求n叉树的数据个数*/
{
    int sum=0;
   if(!root) return 0;
   else{
       sum=1;
        for(int i=0;i<root->numChildren;i++)
        {
            sum+=size(root->children[i])+1;
        }
    }
   return sum;
}
void pstOrder(struct Node* root,int* returnSize,int *a)/*后序遍历n叉树*/
{
   if(!root) return;
   for(int i=0;i<root->numChildren;i++)
   {
       pstOrder(root->children[i],returnSize,a);
   }
   a[(*returnSize)++]=root->val;
}

int* postorder(struct Node* root, int* returnSize)
{
    int Nodesize=size(root);
    int *a=(int*)malloc(Nodesize*sizeof(int));
    memset(a,0,Nodesize);
    *returnSize=0;
    pstOrder(root,returnSize,a);
    return a;
}