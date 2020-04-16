public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int open = 0, close = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '*' || s.charAt(i) == '(')
                open++;
            else
                open--;
            if(s.charAt(n-1-i) == '*' || s.charAt(n-1-i)==')')
                close++;
            else
                close--;
            if(open < 0 || close < 0)
                return false;
        }
        return true;
    }
}
