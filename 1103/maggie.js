var canJump = function(nums) {
    let last=nums.length-1;
    for(let i = nums.length-1; i>-1; i--){
        if(i+nums[i]>=last){
         last=i;
        }
    }
    return last == 0;
};
