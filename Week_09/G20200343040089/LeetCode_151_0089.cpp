//	使用双端队列沿着字符串一个一个单词处理，然后将单词压入队列的头部，再将队列转成字符串，结果就为翻转字符串单词
class Solution {
public:
    string reverseWords(string s) {
        int left = 0, right = s.size() - 1;

        while (left <= right && s[left] == ' ') ++left;
        while (left <= right && s[right] == ' ') -- right;

        deque<string> dq;
        string word;

        while (left <= right) {
            char c = s[left];
            if (word.size() && c == ' ') {
                dq.push_front(move(word));
                word = "";
            } else if (c != ' ') {
                word += c;
            }
            ++left;
        }
        dq.push_front(move(word));

        string result;
        while (!dq.empty()) {
            result += dq.front();
            dq.pop_front();
            if (!dq.empty()) result += ' ';
        }
        return result;
    }
};