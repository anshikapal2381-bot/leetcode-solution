
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If next character is also ')',
                // use both closing brackets together
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }

                if (open > 0) {
                    open--;
                } else {
                    count++;
                }
            }
        }

        count += open * 2;
        return count;
    }
}