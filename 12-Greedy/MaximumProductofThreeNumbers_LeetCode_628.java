class Solution {
    public int maximumProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums)
        {
            if (num >= largest)
            {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            }
            else if (num >= secondLargest)
            {
                thirdLargest = secondLargest;
                secondLargest = num;
            }
            else if (num > thirdLargest)
            {
                thirdLargest = num;
            }

            if (num <= smallest)
            {
                secondSmallest = smallest;
                smallest = num;
            }
            else if (num < secondSmallest)
            {
                secondSmallest = num;
            }
        }

        int product1 = largest * secondLargest * thirdLargest;
        int product2 = largest * smallest * secondSmallest;

        return Math.max(product1, product2);
    }
}