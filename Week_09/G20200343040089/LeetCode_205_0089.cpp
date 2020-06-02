//	使用两个哈希表，相同位置的字母在哈希表中存储的值是一样的，然后比较判断
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) return false;

        int m1[256], m2[256], n = s.size();
        bzero(m1, sizeof(m1));
        bzero(m2, sizeof(m2));

        for (int i = 0; i < n; ++i) {
            if (m1[s[i]] != m2[t[i]]) return false;
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        return true;
    }
};