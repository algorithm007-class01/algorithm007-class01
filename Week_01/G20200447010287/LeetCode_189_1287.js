var rotate = function(nums, k) {
  for (let i = 0; i < k; i ++) {
    nums.unshift(nums.pop());
  }
};

var rotate = function(nums, k) {
  var n = nums.length;
  var newArr = new Array(n);
  for(var i = 0;i<n;i++){
      newArr[(i+k)%n] = nums[i];
  }    
  for(var r = 0;r<n;r++){
      nums[r] = newArr[r];
  }    
}

var rotate = function(nums, k) {
  nums.splice(0, 0, ...nums.splice(nums.length - k));
};