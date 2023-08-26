class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        char[] c = lower.toCharArray();

        for (int i = 0; i < c.length; i++) {
            int right = c.length - i - 1;

            if (c[i] != c[right]) {
                return false;
            }
        }

        return true;
    }
}