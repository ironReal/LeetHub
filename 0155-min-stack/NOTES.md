​# 2. 문제 해석
push, pop, top, minimum element 검색을 일정 시간 내에 지원하는 stackj을 설계하세요.

`MinStack` 클래스를 구현합니다:

- `MinStack()`은 스택 객체를 초기화합니다.
- `void push(int val)`는 요소 val을 스택에 밀어 넣습니다.
- `void pop()`은 스택의 맨 위에 있는 요소를 제거합니다.
- `int top()`는 스택의 최상위 요소를 가져옵니다.
- `int getMin()`은 스택의 최소 요소를 검색합니다.
각 함수에 대해 `O(1)` 시간 복잡도를 가진 솔루션을 구현해야 합니다.

## 2.1 Example
**Input**
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

**Output**
[null,null,null,null,-3,null,0,-2]

**Explanation**
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

# 3. 접근 방법
stack에 push로 값이 저장될 때마다 최소값도 같이 저장하는 또 다른 stack을 이용해서 최소값을 저장한다.

1. 최소값만을 저장할 stack을 하나 생성하고 그 stack안에 값읇 비교할 인수를 하나 저장한다.
2. Minstack에 push() 호출 시 인자로 넘어온 수와 최소값에 저장된 stack에 값과 비교하여 최소값 < 인자라면 최소값을 stack에 push()한다.
3. Micstack이 pop() 호출 시 꺼낼 지 값과 최소값 stack에 peek() 값이 같다면 최소값 stack 값도 pop()하여 최소값을 제거한다.
4. Minstack에 getMin() 시에는 최소값 stack 담겨져있는 값, 즉 stack push() 될 수록 작은 값들이 나중에 쌓이게 되니깐 peek() 값을 통해 제일 최소값을 호출한다.

# 4. 의사 코드
```
값들을 저장할 배열;
마지막에 인덱스를 가르킬 top 포인터;
스택의 크기;
최소값을 저장할 stack 선언;

생성자() {
		스택의 크기 선언;
		배열 선언 = 스택의 크기;
		top 포인터 초기화;
		최소값 stack 생성;
}
public void push(int val) {
		if (최소값의  stack peek() 값 보다 인자 값이 작다면) {
				최소값 stack에 인자값 push();
		}
		
		배열에 저장;
}

public void pop() {
		if (배열에 top에 위치한 값과 최소값 stack에 peek() 값이 같을 경우) {
				최소값 stack도 pop();
		}
		
		배열에 top 포인터에 담겨져 있는 객체 삭제;
		top 크기 줄이기;
}

public int top() {
		배열 top 포인터 값 반환;
}

public int getMin() {
		최소값 stack에 peek() 값 반환;
}
```
# 5. 풀이 방법
```java
class MinStack {
    int[] array;
    int top;
    int capacity;

    Stack<Integer> minStack = new Stack();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        capacity = 10;
        top = -1;
        array = new int[capacity];
    }
    
    public void push(int val) {
        if (min > val) {
            minStack.push(val);
            min = val;
        }

        array[++top] = val;
    }
    
    public void pop() {
        if (array[top] == min) {
            minStack.pop();
        }
        array[top--] = 0;
    }
    
    public int top() {
        return array[top];
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

<img width="504" alt="image" src="https://github.com/ironReal/LeetHub/assets/46087207/3fda5e45-5163-4ac1-9dcf-d34ac8aed0af">


# 6. 개선 사항
배열과 stack 2가지로 이용해서 문제를 해결하다보니 배열의 순서와 최소값 stack에 있는 값을 비교하고 저장하는 거 자체가 불필요한 행동이라는 걸 깨달았다.
굳이 배열을 만들어서 할 필요가 있을까?
기존에 stack을 이용해서 최소값을 알 수 있는 기능이 추가된 클래스를 만드는게 이 문제의 목적이였다.
```java
 class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (min >= val) {
            stack.push(min);
            min = val;
        }

        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
```
