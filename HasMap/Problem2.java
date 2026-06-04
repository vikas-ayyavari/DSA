// 49. Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String,List<String>> map = new HashMap<>();
        for(String s : strs){
            map.computeIfAbsent(check(s),k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    String check(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
