class Solution {
  func moveZeroes(_ nums: inout [Int]) {
    var j: Int = 0

    for (index, num) in nums.enumerated() {
      if num != 0 {
        nums[j] = num

        if index != j {
          nums[index] = 0
        }

        j += 1
      }
    }
  }
}