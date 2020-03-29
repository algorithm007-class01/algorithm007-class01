public class Solution {
    public IList<int> Postorder(Node root) {
        if(root == null ) return Enumerable.Empty<int>().ToList();

        var result = new List<int>();
        var stack = new Stack<Node>();
        stack.Push(root);

        while(stack.Count > 0){
            var node = stack.Pop();
            if(node.children != null){
                foreach(var i in node.children){
                    stack.Push(i);
                }
                result.Insert(0, node.val);
            }
        }
        return result;
    }
}