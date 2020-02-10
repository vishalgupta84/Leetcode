public class MinimumWindowSubString {
    private boolean match(int[] table, int[] bTable) {
        for (int i = 0; i < 256; i++) {
            if(table[i] < bTable[i])
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE;
        int i = 0, j = t.length();
        int n = s.length();
        if(n == 0 || j == 0 || n < j)
            return "";
        int[] table = new int[256];
        int[] btable = new int[256];
        for (int k = 0; k < 256; k++) {
            table[k] = 0;
            btable[k] = 0;
        }
        for (int k = 0; k < j; k++) {
            table[s.charAt(k)]++;
            btable[t.charAt(k)]++;
        }
        while (j <= n) {
            while ((i < j) && match(table, btable)) {
                if (minLen > (j - i)) {
                    minLen = j - i;
                    start = i;
                }
                table[s.charAt(i)]--;
                i++;
            }
            if(j<n)
                table[s.charAt(j)]++;
            j++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLen);
    }
}
