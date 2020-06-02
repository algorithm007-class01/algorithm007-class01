class Solution {
public:
    int myAtoi(string str) {
        int index = 0;
        int sign = 1;
        int total = 0;

        if (str.length() == 0) return 0;

        while (str[index] == ' ' && index < str.length()) index++;

        if (str[index] == '+' || str[index] == '-') {
            sign = str[index] == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str[index] - '0';
            if (digit < 0 || digit > 9) break;

            if (INT_MAX / 10 <  total || (INT_MAX / 10 == total && INT_MAX % 10 < digit)) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            total = 10 * total + digit;
            index++;
        }

        return  total * sign;
    }
};