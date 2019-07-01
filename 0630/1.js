/**
 * @param {number[][]} heightMap
 * @return {number}
 */
var trapRainWater = function(heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
    let X = heightMap.length;
    let Y = heightMap[0].length;
    let heights = new Array(X);
    for (let i = 0; i < X; i++) {
        heights[i] = new Array(Y);
    }
    let result = 0;
    let lastResult = 1;
    while (lastResult != result) {
        for (let i = 1; i < X - 1; i++) {
            for (let j = 1; j < Y - 1; j++) {
                let height = Math.min(Math.max(heightMap[i - 1][j], heights[i - 1][j]), Math.max(heightMap[i][j - 1], heights[i][j - 1]));
                heights[i][j] = heights[i][j] == 0 ? height : Math.min(heights[i][j], height);
            }
        }

        for (let i = X - 2; i >= 1; i--) {
            for (let j = Y - 2; j >= 1; j--) {
                let height = Math.min(Math.max(heightMap[i + 1][j], heights[i + 1][j]),
                        Math.max(heightMap[i][j + 1], heights[i][j + 1]));
                heights[i][j] = Math.min(heights[i][j], height);
            }
        }

        let sum = 0;
        for (let i = 1; i < X - 1; i++) {
            for (let j = 1; j < Y - 1; j++) {
                if (heights[i][j] > heightMap[i][j])
                    sum += (heights[i][j] - heightMap[i][j]);
            }
        }
        result = lastResult;
        lastResult = sum;
    }
    return result;
};