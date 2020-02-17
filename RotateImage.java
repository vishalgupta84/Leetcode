public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return;
        int up = 0, left = 0, right = n-1, down = n - 1;
        while(up <= down && left <= right) {
            for(int i = 0; i<right-left;i++) {
                int temp = matrix[up + i][right];
                matrix[up + i][right] = matrix[up][left + i];
                matrix[up][left + i] = matrix[down-i][left];
                matrix[down-i][left]=matrix[down][right-i];
                matrix[down][right-i]=temp;
            }
            up++;
            down--;
            left++;
            right--;
        }
        return;
    }
}
