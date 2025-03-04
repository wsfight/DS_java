public class bubbleSort {
    public static void bubbleSort(int[] nums){
        // 双层循环即可
        int flag = nums.length - 1;
        for(int i = flag;i >= 0;i--){
            for(int j = 0;j < i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
