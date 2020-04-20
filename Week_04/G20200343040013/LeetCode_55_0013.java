/**
 * 跳跃游戏
 */
public boolean canJump(int[] nums) {
    int k = 0;

    for(int i = 0; i < nums.length; i ++) {
        if( i > k) {
            return false;
        }
        k = Math.max(k, i + nums[i]);
    }
    return true;
}

public boolean canJump1(int[] nums) {
    int lastPoi = nums.length - 1;

    for(int i = nums.length - 1; i >= 0; i--) {
        if (i + nums[i] >= lastPoi) {
            lastPoi = i;
        }
    }
    return lastPoi == 0;
}