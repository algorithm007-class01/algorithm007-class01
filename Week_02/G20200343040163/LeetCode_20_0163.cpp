class Solution {
public:
    bool isValid(string s) {
        stack<char> charS;
        for (char c: s) {
            if (c == '(') {
                charS.push(')');
            } else if (c == '{') {
                charS.push('}');
            } else if (c == '[') {
                charS.push(']');
            } else {
                if (charS.empty() || charS.top() != c) {
                    return false;
                }
                charS.pop();
            }
        }
        return charS.empty();
    }
};