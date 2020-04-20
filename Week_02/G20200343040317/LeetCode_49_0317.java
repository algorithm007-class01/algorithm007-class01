class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final HashMap<String, List<String>> store = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            final String key = String.valueOf(array);
            if (!store.containsKey(key)) {
                store.put(key, new ArrayList<>());
            }
            store.get(key).add(strs[i]);
        }
        return new ArrayList<>(store.values());
    }
}