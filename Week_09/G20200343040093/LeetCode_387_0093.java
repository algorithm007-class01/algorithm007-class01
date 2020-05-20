class LeetCode_387_0093 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            if (count.get(s.charAt(j)) == 1) return j;
        }
        return -1;
    }
}