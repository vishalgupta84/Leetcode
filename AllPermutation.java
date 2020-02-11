class AllPermutation {
    private void nextPermutation(int[] nums) {
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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
        if(n == 0)
            return ans;
		int fact = 1;
		for(int i=2;i<=n;i++)
			fact *= i;
		for(int i=1;i<=fact; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<n;j++){
                tmp.add(nums[j]);
            }
            ans.add(tmp);
			nextPermutation(nums);
		}
		return ans;
    }
}