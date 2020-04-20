package G20200343040041

import (
	"sort"
)

//字母异位词分组
func groupAnagrams(strs []string) [][]string {
	hash := make(map[string][]string)
	for _, str := range strs {
		sorted := sortStr(str)
		if _, ok := hash[sorted]; !ok {
			hash[sorted] = make([]string, 0)
		}
		hash[sorted] = append(hash[sorted], str)
	}
	res := make([][]string, 0)
	for _, s := range hash {
		res = append(res, s)
	}

	return res
}

func sortStr(str string) string {
	runes := []rune(str)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}
