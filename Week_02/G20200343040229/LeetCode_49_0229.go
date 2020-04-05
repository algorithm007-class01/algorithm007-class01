func groupAnagrams(strs []string) [][]string {
    var res [][]string
    record := make(map[string][]string)
    for _, str := range strs {
        s := []rune(str)            
        sort.Sort(sortRunes(s))     
        val, _ := record[string(s)] 
        val = append(val, str)
        record[string(s)] = val
    }

    for _, v := range record {
        res = append(res, v)
    }
    return res
}

type sortRunes []rune

func (s sortRunes) Len() int { 
    return len(s) 
}

func (s sortRunes) Less(i, j int) bool { 
    return s[i] < s[j] 
}

func (s sortRunes) Swap(i, j int) { 
    s[i], s[j] = s[j], s[i] 
}
