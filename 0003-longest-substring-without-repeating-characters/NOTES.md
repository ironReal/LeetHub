답은 부분 문자열이어야 하며, "pwke"는 부분 문자열이 아닌 시퀀스입니다.
```
​
# 5. 문제 해결
​
```java
class Solution {
public int lengthOfLongestSubstring(String s) {
int start = 0;
int end = 0;
int length = 0;
Set<Character> charSet = new HashSet<>();
​
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
​
return length;
}
}
```
​
- 중복으로 저장되는 값을 피하기 위해 Set 자료구조를 사용하였다.
- 중복된 문자열이 발견되었다면 가장 최근에 저장된 문자열을 제거한다.
​
- c까지 탐색했을 때, Set에는 'abc'가 저장되어 있다.
- 중복된 문자열인 'a'를 만나게 되면 'a'를 제거하고 'bc'가 남아있게 된다.
- 그떄 저장되어 있는 Set의 사이즈를 최대 크기를 비교하여 저장한다.
​
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
​
Map을 이용한 방법으로는 어떤 값이 어떤 위치에 저장되어 있는지 비교할 수 있다. Set이나 Map의 key는 중복되지 않는다는 점에서 비슷하다.
Set과 달리 저장되어 있는 객체를 remove 하지 않고 덮어씌워버리면 되므로 메모리 활용면에서 좋을 듯하다.