class Solution{
	public:
		bool lemonadeChange(vector<int>& bills){
			if(bills.empty()){
				return false;
			}

			int five = 0; 
			int ten  = 0;
			for(auto& bill: bills){
				if(bill == 5){ // 顾客给5块就直接收
					five++;
				}
				else if(bill == 10){// 顾客给10块，看有没有5块零钱，如果没有的话，交易失败，否则找5块，换回十块
					if(five == 0){
						return false;
					}
					five--;
					ten++;
				}else{ // 顾客给20元
					if(ten >= 1 && five >= 1){ // 找个10块的，5块的.
						five--;
						ten--;
					}else if(five >= 3){ // 找3个5块的.
						five -= 3;
					}else{ // 交易失败
						return false;
					}

				}
			}
			return true;
		}
};
