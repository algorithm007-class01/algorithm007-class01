func moveZeroes(_ nums: inout [Int]) {
    if nums.count < 1 { return }
    var j = 0 // 记录非0的个数
    for i in 0..<nums.count {
        if nums[i] != 0 {
            nums[j] = nums[i]
            j+=1
        }
    }
    for zero in j..<nums.count {
        nums[zero] = 0
    }
}
