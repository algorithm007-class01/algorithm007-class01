public class LeetCode_191_0145 {

    /**
     * 按位与 计算 二进制中 1 的数量
     * */
    private int hammingWeightTwo(int n) {
        int cnt = 0;
        while (n  != 0) {
            cnt += 1;
            n = n & (n - 1);
        }
        return cnt;
    }

    /**
     * 方法① 循环遍历
     * */
    public int hammingWeightOne(int n) {
        // 掩码
        int mask = 1;
        // 数量
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                cnt += 1;
            }
            mask <<= 1;
        }
        return cnt;
    }

}
