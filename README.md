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


_Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?_

### Solutions
Straightforward solution is pretty easy - you can see it in isSubsequence() method. The time complexity is O(m + n). 
Where m and n are the lengths of the strings s and t respectively.

For second scenario - when string t is permanent, we can get O(n) for preparing additional map. And O(n log(k)) for solving task. k - is the average number of occurrences of each character in t.

From t make additional map<Character, list<Integer> where key - each of char t, and value - List of places that char in string t.:
```
"abayxca":  
'a' -> [0,2,6]  
'b' -> [1]  
'y' -> [3]  
'x' -> [4]  
'c' -> [5]
```
then iterate char in string s and find it in HahMap. For cases when we try find same char few times we save previous found position in ```int prev``` and find next char only in that part of List<Integer> of map, that index more then prev.
For that we use binnary find like upperBound.  
For example in case ```s = "aya"``` when we will find last a, our prev will be 3 (result for searching y), so we will use only [..., 6] part from 'a' -> [0,2,6].
Full explanation you can see here https://leetcode.ca/2016-12-26-392-Is-Subsequence/
