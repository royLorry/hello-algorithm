import java.util.ArrayList;

public class TrappingRainWater {
    public int trap(int[] height) {
        int arrayLength = height.length;
        if (arrayLength <= 1) {
            return 0;
        }
        int maxHeight = height[0];
        /**
         * 求出最大高度
         */
        for (int i = 0, thisHeight = 0; i < arrayLength; i++) {
            thisHeight = height[i];
            if (thisHeight > maxHeight) {
                maxHeight = thisHeight;
            }
        }
        /**
         * 从第一层开始往上，记录每一层能有值的下标，这些下标所记录的值之间如有空位必定可以存水
         */
        int pool = 0;
        for (int i = 1; i <= maxHeight; i++) {
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            for (int j = 0, thisHeight = 0; j < arrayLength; j++) {
                thisHeight = height[j];
                if (i <= thisHeight) {
                    thisLevel.add(j);
                }
            }
            int thisLevelSize = thisLevel.size();
            for (int k = 1; k < thisLevelSize; k++) {
                pool += (thisLevel.get(k) - thisLevel.get(k-1) -1);
            }
        }
        return pool;
    }
}