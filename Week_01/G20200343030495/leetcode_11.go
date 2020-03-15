package G20200343030495

func maxArea(height []int) int {
	i, j, area := 0, len(height) -1 , 0
	for i < j {
		if height[i] > height[j] {
			if area < (j - i) * height[j] {
				area = (j - i) * height[j]
			}
			j--
		} else {
			if area < (j -i) * height[i] {
				area = (j -i) * height[i]
			}
			i++
		}
	}
	return area
}
