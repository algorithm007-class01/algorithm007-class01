class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 入参校验
        // 如果第一个人给个大钱，生意就没有办法做了
        if (bills.length != 0 && bills[0] != 5) {
            return false;
        }
        // 记录不同面值钱币的数量
        int five = 0, ten = 0;
        for (int bill : bills) {
            // 10 20 涉及需要找钱的情况
            if (bill == 10) {
                if (--five < 0) {
                    return false;
                }
                ten++;
            } else if (bill == 20) {
                // 需要找回15块钱,收到二十后要给一张10一张5块的出去，或者给3张5块的出去
                if (ten > 0) {
                    ten--;
                    if (--five < 0) {
                        return false;
                    }
                } else {
                    if (five < 3) {
                        return false;
                    } else {
                        five -= 3;
                    }
                }
            } else {
                // 直接收到5块钱，不用找零
                five++;
            }
        }
        return true;
    }
}