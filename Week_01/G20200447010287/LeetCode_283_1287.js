var moveZeroes = function(nums) {
    let i = 0, j=0
    while(i < nums.length){
        if (nums[i] != 0){
            if (j < i){
                nums[j] = nums[i]
                nums[i] = 0
            }
            j++
        }
        i++
    }
   return nums
};