func leastInterval(tasks []byte, n int) int {
    rec := make([]int, 26)
    for _, t := range tasks {
        rec[t-'A']++
    }
    sort.Ints(rec)
    tmpMax := (rec[25]-1) * n + rec[25]
    for i := 24; i >= 0 && rec[i] == rec[25]; i-- {
        tmpMax++
    }
    return max(tmpMax, len(tasks))
}

func max(a, b int) int {
    if a > b {
        return a 
    }
    return b
}
