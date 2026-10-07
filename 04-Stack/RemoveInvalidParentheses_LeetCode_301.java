class Solution {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        backtrack(s, 0, left, right, 0, new StringBuilder());
        return res;
    }
    void backtrack(String s, int index, int leftRemove, int rightRemove,
                   int balance, StringBuilder path) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                String str = path.toString();
                if (!res.contains(str)) {
                    res.add(str);
                }
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(' && leftRemove > 0) {
            backtrack(s, index + 1, leftRemove - 1, rightRemove, balance, path);
        }
        if (ch == ')' && rightRemove > 0) {
            backtrack(s, index + 1, leftRemove, rightRemove - 1, balance, path);
        }
        path.append(ch);
        if (ch != '(' && ch != ')' ) {
            backtrack(s, index + 1, leftRemove, rightRemove, balance, path);
        } else if (ch == '(') {
            backtrack(s, index + 1, leftRemove, rightRemove, balance + 1, path);
        } else if (balance > 0) {
            backtrack(s, index + 1, leftRemove, rightRemove, balance - 1, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}