# 2. 문제 해석
모든 대문자를 소문자로 변환하고 영숫자가 아닌 문자를 모두 제거한 후 앞뒤가 같은 경우 구문은 **팔린드롬**입니다. 영숫자 문자에는 문자와 숫자가 포함됩니다.

문자열 s가 주어지면 팔린드롬이면 true을 반환하고, 그렇지 않으면 false을 반환합니다
# 3. 접근 방법
투 포인터를 이용해서 첫번째 배열의 요소와 마지막 배열의 요소가 같은 문자열인지 비교하면서 왼쪽 인덱스 값과 오른쪽 인덱스 값을 조정한다.
*왼쪽 인덱스*는 i  값으로 1씩 증가하고 *오른쪽 인덱스*는 배열의 길이 - i - 1로 마지막 값으로 설정하여 i만큼 감소한다.

1. 일단 소문자로 비교해야하니깐 매개변수로 넘어온 문자열을 toLowerCase() 문법을 이용해서 소문자 문자열로 변경한다.
2. 그런 다음에 영숫자가 아닌 문자는 모두 제거해야하므로 정규표현식을 이용해서 나머지 특수기호들을 제거한 문자열을 새로 생성한다.
3. 문자열 하나씩을 비교하기 위해서 char 배열로 변환시켜준다.
4. 반복문을 돌면서 팔린드롬인지 판단한다.

# 4. 의사 코드
```
매개변수로 넘어온 문자열을 소문자로 변경한다.
소문자로 변경한 문자열을 정규표현식을 이용해서 영숫자만으로 이루어진 문자열로 변환한다.
영숫자로만 이루어진 문자열을 char 배열로 변환

 for (0, char 배열 길이, 1씩 증가) {
		 int 오른쪽 인덱스 값 = 배열 길이 - i - 1;
		 if (대칭되는 문자열이 다른 경우) {
				 false 반환;
		 }
 }
 
대칭되는 문자열이므로 true 반환;
```

# 5. 문제 풀이
```java
class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        char[] c = lower.toCharArray();

        for (int i = 0; i < c.length; i++) {
            int right = c.length - i - 1;

            if (c[i] != c[right]) {
                return false;
            }
        }

        return true;
    }
}
```
# 6. 개선 사항
```java
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
```
java의 클래스에서 제공하는 문법으로 3줄로 간단하게 끝내버리는 깔끔한 코드를 봤다.
강의에서 배웠던 것처럼 *거의 모든 언어에서 공통되는 연산을 사용*해서 풀어야하는게 맞지만 가독성면에서는 이런게 좋아보인다.
무조건 순회해서 풀어야겠다는 방식보단 이런 방법도 생각해서 풀어봐야겠다.​
