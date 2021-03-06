# Implement Queue by Two Stacks 40 \(M\)

## Problem

As the title described, you should only use two stacks to implement a queue's actions.

The queue should support `push(element)`, `pop()` and `top()` where pop is pop the first\(a.k.a front\) element in the queue.

Both pop and top methods should return the value of first element.

Suppose the queue is not empty when the pop\(\) function is called.Example

**Example 1:**

Input:

```text
Queue Operations = 
    push(1)
    pop()    
    push(2)
    push(3)
    top()    
    pop()  
```

Output:

```text
1
2
2
```

Explanation:

Both pop and top methods should return the value of the first element.

**Example 2:**

Input:

```text
Queue Operations = 
    push(1)
    push(2)
    push(2)
    push(3)
    push(4)
    push(5)
    push(6)
    push(7)
    push(1)
```

Output:

```text
[]
```

Explanation:

There is no output.Challenge

implement it by two stacks, do not use any other data structure and push, pop and top should be O\(1\) by _AVERAGE_.

## Solution 

### Code

{% tabs %}
{% tab title="python" %}
```python
class MyQueue:
    
    def __init__(self):
        # do intialization if necessary
        self.stack1 = []
        self.stack2 = []
    """
    @param: element: An integer
    @return: nothing
    """
    def push(self, element):
        # write your code here
        self.stack1.append(element)

    """
    @return: An integer
    """
    def pop(self):
        # write your code here
        if self.stack2:
            return self.stack2.pop()
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    """
    @return: An integer
    """
    def top(self):
        # write your code here
        if self.stack2:
            return self.stack2[-1]
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity:**
* **Space Complexity:**

