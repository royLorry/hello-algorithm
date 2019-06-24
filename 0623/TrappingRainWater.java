import java.util.ArrayList;

public class TrappingRainWater {
    public int trap(int[] height) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int start = 0;
        int current = 1;
        int water = 0;
        for (int i = 0; i < maxIndex; i++) {
            if(height[current]<height[start]){
                water = water + height[start] - height[current];
            } else {
                start = current;
            }
            current++;
        }
        start = height.length-1;
        current = height.length-2;
        for (int i = height.length-1; i>maxIndex; i--){
            if(height[current] < height[start]){
                water = water + height[start] - height[current];
            }else{
                start = current;  
            }
            current--;
        }
        return water;
    }
}