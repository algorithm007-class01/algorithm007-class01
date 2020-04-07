
public class LeetCode_860_0145 {

    /**
     * 5 10 20 三种现金 找零钱
     * 20元找零钱时运用贪心算法
     * */
    public static boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else if (bill == 20) {
                if (ten >= 1 && five >= 1) {
                    ten --;
                    five--;
                } else if (five >= 3) {
                    five -= 3;

                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
