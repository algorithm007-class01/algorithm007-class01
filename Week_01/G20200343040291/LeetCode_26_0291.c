int removeDuplicates(int* nums, int numsSize){
int temp=nums[0];
int count=1,i;
if(numsSize==0)
{
    return 0;
}
for(i=0;i<numsSize;i++)
{
    if(nums[i]!=temp)
    {
        temp=nums[i];
        nums[count]=nums[i];
        count++;
    }
}
return count;
}