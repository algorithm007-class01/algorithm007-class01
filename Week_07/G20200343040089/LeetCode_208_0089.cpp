//	Build a dictionary tree
//	Example:
//		Trie *trie = new Trie();
//		trie->insert("apple");
//		trie->search("apple");
//		trie->startsWith("app");
//		delete trie;
class TrieNode {
public:
    TrieNode *next[26];
    bool isWord;
    TrieNode(bool flag = false) {
        isWord = flag;
        memset(next, 0, sizeof(next));
    }
};
class Trie {
public:
    //	Initialize your data structure here.
    Trie() {
        root = new TrieNode();
    }
	
	//	Free up memory space
    ~Trie() {
        clear(root);
    }
    
    //	Inserts a word into the trie
    void insert(string word) {
        TrieNode *node = root;
        for (char c : word) {
            if (node->next[c - 'a'] == nullptr) {
                node->next[c - 'a'] = new TrieNode();
            }
            node = node->next[c - 'a'];
        }
        node->isWord = true;
    }
    
    //	Returns if the word is in the trie
    bool search(string word) {
        TrieNode *node = root;
        for (char c : word) {
            if (node->next[c - 'a'] == nullptr) {
                return false;
            }
            node = node->next[c - 'a'];
        }
        return node->isWord;
    }
    
    //	Returns if there is any word in the trie that starts with the given prefix
    bool startsWith(string prefix) {
        TrieNode *node = root;
        for (char c : prefix) {
            if (node->next[c - 'a'] == nullptr) {
                return false;
            }
            node = node->next[c - 'a'];
        }
        return true;
    }
private:
    TrieNode *root;
	
	//	Recursively release node memory space
    void clear(TrieNode *root) {
        for (int i = 0; i < 26; ++i) {
            if (root->next[i] != nullptr) {
                clear(root->next[i]);
            }
        }
        delete root;
    }
};