# week 04学习笔记
解题思路：
题目要求` O(logN) `的时间复杂度，基本可以断定本题是需要使用二分查找。
由于题目说数字了无重复，举个例子：
`[1 2 3 4 5 6 7] `可以大致分为两类，
第一类 `[2 3 4 5 6 7 1]` 这种，也就是 `nums[start] <= nums[mid]`。此例子中就是 2 <= 5。
这种情况下，前半部分有序。因此如果 `nums[start] <=target<nums[mid]`，则在前半部分找，否则去后半部分找。
第二类 `[6 7 1 2 3 4 5]`这种，也就是 `nums[start] > nums[mid]`。此例子中就是 `6 > 2`。
这种情况下，后半部分有序。因此如果 `nums[mid] <target<=nums[end]`，则在后半部分找，否则去前半部分找。

此题有个存在重复数字的变形题，可参考 此题解 。

代码：

```java
Java
public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    int mid;
    while (start <= end) {
        mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        //前半部分有序,注意此处用小于等于
        if (nums[start] <= nums[mid]) {
            //target在前半部分
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (target <= nums[end] && target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

    }
    return -1;

}
```