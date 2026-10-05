class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 2; i <= arr.length + 1; i++) {
            int[] distance = new int[i];
            int current = i;
            int steps = 1;

            while (current != 1) {
                current = arr[current - 2];
                distance[current] = steps++;
            }

            for (int j = 1; j < i; j++) {
                if (distance[j] != 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(distance[j]);
                    result.add(temp);
                }
            }
        }

        return result;
    }
}