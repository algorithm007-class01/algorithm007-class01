#include<vector>
#include<string>
#include<algorithm>
#include<unordered_set>
using namespace std;

class Solution {
public:
    int firstUniqChar(string s) {
        int hash[26] = {0};
        for(char i : s)
            hash[i - 'a']++;
        for (int i = 0; i < s.length();i++){
            if(hash[s[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
};