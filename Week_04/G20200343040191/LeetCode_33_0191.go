func search(nums []int, target int) int {
    l, r := 0, len(nums) - 1
    for l < r {
        mid := l + (r - l) / 2
        if nums[mid] > nums[r] {
            l = mid + 1
        } else {
            r = mid
        }
    }
    rot := l
    l, r = 0, len(nums) - 1
    for l <= r {
        mid := l + (r - l) / 2
        realMid := (mid + rot) % len(nums)
        if nums[realMid] == target {
            return realMid
        } else if nums[realMid] < target {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return -1
}
