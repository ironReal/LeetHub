​
# 2. 문제 해석
정수 배열의 숫자가 **감소하지 않는 순서로 정렬**되어 있을 때, 각 고유 요소가 한 번만 나타나도록 중복된 요소를 제자리에서 제거합니다. 
요소의 상대적 순서는 동일하게 유지해야 합니다. 그런 다음 고유 요소의 수를 nums로 반환합니다.

숫자의 고유 요소 수를 k라고 가정하고 수락하려면 다음과 같은 작업을 수행해야 합니다:
* nums의 처음 k 요소에 처음에 nums에 있던 순서대로 고유 요소가 포함되도록 배열 nums를 변경합니다. nums의 나머지 요소는 nums의 크기만큼 중요하지 않습니다
* k를 반환합니다.

# 3. 접근 방법
중복되지 않는 코드로 나타나야하니깐 기존의 배열에서 중복되는 코드를 제거하기에는 배열에서 구현하기 힘들다고 생각했다. 그래서 한칸씩 건너뛰는 방식으로 접근하는게 어떨까 고민했다.
첫 번째 시도는 단순하게 첫번째 값과 그 다음 배열에 값을 비교하는 식으로 했지만 array bound exceeded를 당연하게 만나버렸다.
두 번째 시도는 중복되는 값을 따로 담아두는 compare이라는 변수를 만들어서 중복되는 값을 담고 비교하는 식으로 구현해보았지만 많은 if 분기문과 원하지 않는 답이 나와서 다른 생각을 해보았다.
세 번째 시도는 기존의 배열의 값을 그대로 두고 중복되지 않는 값이 나올 떄까지 배열을 순회하는 방식으로 접근해보았다.
# 4. 의사 코드
```java
반환할 k 값 선언;

for (다음 값과 비교하기 위해 1로 선언, 배열의 길이, 1++) {
		if (비교 배열과 그 다음 배열의 값이 같지 않다면) {
				기존 배열 그 다음 번호에 현재 위치의 배열의 값 저장;
				k 값 증가;
		}
}

k에 1를 더해서 반환
```
# 5. 문제 풀이

# 6. 개선 사항
기존의 배열을 새로 생성해서 접근해야한다는 생각에 깊게 빠져서 원하는 값이 나올때까지 많이 헤매였다. 접근 방식에 대한 여러가지 생각을 많이 해보았으면 좋겠다. 라이브러리를 사용하지 않고 순수한 배열 자체로만 구현하려니깐 힘든 점이 많았다. 논리적으로 더 접근하는 방법을 연습해야겠다.