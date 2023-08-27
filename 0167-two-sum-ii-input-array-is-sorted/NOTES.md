return result;
} else {
right--;
}
}
return result;
}
}
```
# 6. 개선 사항
```java
public int[] twoSum(int[] nums, int target) {
int l = 0, r = nums.length - 1;
while (nums[l] + nums[r] != target) {
if (nums[l] + nums[r] < target) l++;
else r--;
}
​
return new int[] {l+1, r+1};
}
```
​
시작 값이 고정되어있는 내가 했던 해결과는 달리는 left와 right값이 taget 값과 비교하면서 답을 찾아간다.
배열의 해당 인덱스의 left값과 right 값을 더 해서 그 더한 값이 target 값보다 작다면 rigth 값을 1-- 해주고 target 값이 더 크다면 left를 1++ 한다.
​
코드를 더 깔끔하게 리팩토링 해서 직관적으로 보일 수 있게 코드를 수정해야겠다.