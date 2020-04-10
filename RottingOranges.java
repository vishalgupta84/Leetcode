import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int minutes = 0;
        boolean  flag = false;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
                if(grid[i][j] == 1)
                    flag = true;
            }
        }
        if(queue.isEmpty() && !flag)
            return 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz > 0) {
                Pair p = queue.peek();
                queue.remove();
                int x = (int) p.getKey();
                int y = (int) p.getValue();
                if (x > 0 && grid[x - 1][y] == 1 && !visited[x-1][y]){
                    queue.add(new Pair(x - 1, y));
                    grid[x-1][y] = 2;
                }
                if (x < n - 1 && grid[x + 1][y] == 1 && !visited[x+1][y]){
                    queue.add(new Pair(x + 1, y));
                    grid[x+1][y] = 2;
                }
                if (y > 0 && grid[x][y - 1] == 1 && !visited[x][y-1]){
                    queue.add(new Pair(x, y - 1));
                    grid[x][y-1] = 2;
                }
                if (y < m - 1 && grid[x][y + 1] == 1 && !visited[x][y+1]){
                    queue.add(new Pair(x, y + 1));
                    grid[x][y+1] = 2;
                }
                sz--;
            }
            minutes++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return minutes - 1;
    }
}
