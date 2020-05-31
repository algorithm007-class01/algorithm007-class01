/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  let count = new Map();
  let n = s.length;

  for (let i = 0; i < n; i++) {
      let c = s.charAt(i);
      count.set(c, (count.get(c) ||  0) + 1);
  }
  
  // find the index
  for (let i = 0; i < n; i++) {
      if (count.get(s.charAt(i)) == 1) 
          return i;
  }
  return -1;
};