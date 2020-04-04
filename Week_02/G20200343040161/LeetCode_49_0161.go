package G20200343040161

func groupAnagrams(strs []string) [][]string {
	if strs == nil || len(strs) == 0 {
		return [][]string{}
	}
	sMap := make(map[string][]int, 0)
	for i, s := range strs {
		s = aSort(s)
		if _, ok := sMap[s]; ok {
			sMap[s] = append(sMap[s], i)
		} else {
			sMap[s] = []int{i}
		}
	}
	res := make([][]string, 0)
	for _, v := range sMap {
		x := make([]string, 0)
		for _, s := range v {
			x = append(x, strs[s])
		}
		res = append(res, x)
	}
	return res
}

func aSort(s string) string {
	x := []byte(s)
	sort.Slice(x, func(i, j int) bool {return x[i] < x[j]})
	return string(x)
}
