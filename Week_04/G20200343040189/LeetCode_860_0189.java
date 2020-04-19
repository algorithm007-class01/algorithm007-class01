//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
// 注意，一开始你手头没有任何零钱。
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
//
// Related Topics 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 本题可以用数组下标对元素进行访问，有左右边界
    // 面对二十元找零优先考虑找零十元，尽可能多的保留手中的五元，体现了贪心思想
    public boolean lemonadeChange(int[] bills) {
        // 定义五元和十元的数目
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                // 收到五元不用找零
                five++;
                continue;
            }
            if (five > 0 && i == 10) {
                // 收到十元，此时手中五元数目大于零
                ten++;
                five--;
                continue;
            } else {
                // 收到二十元，考虑两种找零方式
                // 一张十元，一张五元
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 三张五元
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
