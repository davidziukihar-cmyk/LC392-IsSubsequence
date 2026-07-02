import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void isSubsequence() {
        Solution solution = new Solution();

        Assertions.assertTrue(solution.isSubsequence("abc","ahbgdc"));
        Assertions.assertFalse(solution.isSubsequence("axc","ahbgdc"));

        Assertions.assertTrue(solution.isSubsequence("abc","acbahbgdc"));
    }

    @Test
    void isSubsequenceDP() {
        Solution solution = new Solution();

        Assertions.assertTrue(solution.isSubsequenceDP("abc","ahbgdc"));
        Assertions.assertFalse(solution.isSubsequenceDP("axc","ahbgdc"));

        Assertions.assertTrue(solution.isSubsequenceDP("abc","acbahbgdc"));
    }
}