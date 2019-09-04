//方法一：
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
    function maxNum(arr) {
        let max = arr[0];
        let maxIndex = 0;
        for (let i = 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return [max, maxIndex];
    }

    function sumArr(arr) {
        return arr.reduce(function (prev, cur) {
            return prev + cur;
        }, 0);
    }
    let water = 0;
    let leftTopNum = maxNum(height);
    let rightTopNum = maxNum(height);
    let leftarr = height.slice(0, leftTopNum[1]);
    let rightarr = height.slice(rightTopNum[1] + 1);
    while (leftarr.length > 1) {
        let tempmax = maxNum(leftarr);
        water = water + tempmax[0] * (leftarr.length - tempmax[1] - 1) - sumArr(leftarr.slice(tempmax[1] + 1));
        leftarr = leftarr.slice(0, tempmax[1]);
        leftTopNum = tempmax;    
    }
    while (rightarr.length > 1) {
        let tempmax = maxNum(rightarr);
        water = water +  tempmax[0] * tempmax[1] - sumArr(rightarr.slice(0, tempmax[1]));
        rightarr = rightarr.slice(tempmax[1] + 1);
    }
    return water;
};
方法二：
var trap = function(height) {
    let max=0;
    let maxIndex=0;
    for(let i=0;i<height.length;i++){
        if(height[i]>=max){
            max = height[i];
            maxIndex = i;
        }
    }
    let start = 0;
    let current = start+1;
    let water = 0;
    for (let i = 0;i<maxIndex;i++){
        if(height[current]<height[start]){
            water=water+height[start]-height[current];
        } else {
            start = current;
        }
        current++;
    }
    start = height.length-1;
    current = height.length-2;
    for (let i = height.length-1; i>maxIndex; i--){
        if(height[current]<height[start]){
            water = water+height[start]-height[current];
        }else{
            start = current;  
        }
         current--;
    }
    return water;
};
