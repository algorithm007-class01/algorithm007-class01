package Week_04.G20200343040179;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class LeetCode_45_0179 {
    /**
     * 顺藤摸瓜
     * 1.记录当前能跳跃的边界
     * 2.找出能跳出最远距离的元素
     * 3.每次从可以调到最大距离的元素开始跳，并且步数+1
     * <p>
     * 这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。因为开始的时候边界是第 0 个位置，
     * steps 已经加 1 了。如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1 了。
     * 如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1。
     */
    public int jump(int[] nums) {
        //记录能够跳跃的边界
        int end = 0;
        //最远的距离
        int maxposition = 0;
        //步数
        int step = 0;
        // 这里nums.length-1说明的是因为第一步的时候+1了,
        // 题目的意思是肯定能跳到末尾,这时候要么是超出末尾,这时候步数不用+1
        // 要么刚好到lenth-2的位置这时候会进入到if语句step+1就会跳到最后一位,因为前面已经+1了,所以后面不需要加了,所以遍历到length-2就行
        // 后续这类问题就考虑左边界和右边界
        for (int i = 0; i < nums.length - 1; i++) {
            maxposition = Math.max(maxposition, nums[i] + i);
            if (i == end) {
                end = maxposition;
                step++;
            }
        }
        return step;
    }
}
