#include<vector>
#include<string>
#include<algorithm>
using namespace std;

// 法一
class Solution {
public:
    string toLowerCase(string str) {
        for (int i = 0; i < str.length();i++){
            if (str[i] >= 'A' && str[i] <= 'Z'){
                str[i] += 32;
            }
        }
        return str;
    }
};
// 法二
class Solution {
public:
    string toLowerCase(string str) {
        for (int i = 0; i < str.length();i++){
            str[i] |= ' ';
        }
        return str;
    }
};
