public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                dp[i][j] = 0;
            }
        }
        int mxLen = 0;
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    mxLen = Math.max(mxLen, dp[i][j]);
                }
            }
        }
        return mxLen*mxLen;
    }
}
