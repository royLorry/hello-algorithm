//最大矩形
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if(heights.length<1){
        return 0
    }
    let result = heights[0];
    for(let i=0; i<heights.length;i++){
        let secMin=heights[i];
        for(let j=i;j<heights.length;j++){  
            if(heights[j] <= secMin){
                secMin=heights[j];
            }
            if(result<secMin*(j-i+1)){     
                result=secMin*(j-i+1);
            }
        }
    }
    return result;
};
