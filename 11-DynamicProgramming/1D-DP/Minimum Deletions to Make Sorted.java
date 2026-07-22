class Solution {
    public int minDeletions(int[] arr) {
        int arrayLength = arr.length;
        int[] lisArray = new int[arrayLength];
        int lisLength = 0;

        for (int currentValue : arr) {
            int leftIndex = 0;
            int rightIndex = lisLength;

            while (leftIndex < rightIndex) {
                int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

                if (lisArray[middleIndex] < currentValue) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex;
                }
            }

            lisArray[leftIndex] = currentValue;

            if (leftIndex == lisLength) {
                lisLength++;
            }
        }

        return arrayLength - lisLength;
    }
}