# 2. 문제 해석
이진 검색 트리의 `root`와 정수 `k`가 주어졌을 때, 트리에 있는 모든 노드의 값 중 가장 작은 값(**1-색인된**)을 반환합니다.

# 3. 접근 방법
BST는 inorder로 순회하면 오름차순으로 탐색할 수 있습니다.
모든 데이터를 List에 담아서 k번째의 값을 리턴하는 방법도 있지만, k번 째 데이터를 제외한 나머지 데이터를 굳이 저장해줄 필요가 없습니다.​
따라서 전역변수를 이용하여 방문한 지점마다 count를 해줍니다.
이 count가 k가 된다면, 그 때의 node의 value가 k번째 작은 데이터가 됩니다.​

# 4. 의사 코드
```
순회하면 k번째 위치를 찾기 위한 카운터 인수;
k번째 데이터를 담을 정답 인수;

재귀 함수 선언(노드, k번째 인수) {
    if (노드가 비어있다면) {
        return;
    }

    왼쪽 노드부터 순회;

    if (count와 k 같다면) {
        정답은 현재 노드의 val;
    }

    오른쪽 노드 순회;
}

```

# 5. 문제 해결
```java
class Solution {
    private int count = 1;
    private int answer = -1;

    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return answer;    
    }

    public void search(TreeNode node, int k) {
        if (node == null) {
            return ;
        }

        search(node.left, k);

        if (count++ == k) {
            answer = node.val;
        }

        search(node.right, k);
    }
}
```

# 6. 개선 사항
while문을 통해서 반복을 통해 정답을 찾아내는 코드이다. stack을 이용한다.

1. 주어진 TreeNode인 root에서 k번째로 작은 값을 찾는 문제이다.
  1.1. root의 자식 노드들 순차적으로 넣을 stack을 정의한다.
2. root가 null이 되기 전까지 root를 넣고, root에 root의 left Treenode를 넣어준다.

3. k가 0이 아닐 때 까지 반복하여 k번째로 작은 값을 찾는다.
   - stack에서 최근 넣은 TreeNode를 꺼내 지역 변수 n에 넣어준다.
   - k를 감소시킨 값이 0인 경우 n의 val 값이 k번째로 작은 값이므로, n.val의 값을 주어진 문제의 결과로 반환한다.
   - n의 right TreeNode를 지역 변수 right에 넣어준다.
   - right가 null이 아닐 때 까지 반복하여 stack에 right를 넣고, 다음으로 right에 right의 left TreeNode를 넣어준다.
4. 반복이 완료되면 해당 값이 존재하지 않으므로, -1을 주어진 문제의 결과로 반환한다.

```java
class Solution {

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    while (k != 0) {
      TreeNode n = stack.pop();
      if (--k == 0) {
        return n.val;
      }
      TreeNode right = n.right;
      while (right != null) {
        stack.push(right);
        right = right.left;
      }
    }
    return -1;
  }

}
```
