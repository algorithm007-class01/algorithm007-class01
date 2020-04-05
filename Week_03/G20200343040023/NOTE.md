学习笔记

回溯解决排列、组合、子集问题
题[1，2，3，4，5]组合所有子集
1.数学归纳法
  每一个新加入的元素子集是前一个子集的所有组合，[1，2]是2和[1]的所有元素组合

590：后序遍历N叉树
解法：
  1、递归
    def postorder_1(root):
        rs = []
        if not root:
            return rs

        for c in root.children:
            rs.extend(self.postorder_1(c))
        rs.append(root.val)

        return rs
  2、迭代:前序压栈，后序显示
    def postorder_2(root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            root = stack.pop()
            if root:
                show.append(root.val)

            children = root.children
            for c in children:
                stack.append(c)

        return show[::-1]

589: 前序遍历N叉树
解法：
  1、递归
      def preorder_2(oot):
        rs = []
        if not root:
            return rs

        rs.append(root.val)
        children = root.children
        for c in children:
            rs.extend(self.preorder_2(c))
        return rs

  2、迭代：重点在tmp，压入stack的顺序
    def preorder_1(root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            tmp = []
            root = stack.pop(0)
            if root:
                show.append(root.val)

            children = root.children
            for c in children:
                tmp.append(c)
            tmp.extend(stack)
            stack = tmp
        return show

144: 前序遍历二叉树

 1、递归
    def preorderTraversal_1(root):
        rs = []
        if root:
            rs.append(root.val)
            rs.extend(self.preorderTraversal_1(root.left))
            rs.extend(self.preorderTraversal_1(root.right))
        else:
            return rs
        return rs

 2、迭代：跟N叉迭代思想一样，注意tmp
    def preorderTraversal_2(root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            tmp = []
            root = stack.pop(0)
            if root:
                show.append(root.val)

            if root.left:
                tmp.append(root.left)
            if root.right:
                tmp.append(root.right)

            tmp.extend(stack)
            stack = tmp

        return show

429: 层序遍历：每一层放入一个list中并赋值于下个循环current_list
    def levelOrder(self, root):
        rs = []
        if not root:
            return rs

        current_list = [root]
        while current_list:
            tmp = []
            next_list = []
            for c in current_list:
                tmp.append(c.val)
                next_list.extend(c.children)
            rs.append(tmp)
            current_list = next_list
        return rs

105: 从前序与中序遍历序列构造二叉树
    递归：注意前序数组的切分，中序数组的根节点左部分和前序根节点左部分是一样长度
    def buildTree_1(preorder, inorder):
        if not preorder and not inorder:
            return None

        root = TreeNode(preorder[0])
        mid_inx = inorder.index(preorder[0])

        root.left = self.buildTree_1(preorder[1:mid_inx+1], inorder[:mid_inx])
        root.right = self.buildTree_1(preorder[mid_inx+1:], inorder[mid_inx+1:])

        return root

236: 二叉树的最近公共祖先
    1、递归: left和right都不为空则在树的左右两个分支，如果有一个为空则在一条分支上
        def lowestCommonAncestor_1(root, p, q):
        if not root or root.val == p.val or root.val == q.val:
            return root

        left = self.lowestCommonAncestor_1(root.left, p, q)
        right = self.lowestCommonAncestor_1(root.right, p, q)

        if left and right:
            return root

        return left if left else right

    2、迭代: 待处理



