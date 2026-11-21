import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];

            if (event < 0) {
                int u = ~event;
                int c = s.charAt(u) - 'a';
                last[c] = previous[u];
                continue;
            }

            int u = event;
            int c = s.charAt(u) - 'a';

            if (u != 0 && last[c] != -1) {
                newParent[u] = last[c];
            }

            previous[u] = last[c];
            last[c] = u;

            stack[top++] = ~u;

            for (int i = children[u].size() - 1; i >= 0; i--) {
                stack[top++] = children[u].get(i);
            }
        }

        ArrayList<Integer>[] newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] order = new int[n];
        int[] dfsStack = new int[n];
        int sp = 0, count = 0;

        dfsStack[sp++] = 0;

        while (sp > 0) {
            int u = dfsStack[--sp];
            order[count++] = u;

            for (int v : newChildren[u]) {
                dfsStack[sp++] = v;
            }
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            answer[newParent[u]] += answer[u];
        }

        return answer;
    }
}