import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    TrieNode root = new TrieNode();

    void insert(String word, int idx, String[] wordsContainer) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) 
        {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) 
            {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
            if (node.index == -1 || wordsContainer[idx].length() < wordsContainer[node.index].length()) 
            {
                node.index = idx;
            }
        }
    }

    int search(String word) {
        TrieNode node = root;
        int res = node.index;
        for (int i = word.length() - 1; i >= 0; i--) 
        {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null) 
            {
                break;
            }
            node = node.children[c];
            res = node.index;
        }
        return res;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        root.index = 0;
        for (int i = 1; i < n; i++) 
        {
            if (wordsContainer[i].length() < wordsContainer[root.index].length()) 
            {
                root.index = i;
            }
        }
        for (int i = 0; i < n; i++) 
        {
            insert(wordsContainer[i], i, wordsContainer);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) 
        {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
}