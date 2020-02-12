import java.util.ArrayList;
import java.util.List;

class GenerateAllParenthesis {
    private List<String> ans = new ArrayList<String>();
    void printAll(int n, int pos, int close, int open, StringBuilder temp) {
        if(close == n) {
            ans.add(temp.toString());
            return;
        }
        if(open > close) {
            temp.setCharAt(pos, ')');
            printAll(n , pos+1, close+1, open, temp);
        }
        if(open < n) {
            temp.setCharAt(pos, '(');
            printAll(n , pos+1, close, open + 1, temp);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder str
                = new StringBuilder("");
        for(int i=0;i<n;i++){
            str.append("(");
            str.append(")");
        }
        if(n>0)
            printAll(n,0,0,0, str);
        return ans;
    }
}
