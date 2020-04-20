func numDecodings(s string) int {
    if s[0] == '0' {
        return 0
    }
    prev, cur := 1, 1
    for i := 1; i < len(s); i++ {
        tmp := cur
        if s[i] == '0' {
            if s[i-1] == '1' || s[i-1] == '2' {
                cur = prev
            } else {
                return 0
            }
        } else if s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '1' && s[i] <= '6') {
            cur = cur + prev
        }
        prev = tmp
    }
    return cur
}
