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
        int len = word.length();
        List<List<Pair<Integer, Integer>>> table = new ArrayList<>();
        for (int i = 0; i < 256; i++)
            table.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table.get(board[i][j]).add(new Pair<>(i, j));
            }
        }
        visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                visited[row][col] = false;
            }
        }
        for (int i = 0; i < table.get(word.charAt(0)).size(); i++) {
            if (searchUtil(board, word, table.get(word.charAt(0)).get(i).getKey(), table.get(word.charAt(0)).get(i).getValue(), 0, n, m))
                return true;
        }
        return false;
    }
}
