class Solution {
    public int maxProduct(int n) {
        int largest = -1;
        int secondLargest = -1;
        while (n > 0) {
            int currentDigit = n % 10;
            if (currentDigit >= largest) {
                secondLargest = largest;
                largest = currentDigit;
            }
            else if (currentDigit > secondLargest) {
                secondLargest = currentDigit;
            }
            n /= 10;
        }
        return largest * secondLargest;
    }
}