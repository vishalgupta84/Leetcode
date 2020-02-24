/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left != null) {
            flatten(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode t = root.right;
            while(t.right != null)
                t = t.right;
            t.right = right;
        }
        flatten(root.right);
    }
}
