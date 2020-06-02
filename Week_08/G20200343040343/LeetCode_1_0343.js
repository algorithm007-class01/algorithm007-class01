var hammingWeight = function (n) {
  let count = 0
  let mask = 1
  for (let i = 0; i < 32; i++) {
    if ((n & mask) != 0) {
      count++
    }
    mask <<= 1
  }
  return count
}
