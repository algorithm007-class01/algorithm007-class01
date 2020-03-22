let twoSum = (nums, target) => {
    let targetMap = new Map()
    for (let i = 0; i < nums.length; i++) {
      const key = target - nums[i]
      if (targetMap.has(key)) {
        return [targetMap.get(key), i]
      }
      targetMap.set(nums[i], i)
    }
  }