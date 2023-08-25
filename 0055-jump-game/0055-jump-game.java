class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;

        // 배열의 끝에서 시작하여 배열의 첫번째 요소까지 반복
        for (int i = last - 1; i >= 0; i--) {
            // goal이 0에 도달할 수 있으면 0번째에서 마지막 인덱스까지 도달할 수 있는다 의미.
            if (nums[i] + i >= last) {
                last = i;
            }
        }

        return last == 0;
    }
}