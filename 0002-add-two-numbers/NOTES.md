# 2. 문제 해석
음수가 아닌 정수 두 개를 나타내는 **비어 있지 않은** 링크된 목록 두 개가 주어집니다. 
숫자는 **역순**으로 저장되며 각 노드에는 단일 숫자가 포함됩니다. 
두 숫자를 더하고 그 합을 연결된 목록으로 반환합니다.

두 숫자에는 숫자 0을 제외하고 선행 0이 포함되지 않는다고 가정할 수 있습니다.
## 2.1 Example
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

# 3. 접근 방법
single Linked List 이므로 계속 다음 노드만 알 수 있다. 반복문을 통해 다음 노드가 없을 때까지 반복한다. 반복하면 다음과 같은 조건을 만족시킨다.
1. 반환할 `현재 노드`를 선언한다.
2. 매개변수로 주어진 두 개의 노드의 val 값을 더 한 값이 10을 넘기면 `현재 노드`의 다음 노드(next)의 val 값을 증가 시킨다.
3. '현재 노드`에 다음 노드를 생성해서 넘겨준다.
4.`현재 노드`를 `현재 노드.next`로 변경한다.
5. 다음 노드들로 진행 시키기 위해서 매개변수로 주어진 노드들의 l1.next, l2.next로 할당한다.

# 4. 의사 코드
```
현재 위치 노드 생성;
결과 노드 = 현재 위치 노드;
int 합계;

while (매개변수의 값들이 null이 아니거나 or 합계가 0보다 클 때까지) {
		if(매개변수1가 null이 아니면) {
				합계에 매개변수1.val 값 더하기
				매개변수1.next
		}
		
		if(매개변수2가 null이 아니면) {
				합계에 매개변수2.val 값 더하기
				매개변수2.next
		}
		
		현재 노드.next = 새로운 노드 생성(합계에 나머지 값);
		합계를 10으로 나누기;
		현재 노드를 현재 노드의 다음 노드로 할당;
}

결과 노드의 다음값 반환;
```

# 5. 문제 풀이
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
				// 매개변수 두 노드의 값들을 저장하고 다음 노드로 진행하는 current 노드
        ListNode current = new ListNode();
				// 반환할 노드에 current 노드로 설정한다.
        ListNode result = current;
				// val 값들을 저장할 변수
        int sum = 0;

				// sum 값이 남아있다면 다음 노드를 새로 생성한다
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

						// 현재 노드의 다음 노드를 새로 생성하고 sum 값으로 val에 인자로 넘긴다.
            current.next = new ListNode(sum % 10);
            sum /= 10;
            current = current.next;
        }

        return result.next;
    }
}
```
- sum 값이 0보다 크다는 얘기는 이전 노드들의 두 합이 10을 넘겼다는 의미로 다음 노드가 생성된다는 의미이다.
- 새로운 노드를 생성할 때는 10의 나머지 값을 넘겨주기 위해 sum % 10을 사용하였다.
- 다음 노드가 없거나 sum이 0이 될때까지 반복문을 진행한다.
- result의 값은 비어있으므로 current에 저장된 값으로 반환하기 위해 result.next로 반환한다.

# 6. 개선 사항
현재 노드의 다음 값을 반환한다는 접근을 하지 못해서 시간이 오래 걸렸다.
정답 코드와 유사하게 만들었지만 더 이상 생각이 나지 않아서 정답 코드를 확인하여 내가 생각했던 부분들을 다시 한번 정리하였다.
