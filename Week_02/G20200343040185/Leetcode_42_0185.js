// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。//(l - 42)

// 1. 自左向右遍历, 自右向左遍历.(解题前先明确一个地方的水, 他的最大值是这个柱子左边区域的最大柱子和右边区域的
// 最小柱子的较小者减去当前柱子的高度, 自己根据图多想即可得出这一结论.) 遍历数组, 找到数组中的最大柱子, 从左向
// 右一一叠加相应位置的水, 这块区域每次计算都要实时更新左边的最高柱子直到遍历到最高柱子的位置. 再从数组最后向
// 前遍历, 直到到柱子的最高位置. 时间上, 第一次遍历数组找到最大值, 第二次遍历数组(拆分了), 计算每个位置水滴值,
// 时间复杂度为: O(n). 空间上, 就开辟了几个记录高度最大值的变量, 空间复杂度为: O(1).

var trap = function(height) {
  if (height.length <= 2) return 0;
  let max = height[0];
  let maxIndex = 0;
  height.forEach((num, index) => {
    if (num > max) {
      max = num;
      maxIndex = index;
    }
  });
  let sum = 0;
  let leftHeight = height[0];
  let rightHeight = height[height.length - 1];
  for (let i = 1; i < maxIndex; i++) {
    let water = leftHeight - height[i];
    if (water > 0) sum += water;
    leftHeight = Math.max(leftHeight, height[i]);
  }
  for (let i = height.length - 2; i > maxIndex; i--) {
    let water = rightHeight - height[i];
    if (water > 0) sum += water;
    rightHeight = Math.max(rightHeight, height[i]);
  }
  return sum;
};

// 2. stack.

function trap(height) {
  let res = 0;
  let i = 0;
  const st = [];

  while (i < height.length) {
    while (st.length !== 0 && height[i] > height[st[st.length - 1]]) {
      const top = st[st.length - 1];
      st.pop();
      if (st.length === 0) break;
      const dist = i - st[st.length - 1] - 1;
      const h = Math.min(height[i], height[st[st.length - 1]]) - height[top];
      res += dist * h;
    }
    st.push(i);
    i++;
  }
  return res;
}

console.log(trap([0,1,0,2,1,0,1,3,2,1,2,1]));

// 3. 双指针. 和解法 1 类似, 实际只需要找到左右高度小的哪一个, 而并不需要找到整题高度的最小值.
// 时间复杂度为: O(n). 比解法 1 少了找最大值的地方. 空间复杂度为: O(1).

var trap = function(height) {
  if (height.length <= 2) return 0;
  let sum = 0;
  let left = 0, right = height.length - 1;
  let leftMax = height[0], rightMax = height[height.length - 1];
  while (left < right) {
    if (height[left] < height[right]) {
      height[left] < leftMax ? sum += (leftMax - height[left]) : leftMax = height[left];
      left++;
    } else {
      height[right] < rightMax ? sum += (rightMax - height[right]) : rightMax = height[right];
      right--;
    }
  }
  return sum;
}