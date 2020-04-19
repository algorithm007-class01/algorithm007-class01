<map>
		<node ID="root" TEXT="算法知识脉络">		<node TEXT="复杂度" ID="323170a00a378e127" STYLE="bubble" POSITION="right">
		<node TEXT="分类" ID="139170a012c70118c" STYLE="fork">
		<node TEXT="时间复杂度" ID="2b1170a01356b1126" STYLE="fork">
		<node TEXT="最好情况" ID="22170a0137e2c175" STYLE="fork">
		</node>
		<node TEXT="最坏情况" ID="3d6170a0138967172" STYLE="fork">
		</node>
		<node TEXT="平均情况" ID="165170a013924707e" STYLE="fork">
		</node>
		<node TEXT="均摊" ID="347170a0139e7b145" STYLE="fork">
		</node>
		</node>
		<node TEXT="空间复杂度" ID="75170a013a7e005b" STYLE="fork">
		</node>
		</node>
		<node TEXT="分析方法" ID="164170a013e8de0ed" STYLE="fork">
		<node TEXT="只关注循环次数最多的那段代码" ID="3a9170a01412840b4" STYLE="fork">
		</node>
		<node TEXT="加法法则" ID="212170a01439ee0cb" STYLE="fork">
		<node TEXT="总复杂度等于量级最大那段代码的复杂度" ID="2170a014646d0fc" STYLE="fork">
		</node>
		</node>
		<node TEXT="乘法法则" ID="29170a0144d0805" STYLE="fork">
		<node TEXT="千淘代码的复杂度等于嵌套内外代码复杂度的乘积" ID="1ca170a014a489156" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="复杂度量级" ID="3cb170a014dfe211a" STYLE="fork">
		<node TEXT="常量阶：O(1)" ID="384170a01503aa128" STYLE="fork">
		</node>
		<node TEXT="对数阶：O(log n)" ID="80170a01543cb129" STYLE="fork">
		</node>
		<node TEXT="线性阶：O(n)" ID="e170a015564518" STYLE="fork">
		</node>
		<node TEXT="线性对数阶：O(nlog n)" ID="27c170a0156d5e088" STYLE="fork">
		</node>
		<node TEXT="平方阶：O(n ^2)，O(n^3),..." ID="148170a0159984055" STYLE="fork">
		</node>
		<node TEXT="指数阶：O(2^n)" ID="2f4170a015b33104f" STYLE="fork">
		</node>
		<node TEXT="阶乘阶：O(n!)" ID="5c170a015c4b60f4" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="数组" ID="77170a017d99b106" STYLE="bubble" POSITION="right">
		<node TEXT="线性表结构，用连续的内存空间存储一组具有相同类型的数据" ID="286170a018025005e" STYLE="fork">
		</node>
		<node TEXT="支持随机访问，但插入、删除操作比较低效" ID="222170a01a843b11d" STYLE="fork">
		</node>
		</node>
		<node TEXT="链表" ID="32170a01b902913e" STYLE="bubble" POSITION="right">
		<node TEXT="通过指针将一组零散的内存块串联起来使用" ID="363170a01ba9ec122" STYLE="fork">
		</node>
		<node TEXT="插入、删除数据非常快速" ID="3dc170a01c13e713f" STYLE="fork">
		</node>
		</node>
		<node TEXT="操作受限的线性表" ID="398170a01c764006f" STYLE="bubble" POSITION="right">
		<node TEXT="栈" ID="344170a01ce96a164" STYLE="fork">
		<node TEXT="先进后出" ID="198170a01d043c174" STYLE="fork">
		</node>
		<node TEXT="只允许在一端插入和删除数据" ID="1a9170a01d552414f" STYLE="fork">
		</node>
		</node>
		<node TEXT="队列" ID="183170a01cf295155" STYLE="fork">
		<node TEXT="先进先出" ID="32c170a01d7f05197" STYLE="fork">
		</node>
		<node TEXT="需要两个指针，一个指向队头，一个指向队尾" ID="26f170a01d9ff1075" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="映射" ID="141170a01de41102a" STYLE="bubble" POSITION="right">
		<node TEXT="通过散列函数把元素的键值映射为下标，然后将数据存储在数组中对应下标的位置" ID="24d170a01e8d12009" STYLE="fork">
		</node>
		</node>
		<node TEXT="集合" ID="2ea170a021006002" STYLE="bubble" POSITION="right">
		<node TEXT="Key不重复" ID="332170a02112a216d" STYLE="fork">
		</node>
		</node>
		<node TEXT="并查集" ID="da170a0214409172" STYLE="bubble" POSITION="right">
		<node TEXT="站队问题" ID="185170a02154450e3" STYLE="fork">
		</node>
		<node TEXT="初始化" ID="c6170a0216334144" STYLE="fork">
		</node>
		<node TEXT="查询、合并" ID="222170a0216e00179" STYLE="fork">
		</node>
		<node TEXT="路径压缩" ID="a7170a0217e9f15d" STYLE="fork">
		</node>
		</node>
		<node TEXT="二分查找" ID="a6170a0219290187" STYLE="bubble" POSITION="right">
		<node TEXT="针对一个有序的数据集合，一维的时间复杂度为O(log n)，二维矩阵的时间复杂度为O(n)" ID="10f170a023002508d" STYLE="fork">
		</node>
		<node TEXT="每次都要通过与中间元素对比，将待查询区间缩小为之前的一半，直到找到要查找的元素" ID="1cc170a023340615f" STYLE="fork">
		</node>
		<node TEXT="适合处理静态数据" ID="29e170a023b9f6074" STYLE="fork">
		</node>
		<node TEXT="能够通过索引随机访问" ID="364170a02408a110a" STYLE="fork">
		</node>
		</node>
		<node TEXT="图" ID="2e5170a0247b67026" STYLE="bubble" POSITION="left">
		<node TEXT="非线性表数据结构，比树复杂" ID="29c170a02488470b7" STYLE="fork">
		</node>
		<node TEXT="遍历要记录已经访问过的结点" ID="2fa170a024dd1013" STYLE="fork">
		</node>
		</node>
		<node TEXT="树" ID="1d0170a02532dd02b" STYLE="bubble" POSITION="left">
		<node TEXT="字典树" ID="3e170a02595c413" STYLE="fork">
		<node TEXT="专门处理字符串匹配的数据结构" ID="3be170a025aade03f" STYLE="fork">
		</node>
		<node TEXT="利用字符串之间的公共前缀，将重复的前缀合并在一起" ID="2c5170a025d7e00a9" STYLE="fork">
		</node>
		<node TEXT="空间换时间" ID="113170a0263ae501b" STYLE="fork">
		</node>
		</node>
		<node TEXT="二叉树" ID="385170a0264b08045" STYLE="fork">
		<node TEXT="每个节点最多有两个子节点，分别是左子节点和右子节点" ID="395170a0266c6801c" STYLE="fork">
		</node>
		<node TEXT="遍历：DFS、BFS。时间复杂度为O(n)" ID="321170a0274754185" STYLE="fork">
		<node TEXT="平衡二叉树" ID="384170a02874620f6" STYLE="fork">
		<node TEXT="AVL树" ID="3a3170a029429c0db" STYLE="fork">
		</node>
		<node TEXT="红黑树" ID="2fb170a0294fc80e6" STYLE="fork">
		</node>
		</node>
		<node TEXT="二叉搜索树" ID="286170a0288a3b003" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="递归、分治" ID="1ed170a029727a01d" STYLE="bubble" POSITION="left">
		<node TEXT="将原问题划分成n个规模较小、结构与原问题相似的子问题" ID="1170a029dd9611a" STYLE="fork">
		</node>
		<node TEXT="递归地解决这些子问题，然后再合并其结果得到原问题的解" ID="315170a02a6241023" STYLE="fork">
		</node>
		<node TEXT="分治算法是一种处理问题的思想，递归是一种编程技巧，分治算法适合用递归实现" ID="11e170a02b30a90fa" STYLE="fork">
		</node>
		<node TEXT="递归程序的优化手段可以是尾递归优化，使递归本身无论调用多少次都只占用一个栈帧，避免栈溢出" ID="18170a68b8df914f" STYLE="fork">
		</node>
		</node>
		<node TEXT="贪心算法" ID="11f170a02bc502089" STYLE="bubble" POSITION="left">
		<node TEXT="每一步选择都采取当前状态下最有利的选择" ID="219170a02c0002117" STYLE="fork">
		<node TEXT="判断能不能贪心" ID="10c170a02c9efd0ba" STYLE="fork">
		</node>
		<node TEXT="弱化版的动态规划" ID="63170a02cc322137" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="动态规划" ID="187170a02cd7610b1" STYLE="bubble" POSITION="left">
		<node TEXT="多阶段决策最优解模型" ID="1ca170a02cecc818d" STYLE="fork">
		</node>
		<node TEXT="最优子结构" ID="143170a02deffa09c" STYLE="fork">
		</node>
		<node TEXT="无后效性" ID="35170a02e4f680e9" STYLE="fork">
		</node>
		<node TEXT="重复子问题" ID="d2170a02e669f086" STYLE="fork">
		</node>
		</node>
		<node TEXT="位运算" ID="290170a02ea7700cd" STYLE="bubble" POSITION="left">
		<node TEXT="需要记忆一些常见的位运算公式" ID="19d170a02ec7b805a" STYLE="fork">
		</node>
		</node>
		<node TEXT="布隆过滤器" ID="71170a02f3c2313b" STYLE="bubble" POSITION="left">
		<node TEXT="由一个很长的二进制向量和一系列随机映射函数组成" ID="135170a68517b80e4" STYLE="fork">
		</node>
		<node TEXT="空间效率和查询时间都远远超过一般算法" ID="3ca170a6858dc818d" STYLE="fork">
		</node>
		<node TEXT="判断不存在100%准确，判断不在就一定不在" ID="14c170a02f4f43024" STYLE="fork">
		</node>
		<node TEXT="利用Hash函数将待判断Key对应到多个位上" ID="38170a02f9b87135" STYLE="fork">
		</node>
		<node TEXT="通过极少的错误换取了存储空间的极大节省" ID="be170a686027f148" STYLE="fork">
		</node>
		</node>
		<node TEXT="LRU" ID="e7170a02ff171131" STYLE="bubble" POSITION="left">
		<node TEXT="HashTable + 双向链表" ID="37e170a03039f611" STYLE="fork">
		</node>
		<node TEXT="get和set都是O(1)的复杂度 " ID="35e170a030012616e" STYLE="fork">
		</node>
		</node>
</node>
</map>