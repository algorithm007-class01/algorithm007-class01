class Solution {
    public boolean validPalindrome(String s) {
        char[] letters = s.toCharArray();
        for (int i = 0, j = letters.length - 1; i < j; ++i, --j) {
            if (letters[i] != letters[j])
                return isValidPal(letters, i + 1, j) || isValidPal(letters, i, j - 1);
        }
        return true;
    }
    public boolean isValidPal(char[] letters, int l, int r) {
        while (l < r) {
            if (letters[l] != letters[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}