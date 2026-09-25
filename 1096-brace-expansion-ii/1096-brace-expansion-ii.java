class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = new HashSet<>();
        backtrack(expression, 0, "", set);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    private void backtrack(String s, int index,
                            String current,
                            Set<String> set) {
        if (index == s.length()) {
            set.add(current);
            return;
        }
        char ch = s.charAt(index);
        if (ch != '{') {
            backtrack(
                s,
                index + 1,
                current + ch,
                set
            );
            return;
        }
        int close = index;
        int count = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                count++;
            } 
            else if (s.charAt(i) == '}') {
                count--;
                if (count == 0) {
                    close = i;
                    break;
                }
            }
        }
        String inside = s.substring(index + 1, close);
        List<String> options = new ArrayList<>();
        int start = 0;
        count = 0;
        for (int i = 0; i < inside.length(); i++) {
            if (inside.charAt(i) == '{') {
                count++;
            } 
            else if (inside.charAt(i) == '}') {
                count--;
            } 
            else if (inside.charAt(i) == ',' && count == 0) {
                options.add(
                    inside.substring(start, i)
                );
                start = i + 1;
            }
        }
        options.add(
            inside.substring(start)
        );
        for (String option : options) {
            String remaining =
                option + s.substring(close + 1);
            backtrack(
                remaining,
                0,
                current,
                set
            );
        }
    }
}