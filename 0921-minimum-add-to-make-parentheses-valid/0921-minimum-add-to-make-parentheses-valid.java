class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int add = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    add++;
                }
            }
        }

        return add + balance;
    }
}