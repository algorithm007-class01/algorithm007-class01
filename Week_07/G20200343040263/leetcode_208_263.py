class Trie:
    def __init__(self):
        # 初始化数据结构
        self.root = {}
        self.end_of_word = '#'
    def insert(self,word):
        # 插入字符到trie中
        node = self.root
        for char in word:
            # 键是'abcd...z',值是下一个节点的位置,一层一层嵌套，构造树结构
            node = node.setdefault(char,{})
        node[self.end_of_word] = self.end_of_word
    def search(self,word):
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self.end_of_word in node
    def startWith(self,prefix):
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True