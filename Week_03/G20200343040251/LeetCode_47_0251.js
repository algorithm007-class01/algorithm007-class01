var permuteUnique = function(nums) {
    if(!nums || nums.length == 0) return [[]];
    let ans=[], used = [], map = {};
    getPermute(0,[]);

    return ans;

    function getPermute(index, tmp){
        if(index == nums.length){
            if(!map[tmp.toString()]){
                ans.push(tmp);
                map[tmp.toString()] =1;
            }
            return;
        }

        for(let i = 0; i<nums.length; i++){
            if(!used[i]){
                tmp.push(nums[i]);
                used[i] = true;
                getPermute(index+1, tmp.slice());
                tmp.pop();
                used[i] =false;
            }
            
        }
    }
};