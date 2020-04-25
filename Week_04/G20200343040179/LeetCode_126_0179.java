package Week_04.G20200343040179;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class LeetCode_126_0179 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        // 字典中不包含目标单词
        if (!distSet.contains(endWord)) {
            return res;
        }
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();

        List<String> list = new ArrayList<>();
        list.add(beginWord);

        queue.add(list);
        visted.add(beginWord);
        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            //上一层的队列
            int size = queue.size();
            // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
            // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                //每次去拿一个路径
                List<String> path = queue.poll();
                assert path != null;
                String word = path.get(path.size() - 1);
                //枚举a-->z,找出可能与word可以连接的单词
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        //将单词的每一个字符进行替换
                        chars[j] = k;
                        //这里注意,如果是相同的就跳过,这里不需要进行还原单词,因为本身就是相同的
                        if (chars[j] == temp) {
                            continue;
                        }
                        String str = String.valueOf(chars);
                        if (!visted.contains(str) && distSet.contains(str)) {
                            //生成一个新的路径并放入队里
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            queue.add(pathList);
                            subVisited.add(str);
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                        }
                    }
                }
                //本层遍历完之后需要将subVisited放入visited中
                visted.addAll(subVisited);
            }
        }
        return res;
    }
}
