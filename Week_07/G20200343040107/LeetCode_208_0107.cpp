#include <iostream>
#include <string>
using namespace std;

#define ALPHA_NUM 26

class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* tree_node = this;
        for (char c: word) {
            if (tree_node->next_[c-'a'] == nullptr) {
                tree_node->next_[c-'a'] = new Trie();
            }
            tree_node = tree_node->next_[c-'a'];
        }
        tree_node->is_end_ = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* tree_node = this;
        for (char c: word) {
            tree_node = tree_node->next_[c - 'a'];
            if (!tree_node) {
                return false;
            }
        }

        return tree_node->is_end_;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* tree_node = this;
        for (char c: prefix) {
            tree_node = tree_node->next_[c-'a'];
            if (!tree_node) {
                return false;
            }
        }

        return true;
    }

private:
    bool is_end_ = false;
    Trie* next_[ALPHA_NUM] = {0};
};


int main(int argc, char* argv[]) {
    Trie trie;

    trie.insert("apple");
    cout << trie.search("apple") <<  endl;
    cout << trie.search("app") << endl;
    cout << trie.startsWith("app") << endl;
    trie.insert("app");
    cout << trie.search("app") << endl;
    return 0;
}