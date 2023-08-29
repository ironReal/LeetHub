# 2. 문제 해석
고유 정수의 정렬된 배열과 목표 값이 주어졌을 때, 목표가 발견되면 인덱스를 반환합니다. 그렇지 않은 경우, 순서대로 삽입했을 때 인덱스가 있을 위치를 반환합니다.

런타임 복잡도가 `O(log n)`인 알고리즘을 작성해야 합니다.
## 2.1 Example
**Example 1:**
Input: nums = [1,3,5,6], target = 5
Output: 2

**Example 2:**
Input: nums = [1,3,5,6], target = 2
Output: 1

**Example 3:**

Input: nums = [1,3,5,6], target = 7
Output: 4

# 3. 접근 방법
- O(log n)의 실행속도를 반환해야하니깐 for문 사용하면 안될 것이고
- 배열의 숫자가 오름차순으로 정렬되어 있으니깐 이진 검색으로 접근 할 수 있다.

- 배열의 0번째 인덱스부터 시작하면 left 변수와 배열의 마지막 인덱스에서부터 시작하는 right를 변수를 둔다.
- left와 right를 더한 값의 절반인 mid 변수를 둬서
- 배열에 mid 인덱스에 있는 값이 target 보다 작다면
- ex) target = 5; nums[mid] = 3;
- left 값을 mid 값보다 크게 설정한다.

- 반복문을 돌고나서 target과 일치하는 값을 찾지 못했다면
- left의 값, 오름차순으로 target 값이 들어갈 수 있는 인덱스 번호를 반환한다.

# 4. 의사 코드
```
배열에 왼쪽에서 시작할 인덱스;
배열에 오른쪽에서 시작할 인덱스;

while (왼쪽이 오른쪽 인덱스 번호와 같거나 클때까지) {
		중간 값 선언 = 왼쪽 인덱스 + 오른쪽 인덱스 / 2;
		
		if (배열[중간값]이 target과 일치하면) {
				중간값 반환;
		} else if(배열[중간값)이 타겟보다 작다면) {
				왼쪽 인덱스 = 중간값 + 1;
		} else {
				오른쪽 인덱스 = 중간값 - 1;
		}
}

왼쪽 인덱스 반환;
```

# 5. 문제 풀이
<img width="650" alt="image" src="https://github.com/ironReal/LeetHub/assets/46087207/96a3588c-5572-4e6b-b40b-df690050c906">

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;
    }
}
```
