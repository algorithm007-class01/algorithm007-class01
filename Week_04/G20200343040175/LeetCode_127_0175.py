"""
单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list) -> int:
        if endWord not in wordList:
            return 0
        
        from collections import defaultdict, deque
        adj_list = defaultdict(list)
        #创建邻接表
        for word in wordList:
            for i in range(len(word)):
                adj_list[word[:i] + "*" + word[i+1:]].append(word)

        # # BFS
        # data_queue = deque()
        # data_queue.append((beginWord, 1))
        # visited = {beginWord:True}

        # while data_queue:
        #     (word,level) = data_queue.popleft()

        #     for i in range(len(word)):
        #         pattern = word[:i]+"*"+word[i+1:]
                
        #         for data in adj_list[pattern]:
        #             if data == endWord:
        #                 return level+1
        #             if data not in visited:
        #                 visited[data] = True
        #                 #下一层
        #                 data_queue.append((data, level+1))
        #         adj_list[pattern] = []                
        # return 0

        def visitQue(targetQue, visited, other_visited):
            (word, level) = targetQue.popleft()
            for i in range(len(word)):
                pattern = word[:i]+"*"+word[i+1:]
                for data in adj_list[pattern]:
                    if data in other_visited:   #相遇
                        return level + other_visited[data]
                    if data not in visited:
                        visited[data] = level+1
                        targetQue.append((data, level+1))
                adj_list[pattern] = []
            return None


        begin_queue = deque()
        end_queue = deque()

        begin_queue.append((beginWord,1))
        end_queue.append((endWord, 1))

        begin_visted = {beginWord: 1}
        end_visted = {endWord: 1}

        while begin_queue and end_queue:
            depth = visitQue(begin_queue, begin_visted, end_visted)
            if depth: return depth
            depth = visitQue(end_queue, end_visted, begin_visted)
            if depth: return depth
        return 0

