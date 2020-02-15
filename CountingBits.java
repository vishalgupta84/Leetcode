public class CountingBits {
    static int[] numBits = new int[] { 0, 1, 1, 2, 1, 2, 2,
            3, 1, 2, 2, 3, 2, 3, 3, 4 };
    private int countBitsUtil(int num) {
        if(num == 0)
            return numBits[0];
        return numBits[num & 15] + countBitsUtil(num >> 4);
    }
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i=0;i<=num;i++){
            ans[i] = countBitsUtil(i);
        }
        return ans;
    }
}
