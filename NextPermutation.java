import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1)
            return;
        int start = n - 2;
        while(start>=0 && nums[start] >= nums[start+1])
            start--;
        if(start < 0){
            Arrays.sort(nums, 0, n);
            return;
        }
        int end = n-1;
        while(end>start) {
            if(nums[end] > nums[start])
                break;
            end--;
        }
        int t = nums[end];
        nums[end] = nums[start];
        nums[start] = t;
        Arrays.sort(nums, start+1, n);
    }
}
