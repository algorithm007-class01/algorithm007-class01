#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
class Solution {
   public:
    bool isAnagram(string s, string t) {
        // 使用排序进行求解
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t ? true : false;
    }
};
