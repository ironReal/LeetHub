​# 2. 문제 해석
정수 배열 번호가 지정되면 배열을 k 단계만큼 오른쪽으로 회전합니다. 여기서 k는 음수가 아닙니다.
# 3. 접근 방법
문제의 제목처럼 순환하는 배열로 만들고자 했지만 한칸씩 이동하게 되는 코드는 시간복잡도가 많이 나오거나 재귀함수를 이용해야 할 거 같아서 최대한 단순하게 생각해보았다.
k의 수 만큼 뒤에 있는 배열이 앞으로 이동하는 형태이니깐 이동되는 값과 고정되는 값을 쪼개서 생각을 해보았다. 임시 배열을 하나 만들어서 nums에 배열에서 수를 재조합하여 다시 nums로 복사하는 방법을 사용하였다.
# 4. 의사 코드
```java
int 임시 배열 = nums 배열 길이만큼 생성;
k = nums 배열의 나머지 값;

for (0, k 크기만큼, 1씩 증가) {
		임시 배열 = nums에 이동할 배열을 순차적으로 담기
}

int 카운터;
for (k, nums 배열 크기, 1씩 증가) {
		임시 배열 = 나머지 nums의 수를 순차적으로 담기
}

for (0, 배열 크기, 1씩 증가) {
		nums = 임시배열
}
```
# 5. 문제 풀이
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            temp[i] = nums[j++];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
```
# 6. 개선 사항
for문이 많이 있어서 아무래도 보기가 안좋다. 메서드를 통해서 코드를 깔끔하게 보이면서 다음과 같이 개선 할 수있다.
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
				
				// 첫 번째 n-k 요소를 뒤집습니다.
        reverseArray(nums, 0, n - k - 1);
				// 나머지 요소는 반대로 바꿉니다.
        reverseArray(nums, n - k, n - 1);
				// 전체 배열을 뒤집습니다.
        reverseArray(nums, 0, n - 1);
    }
    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

배열을 오른쪽으로 k 단계씩 회전하려면 3단계 접근 방식을 사용할 수 있습니다.
1. 배열의 첫 번째 n-k 요소를 반전시킵니다. 
2. 그런 다음 나머지 k 요소를 반전시킵니다. 
3. 마지막으로 전체 배열을 반전시킵니다. 이 접근 방식을 사용하면 추가 공간을 사용하지 않고도 제자리에서 회전을 수행할 수 있습니다.
