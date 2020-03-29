class Solution {
    public List<String> letterCombinations(String digits) {
        final HashMap<Character, String> store = new HashMap<>();
        store.put('2', "abc");
        store.put('3', "def");
        store.put('4', "ghi");
        store.put('5', "jkl");
        store.put('6', "mno");
        store.put('7', "pqrs");
        store.put('8', "tuv");
        store.put('9', "wxyz");
        final ArrayList<String> ans = new ArrayList<>();
        // 入参检查不能忘记
        if(digits.length() == 0){
            return ans;
        }
        combinate("", digits, store, 0, ans);
        return ans;
    }

    private void combinate(String res, String digits, HashMap<Character, String> store, int level, List<String> ans) {
        if (digits.length() == level) {
            ans.add(res);
            return;
        }
        String letters = store.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            //  进入下一层
            //  注意这里第一个参数传值
            combinate(res + letters.charAt(i), digits, store, level + 1, ans);
        }
    }
}