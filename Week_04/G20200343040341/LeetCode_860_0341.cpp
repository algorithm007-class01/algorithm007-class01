class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if(bills.empty()) return true;
        unordered_map<int,int> mp;
        for(int i=0; i<bills.size(); i++){
            if(bills[i] == 5){
                mp[5]++;
            }else if(bills[i] == 10){
                if(mp[5] > 0){
                    mp[5]--;
                    mp[10]++;
                }else{
                    return false;
                }
            }else if(bills[i] == 20){
                int temp = 15;
                if(mp[10] > 0){
                    mp[10]--;
                    temp -= 10;
                }
                while(temp > 0 && mp[5] > 0){
                    mp[5]--;
                    temp -= 5;
                }
                if(temp > 0){
                    return false;
                }
            }
        }
        return true;
    }
};