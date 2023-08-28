class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;
        Set<Character> charSet = new HashSet<>();

        while (end < s.length()) {
            char sToChar = s.charAt(end);
            if (!charSet.contains(sToChar)) {
                charSet.add(sToChar);
                end++;
                length = Math.max(length, charSet.size());
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return length;
    }
}