//	使用双指针遍历头尾，同为字母就交换，不是字母就前进一步
class Solution {
public:
    string reverseOnlyLetters(string S) {
        for (int i = 0, j = S.length() - 1; i < j;) {
            if (!isalpha(S[i])) {
                ++i;
            } else if (!isalpha(S[j])) {
                --j;
            } else {
                swap(S[i++], S[j--]);
            }
        }
        return S;
    }
};