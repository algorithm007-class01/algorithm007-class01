二叉树与堆、分治、回溯 总结
1. 例题：
    1. 二叉树：
        1. https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
        2. https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
        3. https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
        4. https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
        5. https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
    2. 堆和二叉堆：
        1. https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
        2. https://leetcode-cn.com/problems/sliding-window-maximum/
        3. https://leetcode-cn.com/problems/top-k-frequent-elements/
        4. https://leetcode-cn.com/problems/chou-shu-lcof/
        5. https://leetcode-cn.com/problems/top-k-frequent-elements/
    3. 递归：
        1. https://leetcode-cn.com/problems/climbing-stairs/
        2. https://leetcode-cn.com/problems/generate-parentheses/
        3. https://leetcode-cn.com/problems/invert-binary-tree/description/
        4. https://leetcode-cn.com/problems/validate-binary-search-tree
        5. https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
        6. https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
        7. https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
        8. https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
        9. https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
        10. https://leetcode-cn.com/problems/combinations/
        11. https://leetcode-cn.com/problems/permutations/
        12. https://leetcode-cn.com/problems/permutations-ii/
    4. 分治、回朔：
        1. https://leetcode-cn.com/problems/powx-n/
        2. https://leetcode-cn.com/problems/subsets/
        3. https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）
        4. https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
        5. https://leetcode-cn.com/problems/n-queens/
2. 二叉搜索树删除操作：一般都是在其右子树中A哦到最小的节点，作为替换该被删除节点的新节点。也可以选择其左子树中的最大节点来替换被删除节点。（因为这两种节点都是大于当前左子树，小于当前右子树的）
3. 一般看到要求logn相关的时间复杂度时，大多都是使用二叉堆、二叉搜索树、二分查找、排序这些手段
4. 递归：
    1. 代码模版：
public void recur(int level, int param) { 



  // terminator  递归终结条件（本质上就是递归的层级到了最下面的层级、也就是它的叶子结点、即往下没有问题需要解决了）

  if (level > MAX_LEVEL) {  

    // process result 

    return; 

  } 



  // process current logic   处理当前层逻辑（重复子问题）
 
  process(level, param); 



  // drill down        下探到下一层

  recur( level: level + 1, newParam); 



  // restore current status    清理当前层（非必须）

 

}
    1. 递归要注意的点
        1. 不要进行人肉递归（最大误区，即最好不要在纸上画出递归的状态树），即直接看函数本身就开始写递归
        2. 找到最近最简方法，将其拆解为可重复解决的问题（重复子问题）（因为计算机程序指令，其实只包含if-else和for循环以及递归调用，复杂的程序本身只是逻辑比较复杂，指令就那三种。所以最后能用递归解决的问题，其实就是可以找到重复的子问题，具有可重复性，简化代码）
        3. 数学归纳法思维（即证明n=1、n=2是成立的，且当n下成立的时候，可推导出n+1下也成立）
4. 分之代码模版：
def divide_conquer(problem, param1, param2, ...): 

# recursion terminator      递归终结条件

if problem is None: 

print_result 

return 



# prepare data          准备子问题、分解出重复子问题

data = prepare_data(problem) 

subproblems = split_problem(problem, data) 



# conquer subproblems        处理子问题，下探到下一层   

subresult1 = self.divide_conquer(subproblems[0], p1, ...) 

subresult2 = self.divide_conquer(subproblems[1], p1, ...) 

subresult3 = self.divide_conquer(subproblems[2], p1, ...) 

…



# process and generate the final result     合并子问题，并处理

result = process_result(subresult1, subresult2, subresult3, …)

# revert the current level states        清理当前层（非必须）
