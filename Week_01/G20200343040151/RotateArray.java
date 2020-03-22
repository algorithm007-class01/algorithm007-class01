public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0){
            return;
        }
        int step = k%nums.length;
        int temparray[] = new int[step];
        System.arraycopy(nums,nums.length-step,temparray,0,step);
        int count =0;
        for (int i = nums.length-step-1;i>-1;i--) {
            nums[nums.length -1-count]=nums[i] ;
            count ++;
        }

        for(int i =0;i<temparray.length;i++){
            nums[i] = temparray[i];
        }
    }
}
