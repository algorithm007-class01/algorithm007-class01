//860 - 柠檬水找零
//思路：20元找零时，优先考虑10元面值是否存有 - 贪心算法
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if (bills.empty()) return false;
        map<int, int> mp;
        for (int i = 0; i < bills.size(); ++i) {
            if (bills[i] == 5) mp[5]++;
            else if (bills[i] == 10) {
                else mp[5]--, mp[10]++;
                if (mp[5] < 0) return false;
            }
            else {
                int tmp = 15;
                if (mp[10] > 0) tmp -= 10, mp[10]--;
                while (tmp > 0) tmp -= 5, mp[5]--;
                if (mp[5] < 0) return false;
            }
        }
        return true;
    }
};
//时间复杂度：O(n)  空间复杂度：O(n)