//Leetcode Hard: https://leetcode.com/problems/regular-expression-matching/
class Regular {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        return tryMatch(0, 0, s, p, dp);
    }

    public boolean tryMatch(int i, int j, String s, String p, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        if (j == p.length()) {
            dp[i][j] = (i == s.length()) ? 1 : 2;
            return i == s.length();
        }

        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            boolean result = (tryMatch(i, j + 2, s, p, dp) || (match && tryMatch(i + 1, j, s, p, dp)));
            dp[i][j] = result ? 1 : 2;
            return result;
        } else {
            boolean result = (match && tryMatch(i + 1, j + 1, s, p, dp));
            dp[i][j] = result ? 1 : 2;
            return result;
        }
    }
}
