package leetcode_week02_G20200343040053

import "sort"

//【49. 字母异位词分组】

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

//leetcode submit region begin(Prohibit modification and deletion)
func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string)
	for _, str := range strs {
		b := []byte(str)
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		key := string(b)
		m[key] = append(m[key], str)
	}
	ret := make([][]string, 0, len(m))
	for _, v := range m {
		ret = append(ret, v)
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)

func groupAnagramsSolution2(strs []string) [][]string {
	m := make(map[[26]byte]int)
	ret := make([][]string, 0)
	for i := range strs {
		list := [26]byte{}
		for j := range strs[i] {
			list[strs[i][j]-'a']++
		}
		if k, ok := m[list]; ok {
			ret[k] = append(ret[k], strs[i])
		} else {
			ret = append(ret, []string{strs[i]})
			m[list] = len(ret) - 1
		}
	}
	return ret
}
