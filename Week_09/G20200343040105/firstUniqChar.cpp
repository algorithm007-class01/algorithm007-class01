//387. 字符串中的第一个唯一字符

class Solution {
public:
    int firstUniqChar(string s) {
        int hashTable[26] = {0};
        for (char k : s) {
            hashTable[k - 'a']++;
        }
        for (int i = 0; i < s.size(); ++i) {
            if (hashTable[s[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
};