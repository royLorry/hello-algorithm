public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        while (i < j) {
            if (nums[i] != val) {
                i++;
            } else {
                while (nums[j] == val) {
                    j--;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // nums[i] = nums[i] + nums[j];
                // nums[j] = nums[j] - nums[i];
                // nums[i] = nums[i] - nums[j];
            }
        }
        return i + 1;
    }
}