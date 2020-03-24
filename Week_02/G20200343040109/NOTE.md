学习笔记

算法训练营week 02

1、栈Stack 和 队列Queue
  栈：先进后出FILO(fist in last out)，后进先出（LOFI），添加删除时间复杂度都是O（1）
  
  队列：先进先出FIFO(first in first out)，像排队一样，谁先来就谁先走，添加删除时间复杂度都是O（1）
  
  
2、实战中很少用栈Stack和队列Queue，使用双端队列Deque（Double-End Queue）
   双端队列：头和尾都可以入push和出pop；
   插入和删除还是O(1),查询还是O（n）


3、Stack和Queue、Deque的工程实现

	 Stack:
	 		push:插入元素
	 		pop:返回栈顶元素，并把栈顶元素删除
	 		peek:返回栈顶元素，不改变栈的元素
	    
	 Queue：
	 
	 
	 Deque:
			由于头和尾都可以pop和push，所以有两套接口
			push_back和push_front:尾端or前端插入
			pop_back和pop_front:尾端or前端抛出
			begin()和rbegin()：前端迭代器和尾端迭代器
			
	 作业：14:06分的地方：用addfirst、removefirst、addlast、removelast改写代码；
	 
4、优先队列Priority Queue
		插入操作：O(1)
		去除操作:O(logN),按元素优先级取出，比stack和queue速度慢
		底层具体实现的数据结构较为多样和复杂：heap（堆），bst（binary search tree）有可能


   作业：Queue和Priority Queue的源码分析
   增删改查的实现
   
   
5、实战题目解析
    有效的括号问题：用栈来解决
    什么样的问题可以用栈解决：
    如果一个东西，他具有最近相关性，他就可以用栈解决；
    如果一个东西，他具有先来后到的特性；
    如果一个东西，有个一一对应的结构；
    比如括号：像洋葱一样的结构，一定有一个括号和第1个括号对应；
    
    最小栈问题：
    如果碰到只用栈来实现队列或者只有队列来实现栈，那就是用2个栈或者2个队列来实现；
    
    柱状图最大矩形问题：
    没看懂
    
    所有滑动窗口的题目都用队列去实现；
    
    
 
 
 
 
第5课：
1、哈希表，也叫散列表，通过关键码值映射到表中的位置来访问元素，查找元素O(1)
   映射函数叫散列函数，也叫哈希函数，存放记录的数组叫哈希表，也叫散列表；
   哈希函数有很多种，哈希函数写的好，可以是哈希值分布均衡，减少哈希碰撞；
   哈希碰撞的解决办法就是在碰撞的地方创建一个链表，把发生碰撞的元素都加入链表中，这样查找的话就会退化为O（n）
   
2、map
		
3、set
    
4、实战
    刷题4步：
    1、clarification->和面试官确认题目意思，各种边界
    2、possible solutions->最有算法，时间空间复杂度最好
    3、code->写代码
    4、test cases->测试
    
    leetcode-242:有效的字母异位词
    暴力法：sort，然后比较是否相等
    map:统计每个字母出现的次数
