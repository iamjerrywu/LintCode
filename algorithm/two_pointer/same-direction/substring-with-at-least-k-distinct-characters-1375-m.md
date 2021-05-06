# Substring With At Least K Distinct Characters 1375 \(M\)

## Problem

Given a string `S` with only lowercase characters.

Return the number of substrings that contains at least `k` distinct characters.

1. 10 ≤ length\(S\) ≤ 1,000,000
2. 1 ≤ k ≤ 26

Example

**Example 1:**

```text
Input: S = "abcabcabca", k = 4
Output: 0
Explanation: There are only three distinct characters in the string.
```

**Example 2:**

```text
Input: S = "abcabcabcabc", k = 3
Output: 55
Explanation: Any substring whose length is not smaller than 3 contains a, b, c.
    For example, there are 10 substrings whose length are 3, "abc", "bca", "cab" ... "abc"
    There are 9 substrings whose length are 4, "abca", "bcab", "cabc" ... "cabc"
    ...
    There is 1 substring whose length is 12, "abcabcabcabc"
    So the answer is 1 + 2 + ... + 10 = 55.
```

## Solution 

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
