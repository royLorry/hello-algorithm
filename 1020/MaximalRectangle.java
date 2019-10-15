import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;

public class MaximalRectangle {
    public int largestRectangleArea(int[] heights) {
        HashMap<Integer, ArrayList<Integer>> keyAndIndexMap = new HashMap<>();
        SortedSet<Integer> sortedKey = new TreeSet<Integer>();
        for (int i = 0; i < heights.length; i++) {
            int thisValue = heights[i];
            if (keyAndIndexMap.containsKey(thisValue)) {
                ArrayList indexArrayList = keyAndIndexMap.get(thisValue);
                indexArrayList.add(i);
            } else {
                ArrayList indexArrayList = new ArrayList<Integer>();
                indexArrayList.add(i);
                keyAndIndexMap.put(thisValue, indexArrayList);
                sortedKey.add(thisValue);
            }
        }
        int max = 0;
        Iterator<Integer> it = sortedKey.iterator();
        while(it.hasNext()){
            int key = it.next();
            int left = 0;
            int right = heights.length;
            


        }
        return 0;
    }
}