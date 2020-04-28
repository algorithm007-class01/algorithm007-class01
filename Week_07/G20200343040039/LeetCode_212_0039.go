package G20200343040039

type TrieNode struct {
	Word string
	Children []*TrieNode
}

type Trie struct {
	Root *TrieNode
}

func newTrie() *Trie {
	trie := new(Trie)
	trie.Root = &TrieNode{
		Word: "",
		Children: make([]*TrieNode, 26),
	}

	return trie
}

func (trie *Trie) insert(word string)  {
	curNode := trie.Root

	for i := 0; i < len(word); i++ {
		if curNode.Children[word[i] - 'a'] == nil {
			curNode.Children[word[i] - 'a'] = &TrieNode{
				Word: "",
				Children: make([]*TrieNode, 26),
			}
		}

		curNode = curNode.Children[word[i] - 'a']
	}

	curNode.Word = word
}

func findWords(board [][]byte, words []string) []string {
	trie := newTrie()

	result := make([]string, 0)

	for _, word := range words {
		trie.insert(word)
	}

	rows := len(board)
	if rows == 0 {
		return result
	}
	cols := len(board[0])

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			findWordRecur(board, i, j, trie.Root, &result)
		}
	}

	return result
}

func findWordRecur(board [][]byte, row int, col int, node *TrieNode, result *[]string) {
	if (row < 0 || row >= len(board) || col < 0 || col >= len(board[0])) {
		return
	}

	curChar := board[row][col]

	if (curChar == '$' || node.Children[curChar - 'a'] == nil) {
		return;
	}

	node = node.Children[curChar - 'a']

	if len(node.Word) != 0 {
		*result = append(*result, node.Word)
		node.Word = ""
	}

	temp := board[row][col]
	//上下左右去遍历
	board[row][col] = '$'
	findWordRecur(board, row - 1, col, node, result)
	findWordRecur(board, row + 1, col, node, result)
	findWordRecur(board, row, col - 1, node, result)
	findWordRecur(board, row, col + 1, node, result)
	board[row][col] = temp
}
