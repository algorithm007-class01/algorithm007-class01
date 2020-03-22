class Solution {
  func groupAnagrams(_ strs: [String]) -> [[String]] {
    if strs.isEmpty {
      return []
    }

    var map: [String: [String]] = [:]

    for str in strs {
      let sortedStr = String(str.sorted())
      map[sortedStr, default: []].append(str)
    }

    return Array(map.values)
  }
}
