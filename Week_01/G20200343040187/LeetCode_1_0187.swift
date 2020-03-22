func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    for i in 0..<nums.count {
        let num1 = nums[i]
        for j in (i+1)..<nums.count {
            let num2 = nums[j]
            if num1 + num2 == target {
                return [i, j]
            }
        }
    }
    return []
}
