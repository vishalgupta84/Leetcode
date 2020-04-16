public class SortedArrayToBinarySearchTree {
    TreeNode create(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (end-start)/2+start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid-1);
        root.right = create(nums, mid+1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length-1);
    }
}
