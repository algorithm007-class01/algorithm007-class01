public class Solution {
    public IList<int> Preorder(Node root) {
        if(root == null ) return Enumerable.Empty<int>().ToList();

        var result = new List<int>();
        var stack = new Stack<Node>();
        stack.Push(root);

        while(stack.Count > 0){
            var node = stack.Pop();
            if(node.children != null){
                for(var i = node.children.Count - 1; i >= 0; i--){
                    stack.Push(node.children[i]);
                }
                result.Add(node.val);
            }
        }
        return result;
    }
}