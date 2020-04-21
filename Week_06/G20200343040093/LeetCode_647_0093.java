class LeetCode_647_0093 {
    public int countSubstrings(String s) {
        int length = S.length(), ans = 0;
        for (int center = 0; center <= 2*length-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < length && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}