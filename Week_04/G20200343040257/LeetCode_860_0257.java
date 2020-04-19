package cxl.study.leetcode;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LeetCode_860_0257 {

    public boolean lemonadeChange(int[] bills) {
        int fiveDollar = 0;
        int tenDollar = 0;
        int twentydollar = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5: {
                    fiveDollar++;
                    break;
                }
                case 10: {
                    tenDollar++;
                    if(fiveDollar == 0){
                        return false;
                    }
                    fiveDollar--;
                    break;
                }
                case 20: {
                    twentydollar++;
                    if (tenDollar > 0) {
                        tenDollar--;
                        fiveDollar--;
                    } else {
                        fiveDollar -= 3;
                    }
                    if(tenDollar<0 || fiveDollar<0){
                        return false;
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return fiveDollar >= 0 && tenDollar >= 0 && twentydollar >= 0;

    }

}
