## 392. Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


```
Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
```

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


_Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to
see if t has its subsequence. In this scenario, how would you change your code?_

## Solutions
### 1.Two pointers 
The straightforward solution is quite simple - you can see it in the ```isSubsequence()``` method. We have pointer
```subIterate```, that tracks the current "successful" position in the string s.
And just iterate t string, if current char from s equals char from t, we note to use next char from s on next t iteration step
(increase pointer subIterate). If subIterate reach length of s, then s is a subsequence of t.

### Complexity
The time complexity is O(n). Where n is the lengths of the string t.  
The size complexity - O(1).

### 2. Preprocessing + Binary Search
### Complexity
For second scenario - when string t is permanent, we can get O(n) for preparing additional map.
And O(n log(k)) for solving task. k - is the average number of occurrences of each character in t.
log(p) - the binary search complexity.

### Approach
From t make additional map<Character, list<Integer>, where key - each of char t, and value - List of places that char in
string t.:
```
"abayxca":  
'a' -> [0,2,6]  
'b' -> [1]  
'y' -> [3]  
'x' -> [4]  
'c' -> [5]
```
then iterate chars in string s and find it in HashMap. If char don't exist in hashMap - it is not subsequence.
We save previous found position in ```prev``` variable and find next 
char only in that part of List<Integer> of map, that index more than prev.
For that we use binnary search like upperBound.  
For example in case ```s = "aya"``` when we will find last a, our prev will be 3 (result for searching y), so we will use
only [..., 6] part from 'a' -> [0,2,6].
Full explanation you can see here https://leetcode.ca/2016-12-26-392-Is-Subsequence/
