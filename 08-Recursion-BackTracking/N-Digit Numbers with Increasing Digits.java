class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }

        if (n > 10) return ans;

        generate(1, n, 0, ans);

        return ans;
    }

    private static void generate(int start, int n, int num, ArrayList<Integer> ans) {
        if (n == 0) {
            ans.add(num);
            return;
        }

        for (int digit = start; digit <= 9; digit++) {
            generate(digit + 1, n - 1, num * 10 + digit, ans);
        }
    }
}