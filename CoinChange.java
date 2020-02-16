import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount+1];
        Arrays.fill(table, amount+1);
        int n = coins.length;
        table[0] = 0;
        for(int i=1;i<=amount;i++) {
        	for(int j=0;j<n;j++) {
        		if(i>=coins[j]){
                    table[i] = Math.min(table[i], table[i-coins[j]]+1);
                }
        	}
        }
        if(table[amount] > amount)
            return -1;
        return table[amount];
    }
}