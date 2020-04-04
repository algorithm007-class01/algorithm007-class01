var permute = function(nums) {
    if(!nums || nums.length == 0) return [[]];
    let ans=[], used = [];
    getPermute(0,[]);

    return ans;

    function getPermute(index, tmp){
        if(index == nums.length){
            ans.push(tmp);
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