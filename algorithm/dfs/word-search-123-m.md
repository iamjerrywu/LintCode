# Word Search 123 \(M\)

## Problem

Given a 2D board and a string word, find if the string word exists in the grid.

The string word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.

The same letter cell may not be used more than once.

The dimension of the letter matrix does not exceed 100, and the length of the string does not exceed 100.Example

**Example 1:**

Input:

```text
board = ["ABCE","SFCS","ADEE"]word = "ABCCED"
```

Output:

```text
true
```

Explanation:

\[  
A B C E  
S F C S  
A D E E  
\]  
\(0,0\)-&gt;\(0,1\)-&gt;\(0,2\)-&gt;\(1,2\)-&gt;\(2,2\)-&gt;\(2,1\)

**Example 1:**

Input:

```text
board = ["z"]word = "z"
```

Output:

```text
true
```

Explanation:

\[ z \]  
\(0,0\)

## Solution - DFS

### Code

{% tabs %}
{% tab title="python" %}
```python
DIRECTIONS = [(1, 0), (-1, 0), (0, 1), (0, -1)]
class Solution:
    """
    @param board: A list of lists of character
    @param word: A string
    @return: A boolean
    """
    def exist(self, board, word):
        # write your code here
        if not word:
            return True

        prefix_words = self.get_prefix_words(word)
        visited = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                visited.add((i, j))
                if self.dfs(i, j, board, board[i][j], word, prefix_words, visited):
                    return True
                visited.remove((i, j))
        return False
    
    def dfs(self, x, y, board, cur_word, word, prefix_words, visited):
        print(cur_word)
        if cur_word not in prefix_words:
            return False
        if len(cur_word) >= len(word):
            return True
        for dx, dy in DIRECTIONS:
            new_x = x + dx
            new_y = y + dy
            if not self.is_valid(new_x, new_y, board, visited):
                continue
            visited.add((new_x, new_y))
            if self.dfs(new_x, new_y, board, cur_word + board[new_x][new_y], word, prefix_words, visited):
                return True
            visited.remove((new_x, new_y))
        return False

    def is_valid(self, x, y, board, visited):
        if x < 0 or x >= len(board) or y < 0 or y >= len(board[0]) or (x, y) in visited:
            return False
        return True   
    
    def get_prefix_words(self, word):
        prefix_words = set()
        for i in range(len(word)):
            prefix_words.add(word[:i + 1])
        return prefix_words
```
{% endtab %}
{% endtabs %}

### Complexity Analysis

* **Time Complexity:**
* **Space Complexity:**

