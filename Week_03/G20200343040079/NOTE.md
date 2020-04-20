### 学习笔记

1. 树的遍历：前序、中序、后序
    递归解法
    迭代解法：栈，颜色标记法
    
2. 堆和二叉堆复杂度
    类型/操作	find-min	delete-min	insert	    特点
    二叉堆	    O(1)	    O(log n)	O(log n)	数组存储
    斐波那契堆	O(1)	    O(log n)	O(1)	

3. 递归、泛型递归、分治

模板代码
```python
def recursion(level, path):
    if level > MAX_LEVEL:
        # process_result
        return

    # process logic in current level
    process(level, data)
    
    # drill down
    self.recursion(level + 1, path)

    # reverse the current level status if needed
```

#### 学习最大的误区：题目只练一遍！
