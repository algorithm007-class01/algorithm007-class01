var lemonadeChange = function(bills) {
  let five = 0;
  let ten = 0;
  for (let i = 0; i < bills.length; i++) {
    if (bills[i] === 5) five++;
    if (bills[i] === 10) {
      five--;
      ten++;
      if (five < 0) return false;
    }
    if (bills[i] === 20) {
      if (ten === 0) {
        five -= 3;
        if (five < 0) return false;
      } else {
        ten--;
        five--;
        if (five < 0) return false;
      }
    }
  }
  return true;
};