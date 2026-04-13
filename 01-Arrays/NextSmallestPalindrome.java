class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        // Step 1: Check if all digits are 9
        boolean all9 = true;
        for (int d : num) {
            if (d != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res; // e.g., 999 -> 1001
        }

        int[] result = num.clone();
        int i = 0, j = n - 1;
        while (i < j) {
            result[j] = result[i];
            i++;
            j--;
        }

        // Step 3: Check if mirrored result > original
        boolean isGreater = false;
        for (int k = 0; k < n; k++) {
            if (result[k] > num[k]) {
                isGreater = true;
                break;
            } else if (result[k] < num[k]) {
                break;
            }
        }

        if (isGreater) return result;

        // Step 4: Increment middle and handle carry
        int carry = 1;
        int mid = n / 2;

        // For odd length, increment middle digit first
        if (n % 2 == 1) {
            result[mid] += carry;
            carry = result[mid] / 10;
            result[mid] %= 10;
            i = mid - 1;
            j = mid + 1;
        } else {
            i = mid - 1;
            j = mid;
        }

        // Propagate carry and mirror
        while (i >= 0) {
            result[i] += carry;
            carry = result[i] / 10;
            result[i] %= 10;

            result[j] = result[i]; // mirror
            i--;
            j++;
        }

        return result;
    }
}