class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;

        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false;
            }
        }

        if (k == 0) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                boolean leftEmpty = (i == 0) || (seats[i - 1] == 0);
                boolean rightEmpty = (i == n - 1) || (seats[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    seats[i] = 1;
                    k--;

                    if (k == 0) {
                        return true;
                    }
                }
            }
        }

        return k == 0;
    }
}