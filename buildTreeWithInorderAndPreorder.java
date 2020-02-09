/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class buildTreeWithInorderAndPreorder {
    static int idx = 0;
    private int search(int[] inorder, int n, int start, int end) {
        int i = -2;
        for(i=start;i<=end;i++){
            if(inorder[i] == n)
                return i;
        }
        return i;
    }
    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if(start>end)
            return null;
        TreeNode tmp = new TreeNode(preorder[idx++]);
        if(start == end)
            return tmp;
        int i = search(inorder, tmp.val, start, end);
        tmp.left = build(preorder, inorder, start, i-1);
        tmp.right = build(preorder, inorder, i+1, end);
        return tmp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        return build(preorder, inorder, 0, inorder.length-1);
    }
}