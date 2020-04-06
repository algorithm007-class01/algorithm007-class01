/**
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 *
 * @author wangcheng
 */
public class LeetCode_70_0241 {

    /**
     * 动态规划 时间复杂度
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            int[] sum  = new int[n];
            sum[0] = 1;
            sum[1] = 2;
            for(int i = 2;i<n;i++){
                sum[i] = sum[i-1] + sum[i-2];
            }
            return sum[n-1];
        }
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
