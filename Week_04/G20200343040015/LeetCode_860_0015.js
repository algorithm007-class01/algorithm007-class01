/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
*顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
*每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
*注意，一开始你手头没有任何零钱。
*如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let fiveCount = 0,tenCount = 0;
    for(bill of bills){
        if(bill === 5) fiveCount++;
        else if(bill === 10){
            if(fiveCount < 1) return false;
            if(fiveCount >=1){
                fiveCount--;
                tenCount++
            }
        }else {
            if(fiveCount >=1&&tenCount>=1){
                fiveCount--;
                tenCount--
            }
            else if(fiveCount >=3&&tenCount===0){
                fiveCount -= 3
            }else return false;
        }  
    }
    return true;
};