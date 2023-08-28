# 2. 문제 해석
링크된 목록의 머리인 `head`가 주어지면 링크된 목록에 사이클이 있는지 확인합니다.

다음 포인터를 계속 따라가면 다시 도달할 수 있는 노드가 목록에 있는 경우 연결된 목록에 사이클이 있습니다. 내부적으로 `pos`는 꼬리의 `다음` 포인터가 연결된 노드의 인덱스를 나타내는 데 사용됩니다. `pos`는** 파라미터로 전달되지 않는다는 점에 유의하세요.**

연결된 목록에 사이클이 있으면 `true`을 반환합니다. 그렇지 않으면 `false`를 반환합니다.
# 2.1 Example
입력: head = [3,2,0,-4], pos = 1
출력: true
설명: linked list에는 꼬리가 첫 번째 노드(0 인덱싱)에 연결되는 사이클이 있습니다.

# 3. 문제 접근
pos 값은 따로 주어저지 않고 배열이 순회하는지 확인하기 위해서 head의 val 변수에 제약조건 최대치 값을 할당한다.
노드의 next를 통해서 head 값을 다음 노드까지 진행시킨다.
마지막 노드의 다음 노드가 null인지 아니면 순회하는 노드인지 확인해서 결과를 반환한다.

# 4. 의사 코드
```
while (다음 노드가 null이 아닐 때까지) {
		if(현재 노드의 val 값이 저장된 변수라면) {
				true 반환;
		}
		
		해당 노드의 val 값 설정;
		head를 노드의 다음값으로 할당
}

다음 노드가 없다면 false;
```
# 5. 문제 풀이
<img width="450" alt="image" src="https://github.com/ironReal/LeetHub/assets/46087207/3c9911e3-2c21-41eb-beeb-fa918f87e4ac">

만약 마지막 4번 노드까지 도달 했을때,
다음 노드가 없다면 head.next는 null를 반환 할 것이고,
순회하면 노드라면 저장된 val 값과 일치하여 true를 반환 할 것이다.


```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 100000) {
                return true;
            }

            head.val = 100000;
            head = head.next;
        }
        return false;
    }
}
```
​
