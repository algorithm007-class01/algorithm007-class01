/**
* Summary :	word-ladder-ii
* Parameters :
*	beginWord : starting word
* 	endWord   : target word
*	wordList  : dictionary
* Return : all conversion sequences
*/
//BFS，不过队列存储的是转换序列，然后每次拿队列头元素的序列尾部元素
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        int length = beginWord.length();
        bool flag = false;
        unordered_map<string, vector<string>> dictionary;
        for (auto str : wordList) {
            if (str == endWord) flag = true;
            for (int i = 0; i < length; ++i) {
                string tmp = str.substr(0, i) + "*" + str.substr(i + 1, length);
                dictionary[tmp].push_back(str);
            }
        }
        if (!flag) return {};
        vector<vector<string>> result;
        queue<vector<string>> paths;
        paths.push({beginWord});
        int level = 1;
        int minlevel = INT_MAX;
        unordered_set<string> visited;
        unordered_set<string> wordlist(wordList.begin(), wordList.end());
        
        while (!paths.empty()) {
            vector<string> path = paths.front();
            paths.pop();
            if (path.size() > level) {
                for (string w : visited) {
                    wordlist.erase(w);
                }
                visited.clear();
                if (path.size() > minlevel) {
                    break;
                } else {
                    level = path.size();
                }
            }
            string last = path.back();
            int n = last.length();
            for (int i = 0; i < n; ++i) {
                string newword = last.substr(0, i) + "*" + last.substr(i + 1, n);
                for (auto str : dictionary[newword]) {
                    if (wordlist.find(str) != wordlist.end()) {
                        vector<string> newpath = path;
                        newpath.push_back(str);
                        visited.insert(str);
                        if (str == endWord) {
                            minlevel = level;
                            result.push_back(newpath);
                        } else {
                            paths.push(newpath);
                        }
                    }
                }
            }
        }
        return result;
    }
};