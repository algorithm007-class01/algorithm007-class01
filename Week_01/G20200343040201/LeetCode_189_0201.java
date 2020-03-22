public class LeetCode_189_0201 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int[] newArr = new int[nums.length];
        k = k % nums.length;

        int targetIdx = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newArr[targetIdx++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newArr[targetIdx++] = nums[i];
        }

        //将结果放回nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }
}

//    public static void main(String[] args) {
//        int[] inputArr = new int[]{1,2,3,4,5,6,7};
//        new Solution02().rotate(inputArr, 2);
//        System.out.println(Arrays.toString(inputArr));
//    }
