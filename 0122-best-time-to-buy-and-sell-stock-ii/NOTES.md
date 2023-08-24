int 합산;
if (어제 날짜 < 현재 날짜) {
합산에 저장 = 현재 날짜 - 어제 날짜;
}
}
합산 반환;
```
# 5. 문제 해결
```java
class Solution {
public int maxProfit(int[] prices) {
int result = 0;
for (int i = 1; i < prices.length; i++) {
// 전날 가격보다 다음 날 가격이 크다면
if (prices[i -1] < prices[i]) {
// 수익 적립
result += prices[i] - prices[i - 1];
}
}
}
}
```
# 6. 개선 사항
​
```java
public int maxProfit(int[] prices) {
int result = 0;
for (int i = 1; i <prices.length; i++) {
result += Math.max(prices[i] - prices[i -1], 0);
}
}
```
Math 클래스를 활용한 다른 답안이다. 0보다 크다면 수익이 난다는 의미이니깐 0과 비교하여 최대값을 찾고 result에 적립하는 구조이다.
내가 작성했던 분기문들은 중복되는 키워드가 많았고 if문에 분기가 많았다. 아무래도 한줄에 작성되는 이런 코드가 보기에 깔끔하기도 하고 직관적이라서 좋다. 리팩토링을 통해서 이렇게 간단하게 표현할 수 있도록 개선나가야겠다.
​