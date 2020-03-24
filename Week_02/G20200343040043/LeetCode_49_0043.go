package G20200343040043

import "sort"

// 题目：https://leetcode-cn.com/problems/group-anagrams/
// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

// 解法
// 数组内逐个遍历，并对其排序，排序结果计入map，v为当前slice的长度，如果在map中存在，下标为异位词所在slice下标
func groupAnagrams(strs []string) [][]string {
	resMap := make(map[string]int)
	var res [][]string

	for _, str := range strs {
		x := []byte(str)
		sort.Slice(x, func(i, j int) bool { return x[i] < x[j] })
		if idx, ok := resMap[string(x)]; ok {
			res[idx] = append(res[idx], str)
		} else {
			resMap[string(x)] = len(res)
			res = append(res, []string{str})
		}

	}
	return res
}

// times: 1