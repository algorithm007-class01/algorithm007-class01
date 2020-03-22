package G20200343040161

func merge(nums1 []int, m int, nums2 []int, n int)  {
	if n == 0{
		return
	}

	for i := 0; i < n; i++ {
		nums1[m+i] = nums2[i]
		for j := m+i; j >= 1; j-- {
			if nums1[j] < nums1[j-1] {
				nums1[j], nums1[j-1] = nums1[j-1] ,nums1[j]
			}
		}
	}

	return
}