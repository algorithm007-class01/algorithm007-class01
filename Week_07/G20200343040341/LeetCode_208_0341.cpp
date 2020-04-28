class Trie {
private:
    Trie* Node[26];
    bool isEnd = false;
public:
    /** Initialize your data structure here. */
    Trie() {
        for(int i=0; i<26; i++) Node[i] = NULL;
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* now = this;
        for(char c : word){
            if(now->Node[c -'a'] == NULL) now->Node[c-'a'] = new Trie();
            now = now->Node[c - 'a'];
        }
        now->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* now = this;
        for(char c : word){
            if(now->Node[c - 'a'] == NULL) return false;
            now = now->Node[c - 'a'];
        }
        return now->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* now = this;
        for(char c : prefix){
            if(now->Node[c - 'a'] == NULL) return false;
            now = now->Node[c - 'a'];
        }
        return true;
    }
};