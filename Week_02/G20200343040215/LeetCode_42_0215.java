package DailyPractice;

public class LeetCode_42_0215 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {

        //边界小的开始遍历，
        //前比后大则加差值，-----------这里出错了，应该与最大柱子的差值
        //后比前大i+1，然后与最右边比较，小的遍历 ----比最大值大，则取代为最大值
        int sum=0;
        int i=0,j=height.length-1;
        int left_max =0;
        int right_max = 0;
        while(i<j){
            if(height[i]<height[j]){
                if (height[i] >= left_max) {
                    left_max = height[i];
                } else {
                    sum += (left_max - height[i]);
                }
                i++;

            }else{
                if (height[j] >= right_max) {
                    right_max = height[j];
                } else {
                    sum += (right_max - height[j]);
                }
                j--;
            }
        }
        return sum;
    }


}
