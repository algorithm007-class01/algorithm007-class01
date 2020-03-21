func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
    nums1.removeSubrange(m..<nums1.count)
    nums1 = nums1 + nums2
    nums1 = nums1.sorted()
}
