package myself;

public class LeetCode_860_0201 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int item : bills) {
            if (item == 5) {
                five++;
                continue;
            }
            if (item == 10) {
                ten++;
                if (five > 0) {
                    five--;
                    continue;
                } else
                    return false;
            }

            // 能跳过上面两个if条件到这里的，就是20块的情况
            while (item > 5) {
                // 优先取10块的找零
                if (item > 10 && ten > 0) {
                    item -= 10;
                    ten--;
                    continue;
                }
                // 10块没有了，用5块的
                if (five > 0) {
                    item -= 5;
                    five--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
