#include <iostream>
#include <vector>
#include <string>

using namespace std;
// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
class Solution {
public:
    // 假设所有字符都是小写
    int firstUniqChar(string s) {
        short  count[26] = {0};
        for (char n:s) {
            count[n-'a']++;
        }

        int len = s.size();
        for (int i = 0; i < len; i++) {
            if (count[s[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
};

void test_case() {
    Solution sol;
    string str1("leetcode");
    if (sol.firstUniqChar(str1) == 0) {
        cout << "str1 test success" << endl;
    }

    string  str2("loveleetcode");
    if (sol.firstUniqChar(str2) == 2) {
        cout << "str2 test success" << endl;
    }
}

int main(int argc, char* argv[]) {
    test_case();
    return 0;
}