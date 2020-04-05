package G20200343040211;

public class LeetCode_26_0211 {
    public static int delRepeatNum(int[] nums) {
        if (nums.length < 2) return nums.length;
        int k = 0;//记录不重复元素的位置，所以最后返回个数是K+1
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] != nums[j]) {//遇到不同的数字，k往前移动
                    if (k < len - 1) {
                        k = k + 1;
                        break;
                    }
                } else {//遇到相同的数字
                    //删除相同的数字，即将被删除元素之后的元素往前移动一个位置
                    int r = j;
                    for (r = j; r < len; r++) {
                        if (r < len - 1) {
                            nums[r] = nums[r + 1];
                        }
                    }
                    //元素移动之后，调整数组访问边界值
                    len = len - 1;
                    if (j >= len) break;
                    //元素前移，注意调整j的下标，跟nums[i]比较的是nums[i+1]                                      //之所以是j=i，是因为for循环的j++会使得j = i + 1
                    j = i;
                }
            }
        }
        return k + 1;
    }
}