var canJump = function(nums) {
    let last=nums.length-1;
    for(let i = nums.length-1; i>-1; i--){
        if(i+nums[i]>=last){
         last=i;
        }
    }
    return last == 0;
};


/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    const len = nums.length;
    let start = 0;
    let end = nums[0];
    let max = nums[0];
    if(nums.length<2){
        return true;
    }
    if(nums[0]==0){
        return false;
    }
    while(max<len-1){
        let n = start;
        let m = end;
        start = end;
        //console.log(n,m)
        for(var i=n;i<=m;i++){
            if(i+nums[i]>max){
                max = i+nums[i];
                end = max;
                //console.log(end)
            }
        }
        if(end<len&&end<=m&&nums[m]==0){
            //console.log(end)
            return false;
        }
        
    }
    return true;
};
