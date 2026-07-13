class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String digits = "123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(digits.substring(i, i + len));

                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }

        return res;
    }
}