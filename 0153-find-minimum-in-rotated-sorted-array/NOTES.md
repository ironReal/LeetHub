# 2. 문제 해석
오름차순으로 정렬된 길이 n의 배열이 1에서 n회 사이로 회전한다고 가정합니다. 예를 들어 `nums = [0,1,2,4,5,6,7]` 배열이 될 수 있습니다:

- 4회 회전한 경우 `[4,5,6,7,0,1,2]`가 될 수 있습니다.
- 7번 회전했다면 `[0,1,2,4,5,6,7]`이 됩니다.
배열 `[a[0], a[1], a[2], ..., a[n-1]]`을 배열을 한 번 회전하면 `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]` 배열이 됩니다.

정렬된 회전 배열의 고유 원소의 개수가 주어지면, 이 배열의 최소 원소를 반환합니다.

`O(log n) 시간` 안에 실행되는 알고리즘을 작성해야 합니다.

 
## 2.1 Example
**Example 1:**

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

**Example 2:**

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

**Example 3:**

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

# 3. 접근 방법
회전되어 정렬된 배열에서 최소 요소를 찾는 것을 목표로 한다. 이진 검색 알고리즘을 활용하여 검색 공간을 효율적으로 좁히고 최소 요소를 찾는다.

1. 배열의 시작 및 끝 인덱스를 나타내는 두 개의 포인터 left 및 right를 초기화 한다.
2. left가 right보다 작을 때 까지 while을 반복한다.
3. mid를 선언하고 중간점을 계산한다.
4. 인게스의 값 mid와 인덱스의 값 right을 비교하여 배열의 어느 부분에 최소 요소가 포함되어 있는지 확인한다.
5. `nums[mid] > nums[right]` 이면 최소 요소가 배열의 오른쪽 절반에 있음을 의미한다.
6. `left = mid + 1`로 오른쪽에서 찾을 수 있게 값을 변경한다.
7. 그렇지 않으면 최소 요소는 인덱스를 포함하여 배열의 왼쪽 절반에 놓여진다. 
8. `right = mid`로 왼쪽에서 찾을 수 있게 값을 변경한다.

# 4. 의사 코드
```
배열의 첫번째에서 시작할 left 초기화;
배열의 마지막에서 시작할 right 초기화;

while (left와 right가 만나거나 커질때까지) {
		중간값 선언;
		
		if (중간 요소보다 오른쪽 요소가 크다면) {
				right = 중간값;
		} else {
				left = mid + 1;
		}
}

배열의 left 인덱스 요소값 반환;
```

# 4. 문제 풀이
```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[right] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
```​
