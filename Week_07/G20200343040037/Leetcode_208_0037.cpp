
class TrieNode {
public:
    bool isWord;
    TrieNode* children[26];
    TrieNode():isWord(false){
        memset(children, 0, sizeof(children));
    }
};
class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        node_ = new TrieNode;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        auto temp = node_;
        for(auto c: word) {
            if(temp->children[c - 'a'] == nullptr) {
                temp->children[c - 'a'] = new TrieNode;
            }
            temp = temp->children[c - 'a'];
        }
        temp->isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        auto temp = find_string(word);
        if(temp != nullptr && temp->isWord) {
            return true;
        }
        return false;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        auto temp = find_string(prefix);
        if(temp != nullptr) {
            return true;
        }
        return false;
    }
private:
    TrieNode* node_;
private:
    TrieNode* find_string(string word) {
        auto temp = node_;
        for(auto c: word) {
            if(temp->children[c - 'a'] != nullptr) {
                temp = temp->children[c - 'a'];
            } else {
                temp = nullptr;
                break;
            }
        }
        return temp;
    }

    void clear(TrieNode* node) {
        for(int i = 0; i < 26; i++) {
            TrieNode* temp = node->children[i];
            if(temp != nullptr) {
                clear(temp);
            }
        }
        delete node;
        //node = NULL;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
