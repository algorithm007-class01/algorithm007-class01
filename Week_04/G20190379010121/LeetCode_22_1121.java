class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res,n,0,0,0,"");
        return res;
    }
    //dfs
    private void generateParenthesis(List<String> res,int n,int left,int right,int level,String str){
        if(left == right && left == n){
            res.add(str);
            return;
        }
        if(left <= n){
            generateParenthesis(res,n,left+1,right,level+1,str + "(");
        }
        if(right < left){
            generateParenthesis(res,n,left,right+1,level+1,str + ")");
        }

    }
    // bfs
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(new Node("(",1,0));
//        while(!q.isEmpty()){
//            Node node = q.poll();
//            if(node.left == node.right && node.left == n){
//                res.add(node.res);
//                continue;
//            }
//            if(node.left <= n){
//                q.add(new Node(node.res+"(",node.left+1,node.right));
//            }
//            if(node.right < node.left){
//                q.add(new Node(node.res+")",node.left,node.right+1));
//            }
//        }
//        return res;
//    }
//    class Node {
//        /**
//         * 当前得到的字符串
//         */
//        public String res;
//        /**
//         * 剩余左括号数量
//         */
//        public int left;
//        /**
//         * 剩余右括号数量
//         */
//        public int right;
//
//        public Node(String str, int left, int right) {
//            this.res = str;
//            this.left = left;
//            this.right = right;
//        }
//    }
}