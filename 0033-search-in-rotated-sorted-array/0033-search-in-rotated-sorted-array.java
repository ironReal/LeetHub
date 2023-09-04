class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 절반으로 나누었을 때 찾고자 하는 값이라면
            if (nums[mid] == target) {
                return mid;

            // 왼쪽 절반에 있는지 확인
            } else if (nums[mid] >= nums[left]) {
                // 피벗이 왼쪽 절반에 있다면
                if (target >= nums[left] && target < nums[mid]) {
                    // 왼쪽 절반으로 이분
                    right = mid - 1;
                } else {
                    // 오른쪽 절반으로 이분
                    left = mid + 1;
                }
            // 오른쪽 절반에 있는지 확인
            } else if (nums[mid] <= nums[right]) {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        // 값을 찾지 못했다면
        return -1;
    }
}