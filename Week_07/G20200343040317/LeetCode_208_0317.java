class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.get(word.charAt(i)) == null) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return node != null && node.isEnd;
    }

    static class Node {
        private static int R = 26;
        private Node[] links;
        private boolean isEnd = false;

        public Node() {
            this.links = new Node[R];
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        private boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */