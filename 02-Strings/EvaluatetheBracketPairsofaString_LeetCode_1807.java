class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> k : knowledge)
            map.put(k.get(0), k.get(1));

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i);
                String key = s.substring(i + 1, j);
                result.append(map.getOrDefault(key, "?"));
                i = j;
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}