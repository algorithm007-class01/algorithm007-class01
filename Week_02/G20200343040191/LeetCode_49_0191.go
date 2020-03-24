func groupAnagrams(strs []string) [][]string {
    prime := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101}
    resMap := make(map[int]int)
    counter := 1
    res := [][]string{}
    for _, s := range strs {
        k := 1
        for _, c := range s {
            k *= prime[c - 'a']
        }
        if resMap[k] != 0 {
            res[resMap[k]-1] = append(res[resMap[k]-1], s)
        } else {
            resMap[k] = counter
            counter++
            res = append(res, []string{s})
        }
    }
    return res
}
