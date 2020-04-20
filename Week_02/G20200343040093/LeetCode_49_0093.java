class LeetCode_49_0093 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ant = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ant.containsKey(key)) ant.put(key, new ArrayList<>());
            ant.get(key).add(s);
        }
        return new ArrayList<>(ant.values());
    }
}