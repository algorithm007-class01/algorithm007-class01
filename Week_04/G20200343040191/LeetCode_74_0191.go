func searchMatrix(matrix [][]int, target int) bool {
    n := len(matrix)
    if n == 0 {
        return false 
    }
    m := len(matrix[0])
    l, r := 0, m * n - 1
    for l <= r {
        mid := l + (r - l) >> 1
        if matrix[mid/m][mid%m] == target {
            return true
        } else if matrix[mid/m][mid%m] < target {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return false
}
