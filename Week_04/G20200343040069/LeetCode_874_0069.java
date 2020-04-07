class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten =0;

        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                ten++;five--;
            }else if(ten > 0){
                ten--;five--;
            }else{
                five -= 3;
            }

            if(five < 0)return false;
        }
        return true;
    }

    //贪心策略： 2 个 5 元等价于 1 个 10 元。需要尽可能地多留 5 元在手上，防止 10 元的顾客无法找零。
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten =0;

        for(int bill : bills){
            switch(bill){
                case 5: five++; break;
                case 10: five--;ten++; break;
                case 20:{
                    if(ten > 0){
                        ten--;five--;
                    }else{
                        five -=3;
                    }
                    break;
                }
                default: break;
            }
            if(five < 0) return false;
        }
        return true;
    }
}