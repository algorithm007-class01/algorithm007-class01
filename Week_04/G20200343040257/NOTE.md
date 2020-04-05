# 学习笔记

## 第9课 DFS BFS

模版代码
````
public class DFSTemplate {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    /**
     * 递归写法
     */
    public void dfsRecursion(Node node, Set visited) {

        // 终止条件
        if (visited.contains(node)) {
            // 以访问过则返回
            return;
        }

        visited.add(node);

        // 处理当前节点
        for (Node child : node.children) {
            if (!visited.contains(child)) {
                dfsRecursion(node, visited);
            }
        }

    }

    /**
     *  栈写法
     */
    public void dfsStack(Node node) {
        if (node == null) {
            return;
        }

        Set visited = new HashSet();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {
            Node tempNode = nodeStack.pop();

            if (visited.contains(tempNode)) {
                continue;
            }

            visited.add(tempNode);

            if (tempNode.children != null) {
                for (Node child : tempNode.children) {
                    nodeStack.push(child);
                }
            }
        }
    }

}


````

广度优先搜索BFS
````
public class BFSTemplate {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public void bfs(Node start){
        Set<Node> visited = new HashSet<>();
        Deque<Node> nodeDeque = new ArrayDeque<>();
        nodeDeque.push(start);


        while (!nodeDeque.isEmpty()) {
            Node tempNode = nodeDeque.pop();

            if(visited.contains(tempNode)){
                continue;
            }

            visited.add(tempNode);

            process(tempNode);

            if (start.children!=null) {
                for (Node child : start.children) {
                    nodeDeque.push(child);
                }
            }

            // 其他处理逻辑

        }


    }

    private void process(Node tempNode) {
        System.out.println(tempNode.val);
    }

    private void testBfs(Node root){

        if(root == null){
            return;
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            Node tempNode = nodeQueue.poll();
            System.out.println(tempNode.val);
            visited.add(tempNode);

            if(tempNode.children!=null){
                tempNode.children.forEach(node -> {
                    if(!visited.contains(node)){
                        nodeQueue.offer(node);
                    }
                });
            }
        }

    }

}
````
## 第十课贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

贪心算法一般用于解决最优化问题，如：求图中的最小生成树、求哈夫曼编码等。但是对于现实中项目和生活中的问题贪心法往往不能得到最优解。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。



## 第11课二分查找

二分查找模板代码
````
public class BinarySearchTemplate {

    public int binarySearch(int[] array,int target){
        int left=0,right = array.length-1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchTemplate binarySearchTemplate = new BinarySearchTemplate();
        int[] array = {5,6,1,2,3,4};
        System.out.println(binarySearchTemplate.binarySearch(array, 1));
    }

}
````
