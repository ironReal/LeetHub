// 내림차순으로 정렬된 두 개의 정수 배열 nums1과 nums2가 주어지며, 각각 nums1과 nums2에 있는 요소의 수를 나타내는 두 개의 정수 m과 n이 주어집니다.

// nums1과 nums2를 감소하지 않는 순서로 정렬된 단일 배열로 병합합니다.

// 최종 정렬된 배열은 함수에 의해 반환되지 않고 nums1 배열 안에 저장되어야 합니다. 이를 위해 nums1의 길이는 m + n이며, 첫 번째 m 요소는 병합해야 하는 요소를 나타내고 마지막 n 요소는 0으로 설정되어 무시해야 합니다. nums2의 길이는 n입니다.
import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}