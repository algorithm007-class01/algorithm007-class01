#include <iostream>
#include <vector>

using namespace std;

/**
 * 题目：柠檬水找零问题
 * solution: 使用贪心算法，先找大面额的美元，由于10是5的倍数，先找10更加符合贪心算法
 *          时间复杂度为O(n),空间复杂度为O(1)
 * test cases:空数组，正常数据[5,5,5,10,20]，返回false的数据[5,5,10,10,20]
*/

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five=0,ten=0;
        for(int i:bills){
            if(i==5) five++;
            else if(i==10) five--,ten++;
            else if(ten>0) five--,ten--;
            else five-=3;
            if(five<0) return  false;
        }
        return true;
    }
};
int main() {
    Solution solution = Solution();
    vector<int> t1;
    vector<int> t2{5,5,5,10,20};
    vector<int> t3{5,5,10,10,20};
    cout << "res1:" << solution.lemonadeChange(t1) << endl;
    cout << "res2:" << solution.lemonadeChange(t2) << endl;
    cout << "res3:" << solution.lemonadeChange(t3) << endl;
}
