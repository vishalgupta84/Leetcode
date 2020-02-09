import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearchIn2dGrid {
    boolean[][] visited;

    private boolean searchUtil(char[][] board, String word, int x, int y, int idx, int n, int m) {
        if (visited[x][y] || word.charAt(idx) != board[x][y])
            return false;
        visited[x][y] = true;
        if (idx == word.length() - 1)
            return true;
        if (x > 0) {
            if (!visited[x - 1][y] && searchUtil(board, word, x - 1, y, idx + 1, n, m)) {
                return true;
            }
        }
        if (y > 0) {
            if (!visited[x][y - 1] && searchUtil(board, word, x, y - 1, idx + 1, n, m)) {
                return true;
            }
        }
        if (x < n - 1) {
            if (!visited[x + 1][y] && searchUtil(board, word, x + 1, y, idx + 1, n, m)) {
                return true;
            }
        }
        if (y < m - 1) {
            if (!visited[x][y + 1] && searchUtil(board, word, x, y + 1, idx + 1, n, m)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n == 0)
            return false;
        int m = board[0].length;
        if (word.isEmpty()) {
            return true;
        }
        visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if((board[row][col] == word.charAt(0)) && searchUtil(board, word, row,col, 0 , n,m))
                    return true;
            }
        }
        return false;
    }
}
