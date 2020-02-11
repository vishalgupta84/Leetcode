public class UniqueBinaryTree {
    private int calculateBinomial(int n, int k) {
        if (n - k < k)
            k = n - k;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public int numTrees(int n) {
        long m = n + 1;
        long c = calculateBinomial(2 * n, n);
        return (int)(c / m);
    }
}
