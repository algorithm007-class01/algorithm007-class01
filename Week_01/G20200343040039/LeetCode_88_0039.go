package G20200343040039

func merge(nums1 []int, m int, nums2 []int, n int)  {
	p := m+n-1
	p1 := m-1
	p2 := n-1

	for p1 >= 0 && p2 >= 0 {
		if nums2[p2] > nums1[p1] {
			nums1[p] = nums2[p2]
			p--
			p2--
		} else {
			nums1[p] = nums1[p1]
			p--
			p1--
		}
	}

	for i := 0; i <= p2; i++ {
		nums1[i] = nums2[i]
	}
}