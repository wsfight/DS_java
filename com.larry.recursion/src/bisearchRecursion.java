public class bisearchRecursion {
    public static int bisearchRecursion(int[] nums,int target,int left,int right){
        // 怎么使用递归?
        if(left > right){
            return -1;
        }
        int mid = left + ((right - left) >>> 1);
        if(nums[mid] == target){
            return mid;
        } else if (target < nums[mid]) {
            return bisearchRecursion(nums,target,left,mid - 1);
        }else{
            return bisearchRecursion(nums,target,mid + 1,right);
        }
    }
}
