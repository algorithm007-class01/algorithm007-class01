var merge = function(nums1, m, nums2, n) {
  let len1 = m - 1;
  let len2 = n - 1;
  let len = m + n - 1;
  while(len1 >= 0 && len2 >= 0) {
      // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
      nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
  }
  function arrayCopy(src, srcIndex, dest, destIndex, length) {
      dest.splice(destIndex, length, ...src.slice(srcIndex, srcIndex + length));
  }
  // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
  arrayCopy(nums2, 0, nums1, 0, len2 + 1);
};