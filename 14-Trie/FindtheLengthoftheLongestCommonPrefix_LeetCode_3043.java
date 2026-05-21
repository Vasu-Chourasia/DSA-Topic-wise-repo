class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    TrieNode root = new TrieNode();

    private void insert(int num) {
        TrieNode node = root;
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
    }

    private int findPrefixLength(int num) {
        TrieNode node = root;
        String s = String.valueOf(num);
        int len = 0;
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
            len++;
        }
        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int num : arr1) {
            insert(num);
        }
        int maxLen = 0;
        for (int num : arr2) {
            maxLen = Math.max(maxLen, findPrefixLength(num));
        }
        return maxLen;
    }
}