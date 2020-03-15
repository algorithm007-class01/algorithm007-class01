class Solution {
  func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    var dict:[Int: Int] = [:]

    for (index, value) in nums.enumerated() {
      if let lastIndex = dict[target - value] {
        return [lastIndex, index]
      }

      dict[value] = index
    }

    return []
  }
}
