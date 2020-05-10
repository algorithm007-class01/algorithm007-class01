func frequencySort(s string) string {
    sMap := map[byte]int{}
    for _, v := range []byte(s) {
        sMap[v]++
    }

    vs := NewValSorter(sMap)
    vs.Sort()
    ans := ""
    for i := len(vs.Vals)-1; i > -1; i-- {
        for j := 0; j < vs.Vals[i]; j++ {
            ans = ans + string(vs.Keys[i])
        }
    }

    return ans
}

type ValSorter struct {
    Keys []byte
    Vals []int
}

func NewValSorter(m map[byte]int) *ValSorter {
    vs := &ValSorter{
        Keys: make([]byte, 0, len(m)),
        Vals: make([]int, 0, len(m)),
    }
    for k, v := range m {
        vs.Keys = append(vs.Keys, k)
        vs.Vals = append(vs.Vals, v)
    }
    return vs
}

func (vs *ValSorter) Sort() {
    sort.Sort(vs)
}

func (vs *ValSorter) Len() int           { return len(vs.Vals) }
func (vs *ValSorter) Less(i, j int) bool { return vs.Vals[i] < vs.Vals[j] }
func (vs *ValSorter) Swap(i, j int) {
    vs.Vals[i], vs.Vals[j] = vs.Vals[j], vs.Vals[i]
    vs.Keys[i], vs.Keys[j] = vs.Keys[j], vs.Keys[i]
}

//方法二
type CharacterFrequency struct {
    Char byte
    Count int
}

func frequencySort(s string) string {
    characterFrequencys := [128]CharacterFrequency{}
    for _, char := range []byte(s){
        characterFrequencys[char].Count++
        characterFrequencys[char].Char = char
    }

    sort.Slice(characterFrequencys[0:128], func(i, j int) bool{return characterFrequencys[i].Count > characterFrequencys[j].Count})

    ans := make([]byte, 0, len(s))
    for i := 0; i < 128; i++ {
        for j := 0; j < characterFrequencys[i].Count; j++ {
            ans = append(ans, characterFrequencys[i].Char)
        }
    }
    return string(ans)
}

