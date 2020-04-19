/**
 * @param {number[]} bills
 * @return {boolean}
 */
/**
 * 题目分析
 * 1.找零的情况只存在 消费 5美元和 10美元的情况
 * 2.因为 5 10 20 是整数倍 所以应用贪心算法成立
 *       
 */
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    var five = 0,ten = 0,len = bills.length;
    for(var i = 0;i<bills.length;i++){
          if(bills[i] == 5){
              five++
          }else if(bills[i] == 10){
            if(five == 0){
                return false
            }
            five--;
            ten++;
          }else if(bills[i] == 20){
              if(five>0&&ten>0){
                  ten--;
                  five--;
              }else if(five > 2){
                five -=3
              }else{
                  return false
              }
          }
    } 
    return true;
};