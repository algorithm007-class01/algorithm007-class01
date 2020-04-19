学习笔记

### 广度优先搜索代码模板

```java
class Solution {
    // 二叉树层序遍历为例
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // 当前层结点数目
            List<Integer> oneLevel = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode cur = queue.poll();
                // 当前层的结点值加入到列表中
                oneLevel.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                count--;
            }
            res.offer(oneLevel);
        }
        return res;
    }
}
```



### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

```java
class Solution {
    // 半有序数组本身是有左右边界的且可以用下标访问数组元素
    // 半有序本身是有两段单调的部分，所以可以使用二分查找
    // 乱序以后最小值可能不在数组第一个元素，所以找到数组中最小值就找到了无序的地方
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // 设置左右边界
        int left = 0;
        int right = len - 1;
        // 右边边界元素与左边边界元素比较大小
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (left <= right) {
            // 找到数组最中间元素
            int mid = (left + right) / 2;
            // 比较中间元素与之后一个元素的大小，如果大于则返回后一个元素
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            // 比较中间元素与之前一个元素的大小，如果小于则返回中间元素
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            // 比较中间元素与最左边元素的大小，如果大于则将左边边界移动到中间元素之后
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
            // 比较中间元素与最左边元素的大小，如果小于则将右边边界移动到中间元素之前
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```

