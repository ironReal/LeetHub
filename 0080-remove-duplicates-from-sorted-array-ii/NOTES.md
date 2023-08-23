# 문제 해석
정수 배열의 숫자가 감소하지 않는 순서로 정렬되어 있을 때, 각 고유 요소가 **최대 두 번만 나타나도록** 중복된 부분을 제자리에서 제거합니다. 요소의 상대적 순서는 동일하게 유지해야 합니다.

일부 언어에서는 배열의 길이를 변경할 수 없으므로 대신 결과를 배열 nums의 **첫 번째 부분**에 배치해야 합니다. 좀 더 공식적으로 말하자면, 중복을 제거한 후 요소가 k개 있는 경우 nums의 처음 k개 요소가 최종 결과를 보유해야 합니다. 첫 번째 k 요소 너머에 무엇이 남는지는 중요하지 않습니다.

최종 결과를 숫자의 첫 번째 k 슬롯에 배치한 후 k를 반환합니다.

다른 배열에 추가 공간을 할당하지 마세요. 입력 배열을 수정하여 O(1)의 추가 메모리로 제자리에서 수정해야 합니다.

# 접근 방법
처음에는 같은 값이 나올 때마다 counter를 이용해서 3번 이상 증가되면 다음 배열로 진행하는 식으로 접근하려고 했지만 구현하지 못하였다. 그래서 생각해본게 고정된 첫번째 배열 값과 1씩 증가하여 다음 배열의 값을 찾는 비교 연산자가 필요하다. 두 개의 인덱스 값을 서로 감산하여 1을 넘지 않는지 확인한다. 1이 넘는다는 건 같은 값이 2번 이상 나왔다는 것이다. 2번 이상 나오지 않고 고정된 값과 증가된 값의 배열의 값이 같으면 k번째에 증가된 배열의 값을 삽입한다.
# 의사 코드
```
반환할 값 = 0;
고정되는 값 = 0;
증가되는 값 = 0;

반복 (증가되는 값이 배열의 크기만큼) {
		if (고정된 인덱스의 값과 증가되는 인덱스의 값이 같지 않으면) {
				고정된 값 인덱스 = 증가되는 값 인덱스 -> 중복되는 값이 아니라는 뜻
		}
		
		if (고정된 값 - 증가된 값 <= 1 && 같은 배열의 값) {
				배열[반환할 값 ++] = 배열[현재 위치의 값];
			}
			
		움직이는 값++;
}
```
# 문제 해결
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        int fix = 0;    // 고정 값
        int slide = 0;  // 이동 값

        // 배열의 길이만큼 반복
        while (slide < nums.length) {
            // 중복이 되지 않는 값이라면 고정 값을 이동 값으로 변경
            if(nums[fix] != nums[slide]) {
                fix = slide;
            }
            // 중복 되는 값이 3개 이상이거나 서로 중복되는 값인지 비교
            if (slide - fix <= 1 && nums[fix] == nums[slide]) {
                nums[current++] = nums[slide];
            }
            
            slide++;
        }
        return current;
    }
}
```
    
# 개선 사항
배열을 이용해서 하는 문제들은 보통 two pointer 문제들이 많은거 같다. 개념은 이해하고 있지만 막상 구현하려고 하니 문제마다 다르게 구현해야 한다는 점이 어렵게 느껴진다. 같은 개념을 활용하는 많은 문제들을 접하면서 two pointer 문제들에 대해 익숙해져야겠다. 
```java
public int removeDuplicates(int[] nums) {
    		//define at most k times of duplicate numbers
    		final int k = 2;

    		//check if it is an empty array
    		if(nums.length == 0) return 0;

    		//start pointer of new array
    		int m = 1;

    		// count the time of duplicate numbers occurence
    		int count = 1;

    		for(int i = 1; i < nums.length; ++i) {
    			if(nums[i] == nums[i - 1]) {
    				if(count < k) {
    					nums[m++] = nums[i];
    				}
    				count++;
    			} else {
    				count = 1;
    				nums[m++] = nums[i];
    			}
    		}
    		return m;
    	}
```
내가 생각했던 count를 이용해서 푼 해답을 보고 나니깐 어떻게 풀어야 할 지 감이 잡혔다. count를 이용해서 푸는 방법도 어떻게 하면 좋을지 한번 더 생각해보고 고민해봐야겠다.
