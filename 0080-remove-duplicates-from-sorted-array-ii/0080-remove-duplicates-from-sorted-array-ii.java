class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        int fix = 0;    // 고정 값
        int slide = 0;  // 이동 값

        // 배열의 길이만큼 반복
        while (slide < nums.length) {
            // 중복이 되지 않는 값이라면 고정 값을 이동 값으로 변경
            if(nums[fix] != nums[slide]) {
                fix = slide;
            }
            // 중복 되는 값이 3개 이상이거나 서로 중복되는 값인지 비교
            if (slide - fix <= 1 && nums[fix] == nums[slide]) {
                nums[current++] = nums[slide];
            }
            
            slide++;
        }
        return current;
    }
}