int end = 0;
int sum = 0;
int minLength = Integer.MAX_VALUE;
​
while (end < nums.length) {
sum += nums[end++];
​
while (sum >= target) {
minLength = Math.min(minLength, end - start);
sum -= nums[start++];
}
}
​
return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
}
```
​
# 개선 사항
슬라이딩 윈도우를 이용한 여러가지 방법들이 있지만 한가지 방법으로만 생각하다보니깐 어떤 식으로 접근해야할지 감이 잡히지 않았다. 30분 동안 고민을 해도 어떻게 활용해야할지 몰라서 Solutions를 참고하였다.
처음에 코드를 보았을 때 이해가 가지 않았지만 step 마다 따라가면서 도식화 해보니 감이 잡혔다.
이해가 되지 않는다면 직접 손으로 그려보는 습관을 들여야겠다.
​