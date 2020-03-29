import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_0147 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> data = new HashMap<>();
        for (String s : strs) {
            char[] t = s.toCharArray();
            Arrays.sort(t);
            String code = String.valueOf(t);
            if (data.containsKey(code)) {
                data.get(code).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                data.put(code, l);
            }
        }
        return new ArrayList<>(data.values());
    }
}
