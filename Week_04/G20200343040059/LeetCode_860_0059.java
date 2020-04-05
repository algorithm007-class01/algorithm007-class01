public class LeetCode_860_0059 {


    /**
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lemonade-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */

    public static void main(String[] args) {

        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    // 使用贪心算法,有10找零10,没有再看5
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            // 如果是5,则不需要找零,对应5元的数量+1
            if (5 == bills[i]) {
                five++;
            }
            // 如果是10,需要找5,并且10元的数量+1
            else if (10 == bills[i]) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (20 == bills[i]) {

                if (1 <= ten && 1 <= five) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
