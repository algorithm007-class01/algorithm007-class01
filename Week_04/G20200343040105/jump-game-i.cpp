//55 - 跳跃游戏I
//思路：贪心算法
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 0) return false;
        int endReachable = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; --i) {
            if (nums[i] + i >= endReachable)
                endReachable = i;
        }
        return endReachable == 0;
    }
};

//贪心思路:(写法2)
/**1.如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
  *2.可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
  *3.如果可以一直跳到最后，就成功了。
  */
class Solution {
public:
    bool canJump(vector<int>& nums)  {
        int k = 0;    //k为当前位置能跳到的最远距离
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) return false;
            k = max(k, i + nums[i]);
        }
        return true;
    }
};