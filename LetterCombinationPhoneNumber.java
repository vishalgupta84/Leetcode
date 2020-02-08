class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if(n == 0)
            return ans;
        ans.add("");
        List<List<String>> table = new ArrayList<List<String>>();
        table.add(new ArrayList<>());
        table.add(new ArrayList<>());
        int idx = 0;
        for (int i = 2; i < 10; i++) {
            int cnt = 3;
            if (i == 7 || i == 9)
                cnt = 4;
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                temp.add(Character.toString((char) ('a' + idx)));
                idx++;
            }
            table.add(temp);
        }
        for (int i = 0; i < n; i++) {
            int m = ans.size();
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < table.get(digits.charAt(i) - '0').size(); k++) {
                    temp.add(ans.get(j) + table.get(digits.charAt(i) - '0').get(k));
                }
            }
            ans = temp;
        }
        return ans;
    }
}