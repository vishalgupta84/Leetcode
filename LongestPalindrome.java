public class LongestPalindrome {
	public String longestPalindrome(String s) {
		String ans = "";
		int start = -1, mxLen = 0;
		int n = s.length();
		if (n == 0)
			return ans;
		Boolean[][] table = new Boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
			start = i;
			mxLen = 1;
		}
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				mxLen = 2;
				start = i;
			}
		}
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i <= n - k; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
					if (k > mxLen) {
						start = i;
						mxLen = k;
					}
				}
			}
		}
		return s.substring(start, start + mxLen);
	}
}