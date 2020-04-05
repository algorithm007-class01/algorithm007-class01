
int size(struct Node* root)/*求n树数据个数*/
{
    int sum=0;
   if(!root) return 0;
   else{
       sum=1;
        for(int i=0;i<root->numChildren;i++)
        {
            sum+=1+size(root->children[i]);
        }
    }
   return sum;
}
void pOrder(struct Node* root,int* returnSize,int *a)/*前序遍历n叉树*/
{
   if(!root) return;
     a[(*returnSize)++]=root->val;
   for(int i=0;i<root->numChildren;i++)
   {
       pOrder(root->children[i],returnSize,a);
   }
}

int* preorder(struct Node* root, int* returnSize)
{
    int Nodesize=size(root);
    int *a=(int*)malloc(Nodesize*sizeof(int));
    memset(a,0,Nodesize);
    *returnSize=0;
    pOrder(root,returnSize,a);
    return a;
}