import java.util.Arrays;

public class LastStoneWeight {
    int lastStoneWeight(int[] stones) {
        int n = stones.length;
        while(n>1) {
            Arrays.sort(stones);
            int x = stones[n-2];
            int y = stones[n-1];
            stones[n-2] = y-x;
            n--;
        }
        if(n > 0)
            return stones[0];
        return 0;
    }
}
