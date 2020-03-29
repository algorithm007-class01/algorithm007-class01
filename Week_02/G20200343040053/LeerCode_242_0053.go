package leetcode_week02_G20200343040053

//【242. 有效的字母异位词】

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

//leetcode submit region begin(Prohibit modification and deletion)
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	arr := [26]int{}
	for _, v := range s {
		arr[v-'a']++
	}
	for _, v := range t {
		arr[v-'a']--
		if arr[v-'a'] < 0 {
			return false
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)
