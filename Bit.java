import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bit {
    public int solve(int[] A, int[][]B, int C, int D) {
        int n = A.length;
        int weight = 0;
        int[][] list = new int[n+1][n+1];
        Arrays.fill(list, -1);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int m = B.length;
        for(int i=0;i<m;i++) {
            list[B[i][0]][B[i][1]] = B[i][2];
        }
        queue.add(1);
        boolean flag = false;
        visited[1] = true;
        while(!queue.isEmpty()) {
            int top = queue.peek();
            queue.remove();
            for(int i=0;i<n;i++) {
                if(list[top][i] != -1) {
                    if(i==n){
                        flag = true;
                        break;
                    }
                    else {
                        queue.add(i);
                    }
                }
            }
            if(flag)
                break;
        }
        if(!flag)
            return -1;
        return weight;
    }
}
