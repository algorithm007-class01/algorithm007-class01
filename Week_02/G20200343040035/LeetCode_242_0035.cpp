class Solution {
public:
    bool isAnagram(string s, string t) {
        char mytable[26] = {0};
        for (int i=0;i<s.size();i++){
            mytable[s[i]-'a'] += 1; 
        }
        for (int i=0;i<t.size();i++){
            mytable[t[i]-'a'] -= 1;
        }
        for (int i=0;i<26;i++){
            if (mytable[i] != 0)
                return false;
        }
        return true;
    }
};