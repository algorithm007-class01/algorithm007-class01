func plusOne(_ digits: [Int]) -> [Int] {
   var digitArr = digits
   if digits.count < 1 { return digits }
   // 1. 如果末位加上1小于10，则直接返回
   let last = digits.last!
   if (last + 1) < 10 {
       digitArr[digitArr.count-1] = last + 1
       return digitArr
   } else {
       // 2. 如果末位加上1大于9，则轮询位数
       let i = digitArr.count-1
       digitArr[i] = 0
       if digitArr.count == 1 {
           digitArr.insert(1, at: 0)
           return digitArr
       } else {
           digitArr[i-1] = digitArr[i-1] + 1
           var index = i - 1
           while index > -1 {
               if digitArr[index] > 9 {
                   digitArr[index] = 0
                   if index == 0 {
                       digitArr.insert(1, at: 0)
                   }else {
                       digitArr[index-1] = digitArr[index-1] + 1
                   }
                } else {
                   return digitArr
               }
                index-=1
           }
           return digitArr
        }
    }
}
