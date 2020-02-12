import java.util.ArrayList;
import java.util.List;

class FindAllAnagramInString {
    public boolean match(int[] pattern, int[] temp) {
        for(int i=0;i<26;i++)
            if(pattern[i] != temp[i])
                return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pattern = new int[26];
        int[] temp = new int[26];
        for(int i=0;i<26;i++){
            temp[i] = pattern[i] = 0;
        }
        int m = p.length();
        int n = s.length();
        if(n<m)
            return ans;
        for(int i=0;i<m;i++){
            pattern[p.charAt(i)-'a']++;
            temp[s.charAt(i)-'a']++;
        }
        for(int i=0;i<=n-m;i++){
            if(match(pattern,temp))
                ans.add(i);
            temp[s.charAt(i)-'a']--;
            if(i+m < n)
                temp[s.charAt(i+m)-'a']++;
        }
        return ans;
    }
}