// 860 柠檬水找零
// 贪心思想：优先找 10 元，没有再找 5 元
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            // 5 元计数
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--; // 找零 5 元
                ten++; // 支付 10 元
            } else { // 20 元
                if (five > 0 && ten > 0) {
                    // 找零 15 元
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3; // 找零 15 元
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}