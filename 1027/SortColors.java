public class SortColors {
    
    public void switchValue(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColors(int[] nums) {
        int lastIndexOfZero = -1;
        int lastIndexOfOne = -1;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    if (lastIndexOfZero == -1) {
                        // 第一次找到 0，挪至数组第一个
                        if (lastIndexOfOne == -1) {
                            switchValue(nums, ++lastIndexOfZero, i);
                        } else {
                            switchValue(nums, ++lastIndexOfZero, i);
                            switchValue(nums, ++lastIndexOfOne, i);
                        }
                    } else {
                        if (lastIndexOfOne == -1) {
                            switchValue(nums, ++lastIndexOfZero, i);
                        } else {
                            switchValue(nums, ++lastIndexOfZero, i);
                            switchValue(nums, ++lastIndexOfOne, i);
                        }
                    }
                    continue;
                case 1:
                    if (lastIndexOfOne == -1) {
                        // 第一次找到 1，挪至lastIndexOfZero后
                        lastIndexOfOne = lastIndexOfZero + 1;
                        switchValue(nums, lastIndexOfOne, i);
                    } else {
                        switchValue(nums, ++lastIndexOfOne, i);
                    }
                    continue;
                case 2:
                    continue;
                default:
                    continue;
            }
        }
    }
}