# 2. 문제 해석
이미 **감소하지 않는 순서로 정렬**된 정수의 **1 인덱스** 배열이 주어졌을 때, 특정 목표 수에 합산되는 두 개의 수를 구합니다. 이 두 숫자를 numbers[index1] 및 numbers[index2]로 하고, 1 <= index1 < index2 < numbers.length로 합니다.

두 개의 숫자 index1과 index2의 인덱스에 1을 더한 길이 2의 정수 배열 [index1, index2]를 반환합니다.

테스트는 정확히 하나의 해가 나오도록 생성됩니다. 동일한 요소를 두 번 사용할 수 없습니다.

솔루션은 일정한 추가 공간만 사용해야 합니다.
## 2.1 Example
입력: 숫자들 = [2,7,11,15], 목표 = 9
출력 [1,2]
설명: 2와 7의 합은 9입니다. 따라서 index1 = 1, index2 = 2입니다. 우리는 [1, 2]를 반환합니다.

# 3. 접근 방법
기본적으로 투포인트 알고리즘을 이용하여 접근한다. 
target의 값과 같은 값이 될 때까지 반복문을 반복한다.
예제를 보면 index1의 값은 고정된 위치에서 결과를 반환하고 하고 있어서 start 값은 고정하고 end 값만 변하면 된다.
배열의 인덱스 번호는 0부터 시작하므로 결과로 반환할 배열에 값을 담을 때는 인덱스 번호 + 1을 추가해서 반환한다.
# 4. 의사 코드
```j
int 시작값 = 0;
int 마지막값 = numbers.length - 1;
int[] 결과값 = 길이 2;

while (시작값 < 마지막값) {
		if (시작값 + 마지막값이 target 수와 일치한다면) {
				결과값 = 시작값의 해당 인덱스, 마지막값의 해당 인덱스;
		} else {
				마지막값--;
		}
		
		반환 결과괎;
}
```
# 5. 문제 해결
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
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

	return new int[] {l+1, r+1};
}
```

시작 값이 고정되어있는 내가 했던 해결과는 달리는 left와 right값이 taget 값과 비교하면서 답을 찾아간다.
배열의 해당 인덱스의 left값과 right 값을 더 해서 그 더한 값이 target 값보다 작다면 rigth 값을 1-- 해주고 target 값이 더 크다면 left를 1++ 한다.

코드를 더 깔끔하게 리팩토링 해서 직관적으로 보일 수 있게 코드를 수정해야겠다.
