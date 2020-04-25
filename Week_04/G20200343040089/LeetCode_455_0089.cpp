/**
* Summary:assign-cookies/
* Parameters:
*   g: target sequence 
*	s: source sequence
* Return: satisfy size
*/
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int i = 0;
        for (int j = 0; j < s.size() && i < g.size(); ++j) {
            if (s[j] >= g[i]) ++i;
        }
        return i;
    }
};