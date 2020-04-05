class Solution{
	int trap(vector<int>& height){
		// 方法一:双指针扫描大法
		// 保持left,right双指针，从左右开始扫，
		// left_max记录左边最大值，righ_max记录右边最大值
		// 当前值大于最大值，更新最大值
		// 当前值小于最大值，更新水滴累积大小.
		/*int left = 0, right = height.size() - 1;
		int area = 0;
		int left_max = 0, right_max = 0;
		int area = 0;
		while(left < right){
			if(height[left] < height[right]){
				if(height[left] > left_max){
					left_max = height[left];
				}else{
					area += left_max - height[left];
				}
				left++;

			}else{
				if(height[right] > right_max){
                                        right_max = height[right];
                                }else{
                                        area += right_max - height[right];
                                }
                                right--;

			}

		}
		return area;*/
		// 方法二: 双指针扫描大法(精简版)
		// 保持left,right双指针，从左右开始扫
		// secHeight 记录第二大值,
		// area保存第二大值与左右高度的偏差.
		/*int left = 0, right = height.size() - 1;
		int area = 0;
		int secHeight = 0;
		while(left < right){
			if(height[left] < height[right]){
				secHeight = max(secHeight, height[left]);
				area += secHeight - height[left];
				left++;
			}else{
				secHeight = max(secHeight, height[right]);
                                area += secHeight - height[right];
                                right--;
			}
		}
		return area;*/
		// 方法三，动态规划大法
		// 先做left_max, right_max数组
		// 然后累积min(left_max[i],right_max[i]) - height[i]的大小
		int size = height.size();
		if(0 == size){
			return size;
		}
		int area = 0;
		vector<int> left_max(size), right_max(size);
		left_max[0] = height[0];
		for(int i = 1; i < size; i++){
			left_max[i] = max(left_max[i-1], height[i]);
		}

		right_max[size - 1] = height[size - 1];
		for(int i = size - 2; i >= 0; i--){
			right_max[i] = max(right_max[i + 1], height[i]);
		}
		
		
		for(int i = 1; i < size - 1; i++){
			area += min(left_max[i], right_max[i]) - height[i];
		}
		return area;


	}
};
