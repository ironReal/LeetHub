class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            temp[i] = nums[j++];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}