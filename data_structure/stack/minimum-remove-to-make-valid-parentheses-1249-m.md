# Minimum Remove to Make Valid Parentheses 1249 \(M\)

## Problem



Given a string s of `'('` , `')'` and lowercase English characters. 

Your task is to remove the minimum number of parentheses \( `'('` or `')'`, in any positions \) so that the resulting _parentheses string_ is valid and return **any** valid string.

Formally, a _parentheses string_ is valid if and only if:

* It is the empty string, contains only lowercase characters, or
* It can be written as `AB` \(`A` concatenated with `B`\), where `A` and `B` are valid strings, or
* It can be written as `(A)`, where `A` is a valid string.

**Example 1:**

```text
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
```

**Example 2:**

```text
Input: s = "a)b(c)d"
Output: "ab(c)d"
```

**Example 3:**

```text
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
```

**Example 4:**

```text
Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
```

**Constraints:**

* `1 <= s.length <= 10^5`
* `s[i]` is one of  `'('` , `')'` and lowercase English letters`.`

## Solution - Stack / String Builder

Stack store '\(', id\_stack stores those need to be removed \(either the '\(' or '\)'\)

If '\(' already in there, then it can compensate the latest '\)'

### Code

{% tabs %}
{% tab title="python" %}
```python
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        id_stack = []
        for i, c in enumerate(s):
            if c == '(':
                stack.append(c)
                id_stack.append(i)
            elif c == ')' and stack:
                stack.pop()
                id_stack.pop()
            elif c == ')' and not stack:
                id_stack.append(i)   
        
        id_set = set(id_stack)
        ans = ''
        for i, c in enumerate(s):
            if i not in id_set:
                ans+=c
        return ans
```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity: O\(n\)**
  * Traverse String O\(n\)
  * Traver id\_stack O\(i\)
    * i: those id that need to be removed 
* **Space Complexity: O\(n\)**
  * Stack: worst case O\(n\)
  * id\_stack: worst case O\(n\)
  * list: O\(n\)

## Solution - Balance Calculating 

Two pass: 

* 1st traversal: Eliminate all invalid '\)' 
  * Only '\(\)' is eligible
* then reverse string
* 2nd traversal: Eliminate all invalid '\('
  * Only '\)\(' is eligible

### Code

{% tabs %}
{% tab title="python" %}
```python
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        s = self.delete_invalid_closing(s, '(', ')')
        s = self.delete_invalid_closing(s[::-1], ')', '(')
        return s[::-1]
    
    def delete_invalid_closing(self, s, open_symbol, close_symbol):
        sb = []
        balance = 0
        for c in s:
            if c == open_symbol:
                balance+=1
            if c == close_symbol:
                if balance == 0:
                    continue
                balance-=1
            sb.append(c)
        return ''.join(sb) 
```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity: O\(1\)**
  * 
* **Space Complexity: O\(1\)**
  * 

