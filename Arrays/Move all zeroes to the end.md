**Name of the Problem**

Move All Zeroes to End



**Concept**



Two Pointers Technique



In-place Array Manipulation



Stable Partitioning



**Approach to Solve the Problem**



The problem requires shifting all zeros to the end of the array while maintaining the relative order of non-zero elements. The operation must be done in-place, meaning we cannot use extra space.



The key observation is that instead of moving zeros to the end directly, it is easier to move all non-zero elements toward the beginning while maintaining their order. Once all non-zero elements are placed correctly, the remaining positions will naturally contain zeros.



We use the Two Pointers technique.



Maintain a pointer insertPos that represents the position where the next non-zero element should be placed.



**Steps**



Initialize insertPos = 0.



Traverse the array from left to right.



If the current element is not zero:



Swap it with the element at insertPos.



Increment insertPos.



Continue until the end of the array.



**Why this works**



Every non-zero element is placed at the earliest available correct position.



Order is preserved because we process elements from left to right.



Each element is visited only once.



**Time Complexity: O(n)**

**Space Complexity: O(1)**



**Solution (Java)**



public void moveZeroes(int\[] arr) {

&nbsp;   int insertPos = 0;



&nbsp;   for (int i = 0; i < arr.length; i++) {

&nbsp;       if (arr\[i] != 0) {

&nbsp;           int temp = arr\[i];

&nbsp;           arr\[i] = arr\[insertPos];

&nbsp;           arr\[insertPos] = temp;

&nbsp;           insertPos++;

&nbsp;       }

&nbsp;   }

}

