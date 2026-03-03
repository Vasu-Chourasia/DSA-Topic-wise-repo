/*
Name of the Problem
Trapping Rain Water

Concept

Two Pointers Technique

Prefix Maximum / Suffix Maximum

Greedy Height Comparison

Approach to Solve the Problem

We are given heights of blocks. Water trapped at index i depends on:

min(max height on left, max height on right) − height[i]

Brute force would calculate left and right maximum for every index, resulting in O(n²).

Optimal Two Pointer Approach:

Maintain:

left pointer at start

right pointer at end

leftMax = maximum height seen so far from left

rightMax = maximum height seen so far from right

Steps:

While left ≤ right:

If height[left] ≤ height[right]:

If height[left] ≥ leftMax → update leftMax

Else → water += leftMax − height[left]

Move left++

Else:

If height[right] ≥ rightMax → update rightMax

Else → water += rightMax − height[right]

Move right--

Why this works:

Water trapped depends on the smaller boundary.
If left height is smaller, trapped water depends only on leftMax.
If right height is smaller, trapped water depends only on rightMax.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.*;
public class TrappingRainWater {
    public static int trap(int[] arr) {
        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    water += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    water += rightMax - arr[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Water Trapped: " + trap(arr));
    }
}