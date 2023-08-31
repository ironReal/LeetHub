​# 2. 문제
두 문자열 `s`와 `t`가 주어지면 `t`가 `s`의 애너그램이면 `참`을 반환하고, 그렇지 않으면 `거짓`을 반환합니다.

**애너그램**은 다른 단어나 구의 글자를 재배열하여 만든 단어 또는 구문으로, 일반적으로 원래 글자를 모두 정확히 한 번 사용합니다.

## 2.1 Example
**Example 1:**

Input: s = "anagram", t = "nagaram"
Output: true

**Example 2:**

Input: s = "rat", t = "car"
Output: false

**Follow up:** 입력에 유니코드 문자가 포함되어 있다면 어떻게 해야 할까요? 이러한 경우 솔루션을 어떻게 조정하시겠습니까?


# 3. 접근 방법
1. 인자로 넘어온 두개의 문자열을 char로 쪼개면 int 값이 나오니깐 그걸 이용해서 생각해보았다.
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int temp : sChar) {
            sSum += temp;
        }

        for (int temp : tChar) {
            tSum += temp;
        }

        return sSum == tSum;
    }
}
```

문자열을 합쳐서 서로 같은 문자열이면 true를 반환하도록 해보았는데 문자열이 다르더라도 합계가 같아버리면 true로 나오기 때문에 테스트의 실패하였다. 예를 들면 "ac", "bb"는 97+99 == 98 +98로 같은 합계로 떨어져버린다.

2. 두번째 방법은 char 배열로 변환시킨 두개의 문자열을 Arrays.sort라는 정렬을 이용해서 비교하는 방법이다. 자바의 라이브러리를 사용하는 방법이라 복잡도면에서 좋지 않겠지만 짧은 코드로 구현할 수 있다는 장점이 있다.


# 4. 의사 코드
```
문자열을 캐릭터 배열로 변환;

캐릭터 배열 정렬;

두개의 캐릭터 배열이 같은 배열이면 true 반환;
```

# 5. 문제 풀이

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }
}
```
