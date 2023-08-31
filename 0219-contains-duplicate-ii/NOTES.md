# 2. 문제 해석
정수 배열 `nums`와 정수 `k`가 주어졌을 때, 배열에 두 개의 ***서로 다른 인덱스*** `i`와 `j`가 있어 `nums[i] == nums[j]`, `abs(i - j) <= k`이면 `true`를 반환합니다.
## 2.1 Example

**Example 1:**

Input: nums = [1,2,3,1], k = 3
Output: true

**Example 2:**

Input: nums = [1,0,1,1], k = 1
Output: true

**Example 3:**

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

# 3. 접근 방법
문제 자체가 이해가 되지 않아서 번역기를 여기저기 돌려본 결과 약간은 이해가 되긴했지만 어떻게 풀어야 할지 감이 잡히지 않았다. 일단 `nums[i] == nums[j]` 의미는 배열의 이전의 값과 현재 배열의 값이 같다는 의미이다. 그렇기에 이전값과 현재 값을 비교할 수 있는 방법이 필요하다.
그리고 abs(i - j) <= k 는 (이전값 - 현재값) <= k 의미이니깐 조건에 맞다면 true를 반환한다.

Hash Table을 이용해서 key는 배열의 요소, value는 배열의 인덱스 번호로 저장한다.
배열의 길이만큼 순회하면서  위에 방법대로 조건문을 완성하자.

# 4. 의사 코드
```
HashMap 선언;

for (0부터, 배열의 길이동안, 1씩 증가) {
		이전값 = map에 저장 (현재 배열의 요소값, 인덱스);
		if (이전값이 있고 이전값 - 현재값 보다 K가 크거나 같다면) {
				참 반환;
		}
}

거짓 반환;
```

# 4. 문제 풀이
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer prev = map.put(nums[i], i);

            if (prev != null && i - prev <= k) {
                return true;
            }
        }

        return false;
    }
}
```

- Map.put에 대한 매핑이 없는 경우 null을 반환한다. 
- 이전 값이 있고 현재 인덱스 - 이전 value이 <= k라면 true를 반환한다.​
