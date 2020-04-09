<map>
		<node ID="root" TEXT="数据结构知识脉络">		<node TEXT="非受限线性表" ID="13a170a03c30d815" STYLE="bubble" POSITION="right">
		<node TEXT="顺序结构" ID="332170a0404d51027" STYLE="fork">
		<node TEXT="数组" ID="1d9170a0406e2c0cb" STYLE="fork">
		<node TEXT="支持O(1)的随机访问" ID="212170a0407bd915f" STYLE="fork">
		</node>
		<node TEXT="平均O(n)的插入和删除" ID="1a6170a040d0fe14" STYLE="fork">
		</node>
		<node TEXT="警惕越界错误，导致Stack Over Flow" ID="4c170a041043415b" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="链式结构" ID="11d170a04061100a1" STYLE="fork">
		<node TEXT="单链表" ID="77170a04177e600a" STYLE="fork">
		<node TEXT="不支持随机访问，需要遍历去访问结点" ID="a8170a041be09068" STYLE="fork">
		</node>
		<node TEXT="插入和删除只需要移动指针，时间复杂度为O(1)" ID="203170a041f0740c" STYLE="fork">
		</node>
		<node TEXT="每个结点需要额外的空间存储指针，需要的内存比数组大" ID="3d0170a042345d127" STYLE="fork">
		</node>
		</node>
		<node TEXT="双链表" ID="fe170a0418c0d102" STYLE="fork">
		<node TEXT="在单链表的基础上，除头结点外，每个结点多了一个存放前驱结点内存地址的指针" ID="3b3170a0427c770b9" STYLE="fork">
		</node>
		</node>
		<node TEXT="循环链表" ID="2a170a0419667143" STYLE="fork">
		<node TEXT="尾结点指向头结点" ID="296170a0430bf101c" STYLE="fork">
		</node>
		</node>
		<node TEXT="静态链表" ID="190170a041a0270d3" STYLE="fork">
		<node TEXT="借助数组，伴随着指向后继结点的指针" ID="1fd170a0435aee01b" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="受限线性表" ID="113170a03c8b0b0ac" STYLE="bubble" POSITION="right">
		<node TEXT="栈" ID="bf170a043afc60ea" STYLE="fork">
		<node TEXT="栈空的情况下不能做出栈操作，否则会产生溢出" ID="190170a68953de091" STYLE="fork">
		</node>
		<node TEXT="顺序和链式都可以实现，先进后出" ID="2cf170a043d9e0199" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="262170a0441c3d043" STYLE="fork">
		<node TEXT="浏览器的前进后退" ID="3bc170a04429a70c5" STYLE="fork">
		</node>
		<node TEXT="括号匹配" ID="2ae170a04440f6032" STYLE="fork">
		</node>
		<node TEXT="表达式计算" ID="38d170a0444c930ab" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="堆" ID="1c0170a043c357171" STYLE="fork">
		<node TEXT="大顶堆" ID="3c0170a044611407" STYLE="fork">
		</node>
		<node TEXT="小顶堆" ID="6d170a0446c2702" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="a6170a044778e08" STYLE="fork">
		<node TEXT="找第K大元素" ID="303170a04484680ca" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="队列" ID="3c0170a043ca04128" STYLE="fork">
		<node TEXT="普通队列" ID="e8170a044a805181" STYLE="fork">
		<node TEXT="顺序和链式都可以实现，先进先出" ID="28b170a044e847168" STYLE="fork">
		</node>
		</node>
		<node TEXT="双边队列" ID="212170a044b52c13b" STYLE="fork">
		<node TEXT="入口和出口都可以进队和出队" ID="18c170a045161013" STYLE="fork">
		</node>
		</node>
		<node TEXT="优先级队列" ID="3e0170a044c38911c" STYLE="fork">
		<node TEXT="根据优先级来出队" ID="331170a051c1e910e" STYLE="fork">
		</node>
		</node>
		<node TEXT="实际应用" ID="1ce170a044cfbb172" STYLE="fork">
		<node TEXT="LRU Cache" ID="390170a044de4208" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="排序" ID="1ba170a03cdb1f123" STYLE="bubble" POSITION="left">
		<node TEXT="O(n)" ID="5c170a051ff48165" STYLE="fork">
		<node TEXT="桶排序" ID="a170a05288c80eb" STYLE="fork">
		</node>
		<node TEXT="计数排序" ID="3a1170a052adbc097" STYLE="fork">
		</node>
		<node TEXT="基数排序" ID="a2170a052bdd40fb" STYLE="fork">
		</node>
		</node>
		<node TEXT="O(nlog n)" ID="395170a0525dc70bc" STYLE="fork">
		<node TEXT="快速排序" ID="51170a053045a06e" STYLE="fork">
		</node>
		<node TEXT="归并排序" ID="2ca170a05315e5108" STYLE="fork">
		</node>
		</node>
		<node TEXT="O(n^2)" ID="18f170a0526106076" STYLE="fork">
		<node TEXT="冒泡排序" ID="209170a0533b18027" STYLE="fork">
		</node>
		<node TEXT="插入排序" ID="7a170a0534a11142" STYLE="fork">
		</node>
		<node TEXT="选择排序" ID="2e170a0535616014" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="树与二叉树" ID="313170a03ce33715d" STYLE="bubble" POSITION="left">
		<node TEXT="二叉树" ID="6e170a0538ba40fd" STYLE="fork">
		<node TEXT="特点" ID="1dc170a05436ef0fb" STYLE="fork">
		<node TEXT="顺序和链式都可以实现" ID="2af170a0544b3f0aa" STYLE="fork">
		</node>
		<node TEXT="遍历方式" ID="22d170a05467cf186" STYLE="fork">
		<node TEXT="广度优先搜索" ID="24b170a05471f916d" STYLE="fork">
		</node>
		<node TEXT="深度优先搜索" ID="ec170a054971000b" STYLE="fork">
		<node TEXT="前序遍历" ID="275170a054aa3211c" STYLE="fork">
		</node>
		<node TEXT="中序遍历" ID="4a170a054bc4b182" STYLE="fork">
		</node>
		<node TEXT="后序遍历" ID="262170a054c5fc157" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="完全二叉树" ID="2f7170a053b9a70a5" STYLE="fork">
		</node>
		<node TEXT="满二叉树" ID="236170a053c91113" STYLE="fork">
		</node>
		<node TEXT="二叉搜索树" ID="28b170a053d58b114" STYLE="fork">
		</node>
		<node TEXT="平衡二叉搜索树" ID="3dc170a053e8fa132" STYLE="fork">
		<node TEXT="红黑树" ID="64170a053ff04078" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="哈弗曼树" ID="37b170a0539962187" STYLE="fork">
		</node>
		<node TEXT="字典树" ID="31c170a053a2990b8" STYLE="fork">
		</node>
		</node>
</node>
</map>