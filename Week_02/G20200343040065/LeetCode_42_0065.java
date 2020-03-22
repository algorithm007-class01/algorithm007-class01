package leetCode.week02;

public class LeetCode_42_0065 {
	
	 public int trap(int[] height) {
		 
		 	int left_max = 0;
		 	int right_max = 0;
		 	int left = 0;
		 	int right = height.length - 1;
		 	int ans = 0;
		 	
		 	while (left < right) {
		 		if (height[left] <= height[right]) {
		 			int a = height[left] < left_max ? ans += (left_max - height[left]) : (left_max = height[left]);
		 			left++;
		 		} else {
		 			int a = height[right] < right_max ? ans += (right_max - height[right]) : (right_max = height[right]);
		 			right--;
		 		}
		 	}
		 	
		 	return ans;
	    }
}
