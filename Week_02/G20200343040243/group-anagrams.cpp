#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;  
        // res vector的下标值
        int sub = 0;
        string tmp;
        // 判断排序后单词是否存在，即字母组成是否一致
        // string是排序后单词，int是在res vector中的下标(排序后不同的单词在res vector中下标值是递增的)
        unordered_map<string,int> work;

        for(auto str:strs) {
            tmp=str;
            sort(tmp.begin(),tmp.end());

            if(work.count(tmp)) {
               res[work[tmp]].push_back(str);
            } else {
                vector<string> vec(1,str);
                res.push_back(vec);

                work[tmp] = sub++;
            }
        }
        return res;
    }
};

int main() {

    vector<string> arr = {"eat", "tea", "tan", "ate", "nat", "bat"};


    Solution s = Solution();
    vector<vector<string>> res = s.groupAnagrams(arr);

    for(vector<string> v : res) {
        for(string s : v) {
            cout << s << " ";
        }
        cout << endl;
    }

    return 0;
}