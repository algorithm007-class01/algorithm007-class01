class Solution {
    /**
     *
     * 使用栈方式进行求解（类似括号匹配）
     *
     * 时间复杂度：O(n) 虽然 for 循环里套了一个 while 循环，但是考虑到每个元素最多访问两次，入栈一次和出栈一次，所以时间复杂度是 O(n)
     * 空间复杂度：O(n) 栈的空间。
     *
     * **/
    public int trap(int[] height) {
      int sum = 0;// 总面积

      // 只存放低的，如果碰到高的则出栈（小于等于栈顶值进行入栈，大于栈顶值出栈）（类似于左括号入栈，碰到右括号出栈）（注意：入栈的是下标）
      Stack<Integer> tempStack = new Stack<>();

      for (int i = 0; i < height.length ; i++) {

        // 如果栈不空，取出栈中所有小于当前高度的元素（等于的不取出），（且当前指向的高度大于栈顶高度就一直循环处理）
        while (!tempStack.empty() && height[i] > height[tempStack.peek()]) {
          int leftHeight = height[tempStack.pop()]; // 取出要出栈的元素
          if (tempStack.empty()) { // 如果当前栈中所有元素弹出，break。
            break;
          }
          int distance = i - tempStack.peek() - 1; // 两堵墙之前的距离（宽度）。
          int min = Math.min(height[tempStack.peek()], height[i]);// 高度取两者之间小的那个
          sum = sum + distance * (min - leftHeight);
        }// end of while

        // 如果当前指向的高度小于等于栈顶高度就入栈
        tempStack.push(i); // 当前指向的墙入栈

      }// end of for

      return sum;

    }
}