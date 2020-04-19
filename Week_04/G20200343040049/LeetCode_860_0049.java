class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] check = new int[21];
        for (int i = 0; i < bills.length; ++i) {
            check[bills[i]]++;
            int repay = bills[i] - 5;
            if (repay == 0) continue;
            while (repay != 0) {
                if (repay >= 10 && check[10] > 0) {
                    repay -= 10;
                    check[10]--;
                } else if (repay >= 5 && check[5] > 0) {
                    repay -= 5;
                    check[5]--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}