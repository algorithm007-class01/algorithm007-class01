
public List<List<String>> groupAnagrams2(String[] strings) {

        if (strings.length == 0) {
        return new ArrayList<>();
        }

        Map<String, List> map = new HashMap<>();

        for (String s : strings) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = String.valueOf(chars);

        if (!map.containsKey(key)) {
        map.put(key, new ArrayList());
        }
        map.get(key).add(s);
        }
        return new ArrayList(map.values());
}