class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int score = Math.max(2 * x, 1);

                int parent = stack.pop();
                stack.push(parent + score);
            }
        }

        return stack.pop();
    }
}