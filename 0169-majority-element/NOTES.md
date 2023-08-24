# 2. 문제 해석
크기가 n인 배열 번호가 지정되면 대다수 요소를 반환합니다.

대다수 원소는 ⌊n / 2⌋ 이상 나타나는 원소이다. 대다수 요소가 항상 배열에 존재한다고 가정할 수 있습니다.

# 3. 접근 방법
메이저한 원소를 찾아야 한다. 여기서 메이저한 원소는 배열의 절반 이상 존재하는 수이다. 어떻게 접근해야 할지 몰라서 여러 알고리즘을 찾아보다가 *과분수 득표 알고리즘(Boyer–Moore majority vote algorithm)* 이라는 걸 알게 되었고 이 알고리즘을 통해서 문제를 접근해 보았다.
# 4. 의사 코드
```
메이저 변수 = 0;
카운트 변수 = 0;

for each(순회 할 배열) {
		if (카운트가 0이라면) {
				메이저 변수 = 현재 배열의 인수
				카운트 = 1;
		} elsf if(카운트 인수 값과 현재 배열의 인수가 같다면) {
				카운트 1 증가
		} else {
				카운트 1 감소
		}
		
		메이저 변수 반환;
}
```
# 5. 문제 풀이
```java
class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count = 1;
            } else if (majority == num) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return majority;
    }
}
```

카운트가 줄었다고 해서 메이저 인수가 n/2회 이상 발생한다는 사실은 바뀌지 않는다.
카운트가 0이 되면 현재 메이저 인수가 더 이상 잠재적 메이저 인수가 아님을 의미한다. 이 경우, 나머지 인수에서 새로운 후보가 선택된다.
전체 배열을 지날 때까지 반복문을 계속 진행한다.

# 6. 개선 사항
HashMap을 이용해서 푸는 방법도 있다는 걸 알게 되었고 한가지 알고리즘에 의존하지 말고 여러가지 해법을 통해서 문제를 해결해 나가야겠다.
```java
public static int solution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        n = n / 2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }
```
`default V getOrDefault(Object key, V defaultValue)` : 지정된 키가 매핑된 값을 반환하거나 이 맵에 키에 대한 매핑이 없는 경우 defaultValue를 반환한다.
nums[i]가 처음으로 발견되면 카운트가 1인 해시 맵에 추가된다.
nums[i]가 이전에 발견된 적이 있는 경우 해시 맵의 카운트가 1씩 증가한다.

각 키-값 쌍(x.first, x.second)에 대해 카운트(x.second) n 보다 큰지 확인한다. 카운트가 n 보다 크면 x.first를 메이저인수로 반환한다.
해시 맵에서 메이저 인수를 찾지 못하면 코드는 0을 기본값으로 반환한다.
