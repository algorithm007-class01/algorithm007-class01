//	Relative sorting using the idea of count sorting
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;

        int counter[26] = {0};
        for (char c : s) {
            counter[c - 'a']++;
        }

        for (char c : t) {
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) return false;
        }
        return true;
    }
};