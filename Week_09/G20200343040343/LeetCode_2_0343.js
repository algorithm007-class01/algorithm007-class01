var reverseStr = function (s, k) {
  var result = ''
  var isReverse = false
  for (var i = 0, len = s.length; i < len; i += k) {
    var str = s.slice(i, i + k)
    result += isReverse ? str : str.split('').reverse().join('')
    isReverse = !isReverse
  }
  return result
} 
