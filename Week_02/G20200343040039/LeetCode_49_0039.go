package G20200343040039

import "sort"

//["eat", "tea", "tan", "ate", "nat", "bat"]
func groupAnagrams(strs []string) [][]string {
	result := make([][]string, 0)
	cacheMap := make(map[string][]string)

	for i := 0; i < len(strs); i++ {
		temp := []byte(strs[i])
		sort.Slice(temp, func(m, n int) bool {
			return temp[m] < temp[n]
		})
		cacheMap[string(temp)] = append(cacheMap[string(temp)], strs[i])
	}

	for _, value := range cacheMap {
		result = append(result, value)
	}

	return result
}

func groupAnagrams_1(strs []string) [][]string {
	result := make([][]string, 0)
	cache := make(map[[26]int][]string)
	for i := 0; i < len(strs); i++ {
		count := [26]int{}

		for _, char := range strs[i] {
			count[char-'a']++

		}
		cache[count] = append(cache[count], strs[i])
	}

	for _, value := range cache {
		result = append(result, value)
	}

	return result
}