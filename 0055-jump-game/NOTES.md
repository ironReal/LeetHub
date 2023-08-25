# 2. 문제 해석
정수 배열의 개수가 주어집니다. 처음에는 배열의 **첫 번째 인덱스**에 위치하게 되며, 배열의 각 요소는 해당 위치에서 최대 점프 길이를 나타냅니다.
​
마지막 인덱스에 도달할 수 있으면 *true*을 반환하고, 그렇지 않으면 *false*을 반환합니다.
## 2.1 Example
입력: nums = [2,3,1,1,4]
출력: true
설명: 인덱스 0에서 1로 1단계 이동한 다음 마지막 인덱스로 3단계 이동합니다.
​
입력: nums = [3,2,1,0,4]
출력: false
설명: 무슨 일이 있어도 항상 인덱스 3에 도착합니다. 최대 점프 길이는 0이므로 마지막 인덱스에 도달할 수 없습니다.
# 3. 접근 방법
배열의 길이 - 1 == 점프 횟수 합산 값 -> 같은 걸 발견하였다. 합산 값을 이용해서 배열의 인덱스 번호를 증가 시키고 결과값을 반환하는 방식으로 접근해보았지만 0 인수를 만나버리면 반복문이 끝나지 않는 문제를 발견해서 실패하였다.
​
거꾸로 생각해서 마지막부터 시작할 수 있다고 생각해보았다. 배열 끝에서 시작하여 배열의 첫번째 요소까지 반복한다. 배열의 첫번째 요소가에 도달했다면 true를 반환한다.
# 4. 의사 코드
```java
int 마지막 인덱스 = 배열 크기 - 1;
​
for (마지막 인덱스에서 두번째 번호에서 부터 시작, 0에 도달, 1씩 감소) {
if (현재 배열 값 + i >= 마지막 인덱스) {
마지막 인덱스 = i;
}
마지막 인덱스가 0이라면 true 반환
```
# 5. 문제 풀이
class Solution {
public boolean canJump(int[] nums) {
int last = nums.length - 1;
for (int i = last - 1; i >= 0; i--) {
if (i + nums[i] >= last) {
last = i;
}
}
return last == 0;
}
}
​
# 6. 개선 사항
이번 문제는 1시간 정도 고민해도 풀리지가 않아서 solution을 참고하였다. 그리디 알고리즘을 이용해서 푸는 해답으로 참고해서 학습하고 있는데 이해가 안되는 부분이 많다. 가끔 답지를 봐도 이해 못하는 부분이 많아서 고민이다. 나의 것으로 만들기 위해서 코드 하나하나를 뜯어가면서 공부해야겠다.
​