func rotate(_ nums: inout [Int], _ k: Int) {
       if nums.count < 1 { return }
       var i = k
       while i > 0 {
           let last = nums.last!
           nums.insert(last, at: 0)
           nums.removeLast()
           i-=1
       }
   }
