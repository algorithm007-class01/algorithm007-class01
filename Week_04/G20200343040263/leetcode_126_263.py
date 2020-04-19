class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        from collections import defaultdict
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return []
        L = len(beginWord)
        #(说明dict中的元素是列表类型)
        com_dict = defaultdict(list)
        for word in wordList:
            for j in range(L):
                com_dict[wodr[:i]+'*'+word[i+1:]].append(word)
        #BFS
        queue = [(beginWord, [beginWord], 1)]
        #保存访问过的元素
        visited = {beginWord: 1}

        ans_list = []
        firstFound = True
        min_length = 0

        while queue:
            cur_word, cur_path, level = queue.pop(0)
            for i in range(L):
                inter_word = cur_word[:i] + '*' + cur_word[i+1:]
                for word in com_dict[inter_word]:
                    if word == endWord:
                        if firstFound:
                            min_length = level + 1
                            firstFound = False
                            ans_list.append(cur_path + [word])
                        else:
                            if level + 1 > min_length:
                                return ans_list
                            else:
                                ans_list.append(cur_path + [word])
                        continue
                    #已经访问过的元素
                    if word in visited and visited[word] < level + 1:
                        continue
                    else:
                        visited[word] = level + 1
                        queue.append((word, cur_path + [word], level + 1))
        return ans_list