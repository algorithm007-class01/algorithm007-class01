func reverseWords(s string) string {
    str_slice := []string{}
    for _, str := range strings.Split(s, " ") {
        if str == "" {
            continue
        }
        str_slice = append(str_slice, str)
    }

    if len(str_slice) == 0 {
        return ""
    }

    new_str := str_slice[len(str_slice) - 1]
    for i := len(str_slice) - 2; i >= 0; i-- {
        new_str += " " + str_slice[i]
    }

    return new_str
}

