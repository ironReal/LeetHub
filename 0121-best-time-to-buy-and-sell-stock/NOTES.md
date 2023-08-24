​# 2. 문제 해석
가격[i]이 있는 배열 가격은 i일에 주어진 주식의 가격입니다.

한 주식을 매수하기 위해 하루를 선택하고 해당 주식을 매도하기 위해 미래의 다른 날을 선택함으로써 수익을 극대화하려고 합니다

이 거래에서 얻을 수 있는 **최대 수익을 반환**합니다. 이익을 얻을 수 없는 경우 0을 반환합니다.

입력: prices = [7,1,5,3,6,4]
출력: 5
설명: 2일차(가격 = 1)에 구매하고 5일차(가격 = 6)에 판매하고 이익 = 6-1 = 5.
판매하기 전에 구입해야 하므로 2일째에 구입하고 1일째에 판매할 수 없습니다.

# 3. 접근 방법
1. 최소 값과 최고 값을 구하기 위해 Math 라이브러리를 사용하여 최소값과 최대값을 구한다.
2. 배열을 순환하면서 최소값을 찾은 후에 그 다음으로 들어오는 최소값과 비교하여 최소값을 갱신한다.
3. 찾은 최소값과 현재 배열의 값을 비교하여 판매 이익이 최대 값과 비교하여 갱신한다.
# 4. 의사 코드
```
int 최소값 = 10 ^ 5;
int 결과값 = 0;

for (0, 배열 크기, 1씩 증가) {
		Math.min 함수 (최소값, 현재 날짜 값)으로 최소값 갱신
		Math.max 함수 (최대 수익, 현재 날짜 값 - 최소값)으로 최대 수익 갱신
}
결과값 반환;
```
# 5. 문제 해결
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}
```
# 5. 개선 사항
Math 클래스를 사용하지 않고 구현하는 방법
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            pist = prices[i] - min;
            if (op < pist) {
                op = pist;
            }
        }

        return op;
    }
}
```
기본적으로 제공하는 java 클래스를 사용해서 구현하는 방법이 좋을지 아니면 알고리즘 적으로 풀어서 문제를 해결해야하는 방향으로 가야할지 궁금하다. 알고리즘을 이용해서 풀어서 작성하는 방법이 익숙해지면 java 클래스를 푸는 방법으로 나아가야 할듯 하다.
