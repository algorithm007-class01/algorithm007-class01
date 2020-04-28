import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_0215 {
    public List<String> findWords(char[][] board, String[] words) {
        //构建trie树
        Trie wordTrie = new Trie();
        for (String s :words){
            wordTrie.insert(s);
        }
        TrieNode root  = wordTrie.getRoot();
        Set<String> result = new HashSet<>();
        int n=board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        //遍历树
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                find(board,visited,i,j,n,m,result,root);
            }
        }

        return new LinkedList<>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int n, int m, Set<String> result, TrieNode cur) {
        int [] l = new int[]{1,-1,0,0};
        int [] r = new int []{0,0,1,-1};
        //出界，遇到已读的
        if (i<0 || i>=n || j<0 || j>=m ||visited[i][j]){
            return;
        }
        cur = cur.get(board[i][j]);
        visited[i][j]=true;
        if (cur==null){
            visited[i][j]=false;
            return;
        }
        if (cur.isEnd()){
            result.add(cur.word);
        }
        for (int k=0;k<4;k++){
            find(board, visited, i+l[k],j+r[k],n,m,result,cur);
        }
        visited[i][j] = false;
    }
}

//构建Trie树
class Trie {
    public TrieNode getRoot() {
        return root;
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.word = word;
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node  = root;
        for (int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                return null;
            }
        }
        return node;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

}
