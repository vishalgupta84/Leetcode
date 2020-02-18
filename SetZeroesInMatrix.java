import java.util.Random;

public class SetZeroesInMatrix {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return;
        int m = matrix[0].length;
        Random rand = new Random();
        int randomNumber = rand.nextInt(Integer.MAX_VALUE);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == 0) {
                    for(int col=0;col<m;col++) {
                        if (matrix[i][col] != 0)
                            matrix[i][col] = randomNumber;
                    }
                    for(int row = 0;row<n;row++) {
                        if(matrix[row][j] != 0)
                            matrix[row][j] = randomNumber;
                    }
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == randomNumber)
                    matrix[i][j] = 0;
            }
        }
    }
}
