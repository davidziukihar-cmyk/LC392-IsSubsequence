import java.util.*;

public class Solution {
    private Map<Character, List<Integer>> map = null;

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

    public boolean isSubsequenceDP(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        fillMap(t);
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) return false;
            List<Integer> list = map.get(s.charAt(i));
            int current = upperBound(list, prev);
            if (current == -1) {
                return false;
            }
            prev = current;
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
        int high = arr.size(); // Включаем длину массива для корректного выхода

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) <= target) {
                low = mid + 1; // Ищем в правой половине
            } else {
                high = mid;    // Ищем левее, но mid остается кандидатом
            }
        }
        return low; // Индекс первого элемента, который > target
    }

}
