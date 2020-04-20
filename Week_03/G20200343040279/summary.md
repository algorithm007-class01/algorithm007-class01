# 第三周总结

## 树 二叉树 二叉搜索树
### 三种遍历方式
    前序遍历
```java
    def preorder(self, root):
        if root:
            self.traverse_path(root.val)
            self.preorder(root.left)
            self.preorder(root.right)
```
    中序遍历
```java
    def inorder(self, root):
        if root:
            self.inorder(root.left)
            self.traverse_path(root.val)
            self.inorder(root.right)
```
    后序遍历
```java
    def postorder(self, root):
        if root:
            self.postorder(root.left)
            self.postorder(root.right)
            self.traverse_path(root.val)
```

## 堆和二叉堆 图


## 泛型递归 树的递归
### 盗梦空间和递归类似
* 1、向下进入到不同的梦境中；向上又回到原来一层
* 2、通过声音同步回到上一层
* 3、每一层的环境和周围的人都是一份拷贝、主角等几个人穿越不同层级的梦境(发生和携带变化) 类似函数参数

* 栈 剥洋葱
* 抵制人肉递归的诱惑
* 找最近重复性
* 数学归纳法思想

### 递归模板

Python 代码模板

``` java
def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
	   process_result
	   return

    # process logic in current level
    process(level, data...)

    # drill down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed
```

Java 代码模板

