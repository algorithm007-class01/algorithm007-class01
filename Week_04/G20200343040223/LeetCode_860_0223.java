package leetcode;

public class LeetCode_860_0223 {

    public boolean lemonadeChange(int[] bills) {
        int ten = 0,five = 0;
        for(int bill:bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }else{
                if(five > 0 && ten > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
