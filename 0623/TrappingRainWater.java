import java.util.ArrayList;

public class TrappingRainWater {
    private List<Integer> insertNewArrow(List<Integer> sideArrayList,int[] height, int currentArrow){
        int listLast = sideArrayList.size();
        int p = listLast - 2;
        if (listLast > 1 && height[sideArrayList.get(listLast-1)] < height[currentArrow]) {
            while (p >= 0) {
                int pValue = height[sideArrayList.get(p)];
                int i = p + 1;
                while (i < listLast) {
                    if (pValue <= height[sideArrayList.get(i)]) {
                        break;
                    }
                    i++;
                }
                if (i == listLast) {
                    sideArrayList = sideArrayList.subList(0, p+1);
                    listLast = sideArrayList.size();
                }
                if (pValue >= height[currentArrow]) {
                    break;
                }
                p--;
            }
        }
        sideArrayList.add(currentArrow);
        return sideArrayList;
    }

    public int trap(int[] height) {
        int arraySize = height.length;
        if (arraySize < 3) {
            return 0;
        }
        List<Integer> sideArrayList = new ArrayList<Integer>();
        int before = 0;
        int current = height[0];
        int next = 0;
        if (current > 0) {
            sideArrayList.add(0);
        }
        for (int i = 1, max = arraySize - 1; i < max; i++) {
            before = height[i -1];
            current = height[i];
            next = height[i+1];
            if (current > before && current >= next){
                sideArrayList = insertNewArrow(sideArrayList, height, i);
            }
        }
        current = height[arraySize-1];
        if (current > height[arraySize - 2]) {
            sideArrayList = insertNewArrow(sideArrayList, height, arraySize-1);
        }
        int listLast = sideArrayList.size();
        if (listLast > 1) {
            int pool = 0;
            for (int i = 0, max = listLast - 1, left = 0, right = 0, leftVaule = 0, rightVaule = 0, lowerVaule = 0; i < max; i++) {
                left = sideArrayList.get(i);
                right = sideArrayList.get(i+1);
                leftVaule = height[left];
                rightVaule = height[right];
                lowerVaule = leftVaule < rightVaule ? leftVaule : rightVaule;
                for (int j = left + 1; j < right; j++) {
                    current = height[j];
                    if (lowerVaule > current) {
                        pool += lowerVaule - current;
                    }
                }
            }
            return pool;
        } else {
            return 0;
        }
    }
}