//  使用哈希表存储字母频次
class Solution {
public:
    int firstUniqChar(string s) {
        int count[26];
        bzero(count,sizeof(count));

        for (char c : s) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (count[s[i] - 'a'] == 1) return i;
        }
        
        return -1;
    }
};