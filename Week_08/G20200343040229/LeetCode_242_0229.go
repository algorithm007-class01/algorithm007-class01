func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    sArray := [26]int{}
    for i, value := range []byte(s) {
        sArray[value-'a']++
        sArray[t[i]-'a']--
    }

    for _, value := range sArray {
        if value != 0 {
            return false
        }
    }

    return true
}

