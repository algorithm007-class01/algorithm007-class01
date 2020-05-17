#include<vector>
#include<string>
#include<algorithm>
using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = s.length() - 1;
        int nums = 0;
        for (int i = len; i >= 0;i--){
            if (s[i] != ' '){
                nums++;
            }
            else{
                if (nums != 0){
                    return nums;
                }
            }
        }
        return nums;
    }
};