void moveZeroes(int* nums, int numsSize){
    int *p = &nums[0];
    int *q = p+1;
    for (int i = 1;i<numsSize;i++){
        int temp = *p;
        if (*p == 0) {
            if(* q!= 0){
                *p = *q;
                *q = temp;
                p++;
            }
            q++;
        } else{
            p++;
            q++;
        }
    }
}
