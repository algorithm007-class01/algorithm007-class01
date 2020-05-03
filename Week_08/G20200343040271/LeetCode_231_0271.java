/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo_2(9));
    }

    /**
     * 最高位为1，其他位均为0，
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long)n;
        return (x & (x - 1)) == 0;
    }

    /**
     * 除2
     * @param n
     * @return
     */
    public boolean isPowerOfTwo_2(int n) {
        if(n == 0) return false;
        while ((n&1) == 0){
            n = n>>1;
        }
        return n == 1;
    }
}