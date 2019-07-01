import java.util.ArrayList;

public class TrappingRainWaterII2 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int X = heightMap.length;
        int Y = heightMap[0].length;
        int[][] heights = new int[X][];
        for (int i = 0; i < X; i++) {
            heights[i] = new int[Y];
        }
        int result = 0;
        int lastResult = 1;
        while (lastResult != result) {
            for (int i = 1; i < X - 1; i++) {
                for (int j = 1; j < Y - 1; j++) {
                    int height = Math.min(Math.max(heightMap[i - 1][j], heights[i - 1][j]),
                            Math.max(heightMap[i][j - 1], heights[i][j - 1]));
                    heights[i][j] = heights[i][j] == 0 ? height : Math.min(heights[i][j], height);
                }
            }

            for (int i = X - 2; i >= 1; i--) {
                for (int j = Y - 2; j >= 1; j--) {
                    int height = Math.min(Math.max(heightMap[i + 1][j], heights[i + 1][j]),
                            Math.max(heightMap[i][j + 1], heights[i][j + 1]));
                    heights[i][j] = Math.min(heights[i][j], height);
                }
            }
            int sum = 0;
            for (int i = 1; i < X - 1; i++) {
                for (int j = 1; j < Y - 1; j++) {
                    if (heights[i][j] > heightMap[i][j])
                        sum += (heights[i][j] - heightMap[i][j]);
                }
            }
            result = lastResult;
            lastResult = sum;
        }
        return result;
    }

    public static void main(String[] args){
        TrappingRainWaterII2 t = new TrappingRainWaterII2();
        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        t.trapRainWater(heightMap);
    }
}