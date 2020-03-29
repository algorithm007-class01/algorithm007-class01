/*
* Summary:group-anagrams Solution
* Parameters:
*   strs: source vector
* Return: vector of matching rules
*/
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int a[26] ={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 
                    47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
        unordered_map<double, vector<string>> hash_map;

        for (string& s : strs) {
            double key = 1;
            for (char& c : s) {
                key *= a[c - 'a'];
            }
            hash_map[key].push_back(s);
        }
        vector<vector<string>> anagrams;
        for (auto p : hash_map) {
            anagrams.push_back(p.second);
        }

        return anagrams;
    }
};