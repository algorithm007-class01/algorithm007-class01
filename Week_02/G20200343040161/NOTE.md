学习笔记

1. 相关题目:
    1. 栈：
        1. https://leetcode-cn.com/problems/min-stack/
        2. https://leetcode-cn.com/problems/min-stack/
        3. https://leetcode-cn.com/problems/largest-rectangle-in-histogram
        4. https://leetcode.com/problems/trapping-rain-water/
        5. https://leetcode-cn.com/problems/implement-queue-using-stacks/
    2. 队列
        1. https://leetcode-cn.com/problems/sliding-window-maximum
        2. https://leetcode.com/problems/design-circular-deque
        3. https://leetcode-cn.com/problems/implement-stack-using-queues/
    3. 哈希
        1. https://leetcode-cn.com/problems/valid-anagram/description/
        2. https://leetcode-cn.com/problems/group-anagrams/
        3. https://leetcode-cn.com/problems/two-sum/description/
    4. 合并区间重叠
        1. https://leetcode-cn.com/problems/rectangle-overlap/
        2. https://leetcode-cn.com/problems/merge-intervals/
2. 其实数据结构算法就是对生活中问题的抽象，将生活中的情景转换为计算机语言。
3. 栈：栈可以处理的问题，可以对应到生活中的“圆葱”类型问题，即后进先出类型问题。（几乎所有的与括号相关的问题都可以用栈来解决）
4. 凡是类似于“括号”结构的题目，可以考虑用栈解决，比如接雨水问题。
5. 队列：对应到生活中的“先来后到”情景，先进先出类型问题。
6. 双栈：可以用双栈来实现队列（类似有使用双队列来实现栈），或处理最小栈问题。
7. 对于滑动窗口的题，一般都是用队列来实现。滑动窗口时即使用了队列的“先进先出”的特性。
8. 注意！！！写完代码之后，一定要测试！多注意测试边界值！多考虑特殊的测试用例！！！
9. 凡是和“变位词”、“字母顺序打乱”相关的题目，都考虑统计字母出现的次数。这种方法我叫做 “counter 方法”，因为 Python 中有个 Counter 类就是专门用来计数的。很多字符串计数问题的常用技巧都是使用map或者长度为26的数组来计数的。
10. 判断字母异位词是否相等（所含字母表中各个字母的数量相同，但是顺序不同所组成的不同字符串）解法：（例题：字母异位词分组、有效的字母异位词）
    1. 使用map来记录单词中每个字母出现的次数，key为字母，value为次数，对比两个字母异位词的map是否相等
    2. 使用长度为26的切片来存储单词中，每个字母（每个字母减去’a’来计算出再切片中的位置）出现的数量（例如：1对应a，2对应b，3对应c，。。。），对比两个字母异位词的切片是否相等
    3. 将两个字母异位词分别在字符串内部根据字符排序（如“dcab”排序之后为“abcd”），然后对比排序后的字符串是否相等
    4. 将两个字母异位词先使用长度为26的切片，存储单词中每个字母出现的数量，然后通过这个切片生成一个单词，记录每个字母出现的次数（比如“bbaccde”生成单词为“1a2a2a1a1a”），最后对比两个字母异位词相应的新生成单词是否相等。
11. 矩形重叠问题：
    1. 矩形如果不重叠，从x轴和y轴上看两个矩形就变成了两条线段，这两条线段肯定是不相交的，也就是说左边的矩形的最右边小于右边矩形的最左边，；y轴同理，下面的矩形的最上边小于上面矩形的最下边]。因为题目要求重叠算相离，所以加上=，最后取反就行啦~
