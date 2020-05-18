public class LeetCode_680_0145 {
    public boolean validPalindrome(String s) {
        char[] chArr = s.toCharArray();
        for (int i = 0, j = chArr.length - 1; i < j; i++, j--) {
            if (chArr[i] != chArr[j]) {
                return isPalindrome(chArr, i, j - 1 ) || isPalindrome(chArr, i + 1, j);
            }
        }
        return false;
    }

    public boolean isPalindrome(char [] chArr, int i, int j) {
        while (i < j) {
            if (chArr[i++] != chArr[j--]) {
                return false;
            }
        }
        return true;
    }
}
