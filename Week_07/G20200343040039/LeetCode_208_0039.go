package G20200343040039

type Trie struct {
	isEnd bool
	child [26]*Trie
}


/** Initialize your data structure here. */
func Constructor() Trie {
	var newTrie Trie
	newTrie.isEnd = false

	return newTrie
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	indexNode := this
	for _, char := range word {
		if indexNode.child[char - 'a'] == nil {
			newTrie := Constructor()
			indexNode.child[char - 'a'] = &newTrie
			indexNode = indexNode.child[char - 'a']
		} else {
			indexNode = indexNode.child[char - 'a']
		}
	}
	indexNode.isEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	indexTrie := this
	for _, char := range word {
		indexTrie = indexTrie.child[char - 'a']
		if (indexTrie == nil) {
			return false
		}
	}
	return indexTrie.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	indexTrie := this
	for _, char := range prefix {
		indexTrie = indexTrie.child[char - 'a']
		if (indexTrie == nil) {
			return false
		}
	}
	return true
}