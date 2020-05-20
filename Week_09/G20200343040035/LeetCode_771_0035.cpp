#include<vector>
#include<string>
#include<algorithm>
#include<unordered_set>
using namespace std;

class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int ans = 0;
        unordered_set<char> st;
        for(auto i : J) st.insert(i);
        for(auto s : S) if(st.count(s)) ++ans;
        return ans;
    }
};