import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class PathSumInBinaryTree {
    int ans = 0;
    private void pathSumUtil(TreeNode root, int sum) {
        if(root == null)
            return;
        if(root.val == sum) {
            ans++;
        }
        pathSumUtil(root.left, sum-root.val);
        pathSumUtil(root.right, sum-root.val);
        return;
    }
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode top = queue.peek();
            queue.remove();
            if(top.left != null)
                queue.add(top.left);
            if(top.right != null)
                queue.add(top.right);
            pathSumUtil(top, sum);
        }
        return ans;
    }
}
