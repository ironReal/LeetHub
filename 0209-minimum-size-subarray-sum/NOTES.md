# 2.문제 해석
양의 `정수 숫자`와 양의 정수 목표의 `배열`이 주어지면, a의 **최소 길이**를 반환한다.
subarray 총합이 목표보다 크거나 같다. 이러한 하위 배열이 없으면 대신 `0`을 반환합니다
> subarray는 배열 내의 요소들의 연속적인 비어있지 않은 시퀀스이다.

# 2.1 Example
입력: target = 7, nums = [2,3,1,2,4,3]
출력: 2
설명: 하위 배열 [4,3]은 문제 제약 조건에서 최소 길이를 가집니다.

# 3. 접근 방법
<img width="786" alt="image" src="https://github.com/ironReal/LeetHub/assets/46087207/be5a44c6-6ccc-4cf6-b9bf-859939600875">

# 4. 의사 코드
```
슬라이딩 윈도우를 이용할 시작, 끝 변수;
시작과 끝 사이에 있는 변수 값들을 저장할 합계 변수;
최소값을 저장하는 변수;

while (끝 변수가 배열 끝에 도달할때까지) {
		합계 변수에 끝 변수 포인트에 있는 배열 값 저장;
		
		while (합계 변수가 타겟 번호보다 작거나 같을 떄까지 반복) {
					최소값 비교 = 최소값, 끝 변수 - 시작 변수 (인덱스 길이);
					합계 변수에 시작 변수 포인터에 위치한 값을 빼고 시작 변수를 한칸 이동
		}
}

최소값 반환;
```
# 5. 문제 해결
처음에는 왼쪽과 오른쪽 포인터가 모두 0에 있다.
타겟이 일치하면,
지금까지의 크기가 최소 크기인지 확인한다, 합계에서 왼쪽 요소를 제거한다.
왼쪽에서 창 크기를 줄입니다(그래서 왼쪽++),

실행하여 목표 합계에 더 작은 창을 가질 수 있는지 확인합니다.
목표가 계속 일치하는 한 계속 줄일 수 있도록 while 루프가 되어야 합니다.
목표에 도달하지 못할 때마다 오른쪽 포인터를 움직여 창 크기를 늘립니다. 오른쪽 포인터가 숫자의 길이보다 커지면 중지합니다.

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

# 개선 사항
슬라이딩 윈도우를 이용한 여러가지 방법들이 있지만 한가지 방법으로만 생각하다보니깐 어떤 식으로 접근해야할지 감이 잡히지 않았다. 30분 동안 고민을 해도 어떻게 활용해야할지 몰라서 Solutions를 참고하였다.
처음에 코드를 보았을 때 이해가 가지 않았지만 step 마다 따라가면서 도식화 해보니 감이 잡혔다.
이해가 되지 않는다면 직접 손으로 그려보는 습관을 들여야겠다.