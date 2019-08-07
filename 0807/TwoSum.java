import java.util.Map;

public class TwoSum {

    /**
     * 最快的
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFastest(int[] nums, int target) {
        int indexArrayMax = 2047;
        int[] indexArray = new int[indexArrayMax + 1];
        int diff = 0;
        for (int i=0; i<nums.length; i++) {
            diff = target - nums[i];
            if (indexArray[diff & indexArrayMax] != 0) {
                return new int[]{indexArray[diff & indexArrayMax] - 1, i};
            }
            indexArray[nums[i] & indexArrayMax] = i + 1;
        }
        return null;
    }

    /**
     * 自己写的
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                temp = map.get(nums[i]);
                if (temp < i) {
                    return new int[] {temp, i};
                } 
                if (temp > i) {
                    return new int[] {i, temp};
                }
            }
            
        }
        return null;
    }
}