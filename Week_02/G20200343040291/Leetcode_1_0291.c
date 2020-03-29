//记录节点的结构体
 struct node
 {
     int value; //数组数值
     int pos;  //数组元素位置
     struct node*next;//记录下一个节点
 }

//hash单元，存储 (target-nums[i])
 struct hash
 {
     struct node* add; 
 }

 void hashfree(struct hash *point,int num)
 {
     for(int i=0;i<num;i++)
     {
         if(point[i].add)
         {
             struct node*Node=point[i].add;
             while(Node)
             {
                 struct node*NextNode=Node->next;
                 free(Node);
                 Node=NextNode;
             }
         }
     }
     free(point);
 }
int* twoSum(int* nums, int numsSize, int target, int* returnSize)
{
struct hash *const hashTable=(struct hash*)malloc(sizeof(struct hash)*numsSize);
for(int i=0;i<numsSize;i++)
{
    hashTable[i].add=NULL;
}
for(int i=0;i<numsSize;i++)
{
    struct node *Node=(struct node*)molloc(sizeof(struct node));
    Node->value=nums[i];
    Node->pos=i;
    int mod=abs(nums[i])%numsSize;
    
    Node->next=hashTable[mod].add;
    hashTable[mod].add=Node;

    int expect=abs(target-nums[i]);//期望值

    struct node*temp=hashTable[expect%numsSize].add;
    while(temp!=NULL)
    {
        if(temp->pos!=i&&temp->value+nums[i]==target)
        {
            int *result=(int*)molloc(sizeof(int)*2);
            result[0]=temp->pos;
            result[1]=i;
            *returnSize=2;
            hashfree(hashTable,numsSize);
            return result;
        }
        else
        {
            temp=temp->next;
        }
    }

}
return ;
}