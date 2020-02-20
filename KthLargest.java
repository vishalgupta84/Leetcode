public class KthLargest {
    private int partition(int[] array, int left, int right) {
        int pivot = left;
        for(int i=left;i<right;i++) {
            if(array[i] >= array[right]) {
                int t = array[pivot];
                array[pivot] = array[i];
                array[i] = t;
                pivot++;
            }
        }
        int t = array[pivot];
        array[pivot] = array[right];
        array[right] = t;
        return pivot;
    }
    private int quickSort(int[] array, int left, int right, int k) {
        if(k > 0 && (k<=(right-left+1))) {
            int pivot = partition(array, left, right);
            if(pivot-left == k-1)
                return array[pivot];
            else if(pivot-left > k-1)
                return quickSort(array, left, pivot-1, k);
            else
                return quickSort(array, pivot+1, right, k-pivot+left-1);
        }
        return Integer.MAX_VALUE;
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0];
        return quickSort(nums, 0, nums.length-1, k);
    }
}
