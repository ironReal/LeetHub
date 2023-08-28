# 2. 문제 해석
문자열 s가 주어졌을 때, 가장 긴 문자열의 길이를 구합니다.
하위 문자열의 길이를 구합니다.
> 하위 문자열은 문자열 내에 비어 있지 않은 연속 문자 시퀀스입니다.
# 2.1 Example
입력: s = "abcabcbb"
출력: 3
설명: 답은 길이가 3인 "abc"입니다.

입력: s = "pwwkew"
출력: 3
설명: 답은 길이가 3인 "wke"입니다.
답은 부분 문자열이어야 하며, "pwke"는 부분 문자열이 아닌 시퀀스입니다.

# 3. 접근 방법
1. 같은 문자가 두번 이상 나오면 안된다.
2. 연속된 substring만을 카운팅 한다.

- 문자열을 반복하면서 같은 문자열이 나올때까지 반복한다.
- 중복되는 문자열이 나오면 처음 문자열을 없애고
- 저장된 문자열의 길이를 저장한다.
- 마지막 문자열까지 도달하면 저장된 문자열의 길이를 반환한다.

# 4. 의사 코드
```
시작 인덱스, 끝 인덱스 선언;
문자열의 길이;
문자열을 저장할 배열 선언;

while (끝 인덱스가 문자열의 길이만큼 반복) {
		if (중복되는 문자열이 없을 경우) {
				배열에 문자열 저장;
				끝 인덱스 증가;
				문자열 길이 비교;
		} else (중복되는 문자열 발견) {
				배열에 마지막에 저장되었던 문자열 제거;
				시작 인덱스 증가;
		}
}

문자열의 길이 반환;
```

# 5. 문제 해결

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;
        Set<Character> charSet = new HashSet<>();

        while (end < s.length()) {
            char sToChar = s.charAt(end);
            if (!charSet.contains(sToChar)) {
                charSet.add(sToChar);
                end++;
                length = Math.max(length, charSet.size());
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return length;
    }
}
```

- 중복으로 저장되는 값을 피하기 위해 Set 자료구조를 사용하였다.
- 중복된 문자열이 발견되었다면 가장 최근에 저장된 문자열을 제거한다.

- c까지 탐색했을 때, Set에는 'abc'가 저장되어 있다.
- 중복된 문자열인 'a'를 만나게 되면 'a'를 제거하고 'bc'가 남아있게 된다.
- 그떄 저장되어 있는 Set의 사이즈를 최대 크기를 비교하여 저장한다.

# 6. 개선 사항
```java
public int lengthOfLongestSubstring(String s) {
    int ret = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, start = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) 
            start = Math.max(map.get(c)+1, start);
        ret = Math.max(ret, i-start+1); 
        map.put(c, i);
    }
    return ret;
}
```

Map을 이용한 방법으로는 어떤 값이 어떤 위치에 저장되어 있는지 비교할 수 있다. Set이나 Map의 key는 중복되지 않는다는 점에서 비슷하다. 
Set과 달리 저장되어 있는 객체를 remove 하지 않고 덮어씌워버리면 되므로 메모리 활용면에서 좋을 듯하다.
