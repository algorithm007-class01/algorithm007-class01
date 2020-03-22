package G20200343040041

//有序数组合并
func merge(nums1 []int, m int, nums2 []int, n int)  {
	i,j,tail:=m-1,n-1,m+n-1
	for i>=0 &&j>=0{
		if nums1[i]>nums2[j]{
			nums1[tail]=nums1[i]
			i--
		}else{
			nums1[tail]=nums2[j]
			j--
		}
		tail--
	}
	//m为0的情况
	for j>=0{
		nums1[tail]=nums2[j]
		j--
		tail--
	}
}
