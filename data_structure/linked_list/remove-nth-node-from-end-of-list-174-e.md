# Remove Nth Node From End of List 174 \(E\)

## Problem

Given a linked list, remove the nth node from the end of list and return its head.

The minimum number of nodes in list is _n_.Example

```text
Example 1:
	Input: list = 1->2->3->4->5->null， n = 2
	Output: 1->2->3->5->null


Example 2:
	Input:  list = 5->4->3->2->1->null, n = 2
	Output: 5->4->3->1->null

```

Challenge

Can you do it without getting the length of the linked list?

## Solution - Calculate from length

### Code

{% tabs %}
{% tab title="python" %}
```python
"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @param head: The first node of linked list.
    @param n: An integer
    @return: The head of linked list.
    """
    def removeNthFromEnd(self, head, n):
        # write your code here
        if head == None:
            return None
        
        dummy = ListNode(None, head)
        
        #ahead
        ahead = dummy
        for _ in range(n + 1):
            ahead = ahead.next
        
        #target
        tar_pre = dummy
        while ahead:
            ahead = ahead.next
            tar_pre = tar_pre.next
        
        tar_pre.next = tar_pre.next.next
        
        return dummy.next
```
{% endtab %}

{% tab title="java" %}
```java
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if ( head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ahead = dummy;
        
        for ( int i = 0 ; i < n + 1 ; i ++ ) {
            ahead = ahead.next;
        }
        
        ListNode tar_pre = dummy;
        while(ahead != null) {
            ahead = ahead.next;
            tar_pre = tar_pre.next;
        }
        
        tar_pre.next = tar_pre.next.next;
        return dummy.next;
    }
}
```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity:**
* **Space Complexity:**

\*\*\*\*

## Solution - Slow Fast Pointer

### Code

{% tabs %}
{% tab title="python" %}
```python

```
{% endtab %}

{% tab title="java" %}
```

```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity:**
* **Space Complexity:**
