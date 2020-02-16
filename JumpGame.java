import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
		if(n == 0)
			return true;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
        	int idx = queue.peek();
        	queue.remove();
        	if(idx == n-1)
        		return true;
        	for(int i=1;i<=nums[idx];i++) {
        		if(idx + i == n-1)
        			return true;
        		if(!visited[idx+i]) {
        			queue.add(idx + i);
        		}
        		visited[idx + i] = true;
        	}
        }
        return false;
    }
}