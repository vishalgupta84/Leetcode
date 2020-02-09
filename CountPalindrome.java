public class CountPalindrome {
	public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        Boolean[][] table = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1]  = true;
            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(table[i][j])
                    cnt++;
            }
        }
        return cnt; 
    }	
}