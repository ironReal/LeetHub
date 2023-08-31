# 2. 문제 해석
정수 `숫자 배열`과 정수 `타깃`이 주어졌을 때, 두 숫자의 인덱스가 `타깃`에 합산되도록 반환합니다.

각 입력에 정확히 **하나의 해**가 있다고 가정할 수 있으며, 같은 요소를 두 번 사용할 수 없습니다.

어떤 순서로든 답을 반환할 수 있습니다.

Follwo-up : 시간 복잡도가 O(n2) 미만인 알고리즘을 생각해낼 수 있나요?

# 3. 접근 방법
Hash Table을 이용해서 풀어야하는 문제인데 Hash table에 대해 알고 있지 않아서 새롭게 공부해 보았다.
Map에 Key, value를 통해 데이터는 고유한 인덱스 번호를 가지고 있고 그 인덱스 번호를 통해 빠르게 검색과 조회가 가능한 자료구조이다.

이중 for 문을 이용해서 풀 수는 있지만 시간 복잡도가 O(n2) 미만인 알고리즘을 생각해야하므로 hash table을 이용한 방법을 생각해보았다.
key와 value에 Integer 타입을 담는 Map을 하나 선안한다. Map에 Key는 인자로 넘어오는 배열에 요소를, Value에는 배열의 index 값을 담을 수 있게 준비한다.

a - b = target은 b = target - a와 같은 의미이다. map에  target - a와 같은 Key가 존재한다면 key가 가지고 있는 value와 현재 배열의 인덱스 번호를 반환하면 될 것이다

# 4. 의사 코드
```
Map<Intger, Intger> map 생성;

for ( 0, 배열의 크기; 1씩 증가) {
		if (target - 현재 배열의 값에 해당하는 Key 값이 있다면) {
				return {target - 배열의 값, 현재 i 값};
		}
		map.put(배열의 값, 배열의 인덱스);
}
```

# 5. 문제 풀이
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
```
<img width="740" alt="image" src="https://github.com/ironReal/LeetHub/assets/46087207/d4ca22f2-c2f6-4282-bdd3-b6dcd896e21c">


# 6. 개선 사항
Hash Table을 이용한 알고리즘은 처음 풀어보아서 그런지 어떻게 접근해야할지 고민이 많았다.
단순하게 생각하면 2중 for문을 이용하면 되겠지만 시간 복잡도 측면에서 좋지 않은 방법인걸 알고 있다. 단순하게 생각한 방법을 이용해서 이런 정답까지 이끌어낸게 신기하게 느껴졌다.
Hash Table을 이용한 문제들을 더 많이 풀어봐서 확실하게 감을 잡고 가야겠다.
