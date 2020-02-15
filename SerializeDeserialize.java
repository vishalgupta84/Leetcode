import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SerializeDeserialize {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        if(root != null) {
            queue.add(root);
            ans.append(root.val).append(" ");
        }
        while (!queue.isEmpty()) {
            TreeNode top = queue.peek();
            queue.remove();
            if(top.left != null) {
                queue.add(top.left);
                ans.append(top.left.val).append(" ");
            }
            else {
                ans.append("null").append(" ");
            }
            if(top.right != null) {
                queue.add(top.right);
                ans.append(top.right.val).append(" ");

            }
            else {
                ans.append("null").append(" ");
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(" ");
        TreeNode root = null;
        if(data.length() == 0)
            return root;
        int idx = 0;
        root =  new TreeNode(Integer.parseInt(dataArr[idx++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.peek();
            queue.remove();
            if(!dataArr[idx].equals("null")) {
                top.left = new TreeNode(Integer.parseInt(dataArr[idx]));
                queue.add(top.left);
            }
            idx++;
            if(!dataArr[idx].equals("null")) {
                top.right = new TreeNode(Integer.parseInt(dataArr[idx]));
                queue.add(top.right);
            }
            idx++;
        }
        return root;
    }
}
