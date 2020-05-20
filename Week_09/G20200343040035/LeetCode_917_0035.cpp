#include<vector>
#include<string>
#include<algorithm>
#include<unordered_set>
using namespace std;

class Solution {
public:
    string reverseOnlyLetters(string S) {
        int begin = 0;
        int end = S.size()-1;
        while(begin <= end)
        {
            if(!isalpha(S[begin]))
                begin++;
            else if(!isalpha(S[end]))
                end--;
            else if(isalpha(S[begin]) && isalpha(S[end]))
            {
                swap(S[begin], S[end]);
                begin++;
                end--;
            }
        }  
        return S;      
    }
};