```java
public void recur(int level, int param) {

  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }

  // process current logic
  process(level, param);

  // drill down
  recur( level: level + 1, newParam);

  // restore current status

}
```
## 分治算法 回溯算法
### 1、找重复性
#### 1、最近重复性
#### 2、最优重复性 （动态规划）
### 2、分治模板
```java
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator
  if problem is None:
    print_result
    return

  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)

  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  …

  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, …)

  # revert the current level states
```
##最近刷题集合
>>>
```java
echo "======================================================" . PHP_EOL;
echo "全排列:" . implode(',', (new Solutions())->permutation("aab")) . PHP_EOL;
echo "替换空格:" . (new Solutions())->replaceSpace("We are happy.") . PHP_EOL;
echo "最长不重复字符串长度:". (new Solutions())->findNoRepeatStrLengh("wwabcdoopic") . PHP_EOL;
echo "第一个只出现一次的字符:". (new Solutions())->firstUniqChar("wwabcdoopic") . PHP_EOL;
$str = "I am a student";
echo "==###待翻转原串:[" . $str . "]==###"  . PHP_EOL;
echo "翻转字符串(stack):". (new Solutions())->reverseWordsStack($str) . PHP_EOL;
echo "翻转字符串(substr):". (new Solutions())->reverseWordsSubstr($str) . PHP_EOL;
echo "翻转字符串(array_reverse):". (new Solutions())->reverseWords($str) . PHP_EOL;
echo "翻转字符串(strrev函数):". strrev($str) . PHP_EOL;
echo "剪绳子（整数拆分）:". (new Solutions())->cuttingRopeOne(5) . PHP_EOL;
echo "整数拆分（剪绳子）:". (new Solutions())->cuttingRopeOne(5) . PHP_EOL;
echo "数字序列中某一位的数字:". (new Solutions())->findNthDigit(94) . PHP_EOL;
$arr = ['a', 'c', 'f', 'g'];
echo "翻转数组中字符串(原地):". implode(',', (new Solutions())->reverseString($arr)) . PHP_EOL;
echo "aabcccccaa" . "字符串压缩后等于:". (new Solutions())->compressString("aabcccccaa") . PHP_EOL;
echo "abcdefg" . "左旋转3位等于:". (new Solutions())->reverseLeftWords("abcdefg", 3) . PHP_EOL;
echo "全排列:" . implode(',', (new Solutions())->quanPaiLie("aab")) . PHP_EOL;
echo "s2是否是s1轮转而成:". (new Solutions())->isFlipedString("waterbottle", "erbottlewat") . PHP_EOL;
echo "水壶问题:". (new Solutions())->canMeasureWaterGcd(104579, 104593, 12444) . PHP_EOL;
//echo "水壶问题:". (new Solutions())->canMeasureWaterNormal(104579, 104593, 12444) . PHP_EOL;
echo "第N个丑数:". (new Solutions())->nthUglyNumber(10) . PHP_EOL;
echo "滑动窗口最大值:". implode(',', (new Solutions())->maxSlidingWindow2([1,3,-1,-3,5,3,6,7], 3)) . PHP_EOL;
echo "全排列数组:" . implode('#', (new Solutions())->permuteArr([1,2,3])) . PHP_EOL;
echo "全排列数组:" . implode('#', (new Solutions())->permuteUnique([1,1,3])) . PHP_EOL;
echo "删除字符串中的所有相邻重复项:" . (new Solutions())->removeDuplicates("abacddddccabc"). PHP_EOL;
echo "删除字符串中的所有相邻重复项1:" . (new Solutions())->removeRepeatString("abacddddccabc"). PHP_EOL;
echo "删除字符串中的所有相邻重复项2:" . (new Solutions())->remove2("deeedbbcccbdaa", 3). PHP_EOL;
echo "================\n";
echo "数组中重复数字:" . implode(',', (new ArrayProblem())->findDuplicates([4, 3, 2, 7, 8, 2, 3, 1])) . PHP_EOL;
echo "旋转数组寻找最小数字:" . (new ArrayProblem())->minNumberInCircleArray([4, 5, 6, 7, 0, 1, 2]) . PHP_EOL;
echo "奇数偶数交换:" . implode(',', (new ArrayProblem())->exchangeNumber([1, 2, 3, 4])) . PHP_EOL;
echo "反转数组:" . implode(',', (new ArrayProblem())->rotateArrayMap([1, 2, 3, 4], 3)) . PHP_EOL;
echo "连续子数组的最大和:" . (new ArrayProblem())->maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]) . PHP_EOL;
echo "最小的K个数:" . implode(',', (new ArrayProblem())->topMinK([2, 3, 1, 6, 9], 3)) . PHP_EOL;
echo "最小的K个数:" . implode(',', (new ArrayProblem())->topMinK([-2, 1, -3, 4, -1, 2, 1, -5, 4], 3)) . PHP_EOL;
$a = [4, 5, 6, 7, 0, 0, 0];
echo "合并两个有序数组:" . implode(',', (new ArrayProblem())->merge($a, 4, [1, 2, 3], 3)) . PHP_EOL;
echo "[3,30,34,5,9]把数组排成最小的数:" . (new ArrayProblem())->minNumber([3,30,34,5,9]) . PHP_EOL;
echo "三数之和为0:" . implode(' # ', (new ArrayProblem())->threeSum([-1, 0, 1, 2, -1, -4])) . PHP_EOL;
echo "两数之和为9的索引下标:" . implode(',', (new ArrayProblem())->twoSum([2, 7, 11, 15], 9)) . PHP_EOL;
echo "数组中出现次数超过一半的数字:" . (new ArrayProblem())->majorityElementOverHaf([1, 2, 3, 2, 2, 2, 5, 4, 2]) . PHP_EOL;
echo "连续子数组的最大和:" . (new ArrayProblem())->maxSubArray([1, 2, 3, 2, 2, 2, 5, 4, 2]) . PHP_EOL;
echo "从一个无序数组中找出最长的有序长度:" . (new ArrayProblem())->findMaxLengthSorted([1, 2, 3, 2, 2, 2, 5, 4, 2]) . PHP_EOL;
echo "从有序数组中找出k个最接近x的元素:" . implode(",", (new ArrayProblem())->findClosestElements([1, 2, 3, 4, 5, 6, 7, 8, 9], 4, 6)) . PHP_EOL;
echo "接雨水:" . (new ArrayProblem())->trapTwoPoint([1, 2, 3, 2, 2, 2, 5, 4, 2]) . PHP_EOL;
echo "在排序数组中查找数字出现次数:" . (new ArrayProblem())->search([5, 7, 7, 8, 8, 8, 8, 10], 8) . PHP_EOL;
echo "使数组唯一的最小增量:" . (new ArrayProblem())->minIncrementForUnique([3,2,1,2,1,7]) . PHP_EOL;
echo "从有序数组中找出k个最接近x的元素:" . implode(",", (new ArrayProblem())->spiralOrder([
        [1,2,3],
        [4,5,6],
        [7,8,9]
    ])) . PHP_EOL;
echo "子集(递归):" . json_encode((new ArrayProblem())->subsetsRecursion([3,2,1])) . PHP_EOL;
echo "子集(回溯):" . json_encode((new ArrayProblem())->subsetsBacktracking([3,2,1])) . PHP_EOL;
echo "子集(迭代):" . json_encode((new ArrayProblem())->subsetsIteration([3,2,1])) . PHP_EOL;
```