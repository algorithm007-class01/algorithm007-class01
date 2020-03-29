var twoSum = function(nums, target) {
    var map = new Map()
    for(var i = 0; i < nums.length; i++) {
        var result = target - nums[i]
        if(map.has(result)) {
            return [map.get(result), i]
        } else {
            map.set(nums[i], i)
        }
    }
};