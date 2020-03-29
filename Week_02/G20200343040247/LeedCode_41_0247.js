/**
 * 双指针
 */
var trap = function(height) {
    var left = 0, right = height.length - 1;
    var ans = 0;
    var left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            //左边界的
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}