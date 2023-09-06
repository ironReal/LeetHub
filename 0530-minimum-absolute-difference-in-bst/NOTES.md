# 2. 문제 해석
이진 검색 트리(BST)의 `root`가 주어졌을 때, 트리에 있는 서로 다른 두 노드의 값 사이의 최소 절대 차이를 반환합니다.

## 2.1 Example
**Example 1:**

![image](https://github.com/ironReal/LeetHub/assets/46087207/25a51a23-5286-4dc7-97bc-e0d8984c7bca)
Input: root = [4,2,6,1,3]
Output: 1

**Example 2:**

![image](https://github.com/ironReal/LeetHub/assets/46087207/084c1658-f7f3-4fca-9330-1a8d68dd0bf2)
Input: root = [1,0,48,null,null,12,49]
Output: 1


# 3. 문제 접근
- 트리를 전체 순회하면서 노드가 가지고 있는 값들 사이의 최소값을 찾는 문제이다. 
- 이진 검색 트리는 좌측에는 부모 노드보다 작은 자식 노드들이 존재하고 우측에는 부모 노드보다 큰 값들이 존재하므로 정렬되어 있는 상태이다. 
- 재귀 함수를 이용하여 루트 노드에서 리프 노드까지 내려가서 노드가 가지고 있는 값과 그 이전에 노드들의 값을 비교하여 최소값을 비교하여 루트 노드까지 도달하면 재귀를 멈춘다.

# 4. 의사 코드
```
이전 노드의 val를 저장할 인수를 최대값으로 선언;
결과 값으로 사용할 인수를 최대값으로 선언;

최종 결과 메서드(트리 노드) {
    재귀함수(노드);
    결과값 리턴;
}

void 최소값을 찾을 재귀 함수(노드) {
    if (왼쪽 자식 노드가 존재한다면) {
        재귀 함수(왼쪽 자식 노드);
    }

    최소값 = 최소값 비교(결과값, 절대값(현재 노드의 값 - 이전 노드의 값));
    이전 노드 값 = 현재 노드의 값으로 변경;

    if (오른쪽 자식 노드가 존재한다면) {
        재귀 함수(오른쪽 자식 노드); 
    }
}
```
​

# 5. 문제 풀이
```java
class Solution {
    private int prev = Integer.MAX_VALUE;
    private int answer = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        searchMin(root);
        return answer;
    }

    public void searchMin(TreeNode node) {
        if (node.left != null) {
            searchMin(node.left);
        }

        answer = Math.min(answer, Math.abs(node.val - prev));
        prev = node.val;

        if (node.right != null) {
            searchMin(node.right);
        }   
    }    
    
}
```
