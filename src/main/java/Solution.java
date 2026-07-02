import java.util.*;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int subIterate = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(subIterate) == t.charAt(i)) {
                subIterate++;
                if (subIterate == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Character, List<Integer>> map = null;

    public boolean isSubsequenceDP(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        fillMap(t);
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) return false; // if HashMap not contains char from s - it is not a subsequence
            List<Integer> list = map.get(s.charAt(i));      // For character in s, get the list of its occurrences in t
            int current = upperBound(list, prev);           // Check if char from s has saved index in List not less, then previously matched char
            if (current == -1) {
                return false;
            }
            prev = current; // Save the index where the current character was found in t
        }
        return true;

    }

    private void fillMap(String t) {
        map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                map.put(c, new ArrayList<>(List.of(i)));
            }
        }
    }

    public static Integer upperBound(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) <= target) {
                low = mid + 1; // will search in right half
            } else {
                high = mid;    // Search in left half, mid will be included
            }
        }
        return low; // index of first element that > target
    }

}
