class Solution {
    public void sortIt(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp, (a, b) -> {
            if (a % 2 != b % 2) {
                return a % 2 == 1 ? -1 : 1;
            }
            if (a % 2 == 1) {
                return b - a;
            }
            return a - b;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}