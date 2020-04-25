public class LeetCode_91_0145 {
    /**
     * 91:给定一个只包含数字的非空字符串，计算解码方法的总数。
     * 动态规划 + 特殊情况判定
     * */
    public int numDecodings(String s) {
        char[] chArr = s.toCharArray();
        if (chArr[0] == '0') return 0;
        int pre = 1, curr = 1;
        for (int i = 1; i < chArr.length; i++) {
            int tmp = curr;
            if (chArr[i] == '0'){
                if (chArr[i - 1] == '1' || chArr[i - 1] == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            }
            else if (chArr[i - 1] == '1' || (chArr[i - 1] == '2' && chArr[i] >= '1' && chArr[i] <= '6')){
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

}
