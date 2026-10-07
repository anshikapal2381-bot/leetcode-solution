class Solution {
    List<String> ans = new ArrayList<>();
    int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        backtrack(s, 0, "", 0);

        return ans;
    }

    void backtrack(String s, int index, String current, int balance) {

        if (balance < 0) {
            return;
        }
        if (index == s.length()) {
            if (balance == 0) {
                if (current.length() > maxLen) {
                    ans.clear();
                    maxLen = current.length();
                    ans.add(current);
                } 
                else if (current.length() == maxLen) {
                    if (!ans.contains(current)) {
                        ans.add(current);
                    }
                }
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            backtrack(s, index + 1, current + ch, balance + 1);
            backtrack(s, index + 1, current, balance);
        } 
        else if (ch == ')') {
            if (balance > 0) {
                backtrack(s, index + 1, current + ch, balance - 1);
            }
            backtrack(s, index + 1, current, balance);
        } 
        else {
            backtrack(s, index + 1, current + ch, balance);
        }
    }
}