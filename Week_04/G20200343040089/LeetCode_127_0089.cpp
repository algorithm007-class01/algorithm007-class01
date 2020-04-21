/**
* Summary :	word-ladder
* Parameters :
*	beginWord : starting word
* 	endWord   : target word
*	wordList  : dictionary
* Return : all conversion sequences
*/
//双向BFS
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        n = beginWord.size();
        bool flag = false;
        for (auto str : wordList) {
            for (int i = 0; i < n; ++i) {
                string tmp = str.substr(0, i) + "*" + str.substr(i + 1, n);
                list[tmp].push_back(str);
            }
            if (str == endWord) flag = true;
        }
        if (!flag) return 0;
        
        unordered_map<string, int> beginVisited, endVisited;
        queue<pair<string, int>> beginQueue, endQueue;
       
        beginQueue.push(make_pair(beginWord, 1));
        endQueue.push(make_pair(endWord, 1));
        beginVisited[beginWord] = 1;
        endVisited[endWord] = 1;

        while (!beginQueue.empty() && !endQueue.empty()) {
            int curlen = BFS(beginQueue, beginVisited, endVisited);
            if (curlen != -1) return curlen;
            curlen = BFS(endQueue, endVisited, beginVisited);
            if (curlen != -1) return curlen;
        }
        return 0;
    }
    int BFS(queue<pair<string, int>>& curQueue, unordered_map<string, int>& visited, unordered_map<string, int>& anoVisited) {
        string curWord = curQueue.front().first;
        int len = curQueue.front().second;
        curQueue.pop(); 
        for (int i = 0; i < n; ++i) {
            string index = curWord.substr(0, i) + "*" + curWord.substr(i + 1, n);
            for (auto str : list[index]) {
                if (anoVisited[str]) {
                    return len + anoVisited[str];
                }
                if (!visited[str]) {
                    curQueue.push(make_pair(str, len + 1));
                    visited[str] = len + 1;
                }
            }
        }
        return -1;
    }
private:
    int n;
    unordered_map<string, vector<string>> list;
};