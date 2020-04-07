var findContentChildren = function(g, s) {
  g.sort((x, y) => x - y);
  s.sort((x, y) => x - y);
  let x = Math.min(g.length, s.length);
  let p = 0;
  let sum = 0;
  for (let i = 0; i < x; i++) {
      while (g[i] > s[p]) {
        p++;
        if (p >= s.length) return sum;
      }
      if (p >= s.length) return sum;
      sum++;
      p++;
  }
  return sum;
};