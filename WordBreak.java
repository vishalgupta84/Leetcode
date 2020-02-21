import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int n = wordDict.size();
        boolean[] dp = new boolean[len+1];
        Arrays.fill(dp, false);
        for (int i = 1; i <= len; i++) {
                if(!dp[i] && wordDict.contains(s.substring(0,i)))
                    dp[i] = true;
                if(dp[i]) {
                    if(i == len)
                        return true;
                    for (int j = i+1; j <= len; j++) {
                        if(!dp[j] && wordDict.contains(s.substring(i, j)))
                            dp[j] = true;
                        if(j == len && dp[j])
                            return true;
                    }

                }
        }
        return false;
    }
}
