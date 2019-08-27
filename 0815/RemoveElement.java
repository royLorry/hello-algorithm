public class RemoveElement {

    public int official(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        while (i < j) {
            if (nums[i] == val) {
                while (nums[j] == val) {
                    j--;
                }
                if (j == i) {
                    break;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // nums[i] = nums[i] + nums[j];
                // nums[j] = nums[j] - nums[i];
                // nums[i] = nums[i] - nums[j];
            }
            i++;
        }
        return i;
    }
}