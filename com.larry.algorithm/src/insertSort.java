public class insertSort {
    public static void insertSort(int[] nums) {
        int low = nums.length - 1;
        for (int i = 1; i <= low; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j]; // 往后移动
                } else { // 小于temp时
                    break;
                }
            }
            nums[j + 1] = temp;         // 保证了0号索引位置
        }
    }

    public static void insertSortRecur(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        sort(nums, 1);
    }

    private static void sort(int[] nums, int low) {
        if (low == nums.length) {
            return;
        }
        // 插入操作
        int temp = nums[low];
        int i = low - 1;
        for (; i >= 0; i--) {
            if (nums[i] > temp) {
                nums[i + 1] = nums[i];
            } else {
                // 此时已经比小
                break;
            }
        }
        nums[i + 1] = temp;         // 保证了插入0号索引位置
        sort(nums, low + 1);
    }
}

