/**
*860. 柠檬水找零 <p>
* https://leetcode-cn.com/problems/lemonade-change/solution/
*@author tim@timloong.win 
* 
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills==null || bills.length==0){
            return false;
        }

        int fiveNum=0,tenNum=0;
        for(int b:bills){
            switch(b){
                case 5:
                    fiveNum++;
                    break;
                case 10:
                    if(fiveNum>0){
                        fiveNum--;
                        tenNum++;
                    }else{
                        return false;
                    }
                    break;
                default://20
                    if(fiveNum>0 && tenNum>0){
                        fiveNum--;
                        tenNum--;
                    }else if(fiveNum>=3){
                        fiveNum-=3;
                    }else{
                        return false;
                    }
            }
        }

        return true;
    }
}